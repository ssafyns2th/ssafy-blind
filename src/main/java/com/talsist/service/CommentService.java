package com.talsist.service;

import com.talsist.domain.Comment;
import com.talsist.domain.User;
import com.talsist.exception.NotAllowedException;
import com.talsist.repository.BoardRepository;
import com.talsist.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private BoardRepository boardRepo;
    @Autowired
    private CommentRepository commentRepo;

    @Transactional
    public void save(Comment comment, User user, Long boardId) {
        if (comment.getReplyRoot().longValue() == 0) {
            comment.setUser(user);
            comment.setBoard(boardRepo.findOne(boardId));
            Comment saved = commentRepo.save(comment);
            saved.initReplyRoot();
            commentRepo.save(saved);

        } else {
            List<Comment> targets = findTargets(boardRepo.findOne(boardId).getComments(), comment);
            Long replyOrder = findReplyOrder(targets, comment);

            // comment가 들어갈 자리 이후의 comment order 값 증가
            targets.stream()
                    .filter(c -> c.getReplyOrder() >= replyOrder)
                    .forEach(c -> c.setReplyOrder(c.getReplyOrder() + 1));
            commentRepo.save(targets);

            comment.adjustDepthAndOrder();
            comment.setUser(user);
            comment.setBoard(boardRepo.findOne(boardId));
            comment.setReplyOrder(replyOrder);
            commentRepo.save(comment);
        }
    }

    public void update(Comment reqComment, Long commentId, Long userId) throws NotAllowedException {
        Comment comment = commentRepo.findOne(commentId);
        permissionCheck(comment, userId);
        comment.update(reqComment);
        commentRepo.save(comment);
    }

    @Transactional
    public void delete(Long boardId, Long commentId, Long userId) throws NotAllowedException {
        Comment comment = commentRepo.findOne(commentId);
        permissionCheck(comment, userId);

        List<Comment> targets = findTargets(boardRepo.findOne(boardId).getComments(), comment);
        Long replyOrder = findReplyOrder(targets, comment);

        List<Comment> delList = targets.stream()
                .filter(c -> c.getReplyOrder() < replyOrder).collect(Collectors.toList());

        commentRepo.delete(comment);
        commentRepo.delete(delList);

        targets.removeAll(delList);
        targets.forEach(c -> c.setReplyOrder(c.getReplyOrder() - replyOrder + comment.getReplyOrder()));
        commentRepo.save(targets);
    }

    private List<Comment> findTargets(List<Comment> comments, Comment comment) {
        // 요청 댓글 다음 요소부터 대상을 찾는다
        return comments.stream()
                .filter(c -> c.getReplyRoot() == comment.getReplyRoot() && c.getReplyOrder() > comment.getReplyOrder())
                .collect(Collectors.toList());
    }

    private Long findReplyOrder(List<Comment> targets, Comment comment) {
        return (comment.getReplyDepth().longValue() == 0) ?
                // 최상위 depth 처리
                targets.stream().mapToLong(c -> c.getReplyOrder() + 1).max().orElse(comment.getReplyOrder() + 1) :
                // 같은 depth인 바로 다음 댓글과 depth + 1인 마지막 댓글 또는 현재 댓글 + 1의 순서중 선택 됨
                targets.stream().filter(c -> c.getReplyDepth() == comment.getReplyDepth())
                        .mapToLong(c -> c.getReplyOrder()).min().orElse(targets.stream()
                        .filter(c -> c.getReplyDepth() == comment.getReplyDepth() + 1)
                        .mapToLong(c -> c.getReplyOrder() + 1).max().orElse(comment.getReplyOrder() + 1));
    }

    private void permissionCheck(Comment comment, Long userId) throws NotAllowedException {
        if (!comment.verifyUser(userId)) {
            throw new NotAllowedException();
        }
    }

}