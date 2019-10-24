package com.ssafyns.blind.controller;

import com.ssafyns.blind.service.AccountService;
import com.ssafyns.blind.vo.AccountVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/accounts")
public class FbCommentController {
    private AccountService accountService;

    public FbCommentController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/ssafy/{username}")
    public ResponseEntity SSAFYMemeber(@PathVariable String username) {
//        if (memberList.size() == 0) {
//            //해당 사용자는 존재하지 않습니다.
//            return ResponseEntity.notFound().build();
//        } else if (memberList.size() == 1) {
//            Member memeber = memberList.get(0);
//            //중복확인
//
//            return ResponseEntity.ok(memeber.getUsername()); //puhehe99
//        } else {
//            //본인 ID를 풀네임으로 적어주세요.
//            return ResponseEntity.badRequest().build();
//        }

        AccountVo account = accountService.findByUsername(username);
        if(account == null) {
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }

    }
}
