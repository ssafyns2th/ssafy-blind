package com.ssafyns.blind.controller;

import com.ssafyns.blind.service.AccountDetailsService;
import com.ssafyns.blind.vo.AccountVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.common.util.Jackson2JsonParser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class HomeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    AccountDetailsService accountDetailsService;

    @Test
    public void homeTest() throws Exception {
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


        ResultActions perform = this.mockMvc.perform(post("/oauth/token")
                .with(httpBasic("ssafy-blind", "pass"))
                .param("username", username)
                .param("password", password)
                .param("grant_type", "password"));
        String contentAsString = perform.andReturn().getResponse().getContentAsString();
        Jackson2JsonParser parser = new Jackson2JsonParser();
        String access_token = "Bearer " + parser.parseMap(contentAsString).get("access_token").toString();


        this.mockMvc.perform(get("/api")
                .header(HttpHeaders.AUTHORIZATION, access_token))
                .andDo(print())
                .andExpect(status().isOk());

    }

}