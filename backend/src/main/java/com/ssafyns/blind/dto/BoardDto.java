package com.ssafyns.blind.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@NoArgsConstructor
@Alias("BoardDto")
public class BoardDto {
    private Long freeboardNo;
    private String freeboardTitle;
    private String freeboardContent;
    private int freeboardHits;
    private int freeboardLikes;
}
