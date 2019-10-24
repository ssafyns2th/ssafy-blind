package com.ssafyns.blind.service;

import com.ssafyns.blind.dto.BoardDto;
import com.ssafyns.blind.mapper.FreeboardMapper;
import com.ssafyns.blind.vo.FreeboardVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FreeboardService {
    private FreeboardMapper freeboardMapper;

    public FreeboardService(FreeboardMapper accountMapper){
        this.freeboardMapper = freeboardMapper;
    }

    //게시판 등록
    @Transactional
    public void createFreeboard(FreeboardVo freeboard){
        freeboardMapper.save(freeboard);
    }

    //게시판 목록 조회
    @Transactional
    public List<FreeboardVo> readFreeboards(){
        return freeboardMapper.findFreeboards();
    }

    //게시판 상세 조회
    @Transactional
    public FreeboardVo getFreeBoardOf(Long boardId){
        return freeboardMapper.findByBoardNo(boardId);
    }

    //게시판 수정
    @Transactional
    public void updateFreeboards(BoardDto boardDto){
        freeboardMapper.updateByBoardNo(boardDto);
    }

    //게시판 삭제
    @Transactional
    public void deleteFreeboards(Long boardId){
        freeboardMapper.deleteByBoardNo(boardId);
    }

    //(추가) 제목으로 게시물 찾기
    @Transactional
    public FreeboardVo findByWriter(String title){
        return freeboardMapper.findByTitle(title);
    }
}
