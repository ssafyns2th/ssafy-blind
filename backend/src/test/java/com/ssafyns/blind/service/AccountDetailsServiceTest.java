package com.ssafyns.blind.service;

import com.ssafyns.blind.vo.AccountVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class AccountDetailsServiceTest {

    @Autowired
    AccountDetailsService accountDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void findByUsername() {
        String username = "username";
        String password = "1111";
        AccountVo account = AccountVo.builder()
                .accountUsername(username)
                .accountEmail("email@email.com")
                .accountPw(password)
                .th(1)
                .isleave(0)
                .eduCity("Seoul")
                .nickId(1)
                .build();
        accountDetailsService.saveAccount(account);
        // When
        UserDetailsService userDetailsService = accountDetailsService;
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        // Then
        assertThat(this.passwordEncoder.matches(password,userDetails.getPassword())).isTrue();

    }

}