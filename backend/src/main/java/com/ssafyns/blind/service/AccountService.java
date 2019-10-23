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
    public void createAccount(AccountVo account){
        AccountVo accountExists = accountMapper.selectByEmail(account.getAccountEmail());
        if(accountExists == null){
            accountMapper.save(account);
        } else {
            //예외처리
            //accountExists.orElseThrow(RuntimeException::new);
        }

    }
}
