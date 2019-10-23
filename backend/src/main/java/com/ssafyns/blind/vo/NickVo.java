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
@Alias("nicktable")
public class NickVo {
    private Long nickId;
    private String nickname;

    public NickVo(String nickname) {
        this.nickname = nickname;
    }
}
