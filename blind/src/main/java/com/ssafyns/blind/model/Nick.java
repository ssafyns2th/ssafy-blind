package com.ssafyns.blind.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "nicktable")
@Getter @Setter @ToString @NoArgsConstructor
public class Nick {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nick_id;

    @Column
    private String nickname;

    public Nick(String nickname) {
        this.nickname = nickname;
    }
}
