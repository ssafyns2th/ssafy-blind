package com.ssafyns.blind.controller;

import com.ssafyns.blind.dto.BoardDto;
import com.ssafyns.blind.service.AccountService;
import com.ssafyns.blind.service.FreeboardService;
import com.ssafyns.blind.vo.AccountVo;
import com.ssafyns.blind.vo.FreeboardVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/board/free")
public class FreeboardController {
    private FreeboardService freeboardService;

    public FreeboardController(FreeboardService freeboardService) {
        this.freeboardService = freeboardService;
    }

    // 게시판 목록 조회
    @GetMapping(value = "")
    public ResponseEntity readFreeboardList() {
        List<FreeboardVo> freeboardList = freeboardService.readFreeboards();
        return ResponseEntity.ok(freeboardList);
    }

    // 게시판 등록
    @PostMapping(value = "")
    public ResponseEntity createFreeboard(FreeboardVo freeboardVo) {
        freeboardService.createFreeboard(freeboardVo);
        return ResponseEntity.ok().build();
    }

    //게시판 상세 조회
    @GetMapping(value = "/{boardid}")
    public ResponseEntity readFreeboard(@PathVariable Long boardId) {
        FreeboardVo freeboardVo = freeboardService.getFreeBoardOf(boardId);
        return ResponseEntity.ok(freeboardVo);
    }

    //게시판 수정
    @PutMapping(value = "/{boardid}")
    public ResponseEntity updateFreeboard(@PathVariable Long boardId, @RequestBody BoardDto boardDto) {
        freeboardService.updateFreeboards(boardDto);
        return ResponseEntity.ok().build();
    }

    //게시판 삭제
    @DeleteMapping(value = "/{boardid}")
    public ResponseEntity deleteFreeboard(@PathVariable Long boardId) {
        freeboardService.deleteFreeboards(boardId);
        return ResponseEntity.ok().build();
    }
}
