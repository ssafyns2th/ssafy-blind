package com.ssafyns.blind.mapper;

import com.ssafyns.blind.service.AccountDetailsService;
import com.ssafyns.blind.vo.AccountVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class AccountMapperTest {

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    AccountDetailsService accountDetailsService;

    @Test
    public void selectByEmail() {
        String accountEmail = "test1@test.com";
        AccountVo account = AccountVo.builder()
                .accountUsername("test1")
                .accountEmail(accountEmail)
                .accountPw("1111")
                .eduCity("Seoul")
                .isleave(0)
                .nickId(1)
                .th(1).build();
        accountDetailsService.saveAccount(account);
        assertThat(accountMapper.selectByEmail(accountEmail)).isNotNull();
    }

    @Test
    public void selectById() {
        String accountEmail = "test@test.com";
        AccountVo account = AccountVo.builder()
                .accountUsername("test2")
                .accountEmail(accountEmail)
                .accountPw("1111")
                .eduCity("Seoul")
                .isleave(0)
                .nickId(1)
                .th(1).build();
        accountDetailsService.saveAccount(account);
        AccountVo accountVo = accountMapper.selectById(1L);
        assertThat(accountVo).isNotNull();
    }
}