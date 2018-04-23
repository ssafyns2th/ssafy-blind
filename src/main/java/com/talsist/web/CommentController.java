package com.talsist.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.talsist.dto.CommentDto;
import com.talsist.service.CommentService;

@Controller
public class CommentController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private CommentService commentSvc;

    public CommentController(CommentService commentSvc) {
        this.commentSvc = commentSvc;
    }

    @PostMapping("/board/{boardId}/comment")
    public String reply(@PathVariable Long boardId, String query, CommentDto commentDto) {
        commentSvc.save(commentDto, boardId);
        return "redirect:/board/" + boardId + "?" + query;
    }

    @PutMapping("/board/{boardId}/comment/{id}")
    public String modify(@PathVariable Long boardId, @PathVariable Long id, String query, CommentDto commentDto) {
        commentSvc.update(commentDto, id);
        return "redirect:/board/" + boardId + "?" + query;
    }

    @DeleteMapping("/board/{boardId}/comment/{id}")
    public String delete(@PathVariable Long boardId, @PathVariable Long id, String query) {
        try {
            commentSvc.delete(boardId, id);

        } catch (Exception e) {
            logger.info("댓글삭제오류: board-{}, comment-{}", boardId, id);
        }
        return "redirect:/board/" + boardId + "?" + query;
    }

}
