package com.ssafyns.blind.service;

import com.ssafyns.blind.mapper.AccountMapper;
import com.ssafyns.blind.vo.AccountAdapter;
import com.ssafyns.blind.vo.AccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AccountDetailsService implements UserDetailsService {

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void saveAccount(AccountVo accountVo) {
        accountVo.setAccountPw(this.passwordEncoder.encode(accountVo.getAccountPw()));
        this.accountMapper.save(accountVo);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountVo account = accountMapper.selectByUsername(username);
        if (account == null) throw new UsernameNotFoundException(username);
        return new AccountAdapter(account);
    }

    private Collection<? extends GrantedAuthority> authorities() {

        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));

    }
}
