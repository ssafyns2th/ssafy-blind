package com.ssafyns.blind.config;

import com.ssafyns.blind.service.AccountDetailsService;
import com.ssafyns.blind.vo.AccountVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class AuthServerConfigTest {

    @Autowired
    AccountDetailsService accountDetailsService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getOauthToken() throws Exception {
        String username = "ssafy";
        String password = "1111";
        AccountVo account = AccountVo.builder()
                .accountUsername(username)
                .accountEmail("test@test.com")
                .accountPw(password)
                .eduCity("Seoul")
                .isleave(0)
                .nickId(1)
                .th(1).build();
        accountDetailsService.saveAccount(account);

        String clientId = "ssafy-blind";
        String clientSecret = "pass";
        this.mockMvc.perform(post("/oauth/token")
                    .with(httpBasic(clientId, clientSecret))
                    .param("username",username)
                    .param("password",password)
                    .param("grant_type","password"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("access_token").exists())
                ;

    }
}