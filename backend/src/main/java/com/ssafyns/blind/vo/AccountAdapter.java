package com.ssafyns.blind.vo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;
import java.util.Collection;

public class AccountAdapter extends User {

    private AccountVo accountVo;

    public AccountVo getAccount() {
        return accountVo;
    }

    public AccountAdapter(AccountVo account) {
        super(account.getAccountUsername(), account.getAccountPw(), authorities());
    }

    private static Collection<? extends GrantedAuthority> authorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
