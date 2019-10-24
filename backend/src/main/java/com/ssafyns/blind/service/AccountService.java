package com.ssafyns.blind.service;

import com.ssafyns.blind.mapper.AccountMapper;
import com.ssafyns.blind.vo.AccountVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
    private AccountMapper accountMapper;

    public AccountService(AccountMapper accountMapper){
        this.accountMapper = accountMapper;
    }

    @Transactional
    public AccountVo findByUsername(String username){
        return accountMapper.selectByUsername(username);
    }
}
