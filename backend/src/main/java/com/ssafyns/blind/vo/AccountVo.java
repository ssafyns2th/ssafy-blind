package com.ssafyns.blind.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Alias("account")
public class AccountVo {
    private Long accountId;
    private String accountEmail;
    private String accountPw;
    private String eduCity;
    private int th;
    private int nickId;
    private int isleave;

    public AccountVo(String accountEmail, String accountPw, String eduCity, int th, int nickId, int isleave) {
        this.accountEmail = accountEmail;
        this.accountPw = accountPw;
        this.eduCity = eduCity;
        this.th = th;
        this.nickId = nickId;
        this.isleave = isleave;
    }
}
