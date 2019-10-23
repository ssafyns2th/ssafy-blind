package com.ssafyns.blind.controller;

import com.ssafyns.blind.service.AccountService;
import com.ssafyns.blind.vo.Memeber;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(path = "/api/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "")
    public void SSAFYMemeber(@RequestBody List<Memeber> memberList){
        
    }
}
