package com.ssafyns.blind.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@Alias("freeboard")
public class FreeboardVo {
    private Long freeboardNo;
    private String freeboardTitle;
    private String freeboardContent;
    private String freeboardDate;
    private int freeboardHits;
    private int freeboardLikes;
    private Long freeboardAccountId;

    public FreeboardVo(String freeboardTitle, String freeboardContent, String freeboardDate, int freeboardHits, int freeboardLikes, Long freeboardAccountId) {
        this.freeboardTitle = freeboardTitle;
        this.freeboardContent = freeboardContent;
        this.freeboardDate = freeboardDate;
        this.freeboardHits = freeboardHits;
        this.freeboardLikes = freeboardLikes;
        this.freeboardAccountId = freeboardAccountId;
    }
}
