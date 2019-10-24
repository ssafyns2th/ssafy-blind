package com.ssafyns.blind.service;

import com.ssafyns.blind.mapper.FbCommentMapper;
import com.ssafyns.blind.mapper.FreeboardMapper;
import com.ssafyns.blind.vo.FreeboardCommentVo;
import com.ssafyns.blind.vo.FreeboardVo;
import org.springframework.transaction.annotation.Transactional;

public class FbCommentService {
    private FbCommentMapper fbCommentMapper;

    public FbCommentService(FbCommentMapper fbCommentMapper){
        this.fbCommentMapper = fbCommentMapper;
    }

    @Transactional
    public void createComment(FreeboardCommentVo comment){
        fbCommentMapper.save(comment);
    }

}
