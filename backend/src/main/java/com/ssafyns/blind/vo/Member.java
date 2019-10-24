package com.ssafyns.blind.vo;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private int id;
    private String name;
    private String username;
    private String active;
    private String avatar_url;
    private String web_url;
}
