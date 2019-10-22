package com.ssafyns.blind.vo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@Builder
@NoArgsConstructor
@Alias("account")
public class AccountVo {
    private Long accountId;
    private String accountEmail;
    private String accountPw;
    private String eduCity;
    private int th;
    private int nickname;
    private int isleave;

    public AccountVo(String accountEmail, String accountPw, String eduCity, int th, int nickname, int isleave) {
        this.accountEmail = accountEmail;
        this.accountPw = accountPw;
        this.eduCity = eduCity;
        this.th = th;
        this.nickname = nickname;
        this.isleave = isleave;
    }
}
