package com.ssafyns.blind.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@Alias("freeboard_comment")
public class FreeboardCommentVo {
    private Long fbcommentNo;
    private String fbcommentContent;
    private String fbcommentDate;
    private int fbcommentLikes;
    private Long fbcommentFreeboardNo;
    private Long fbcommentAccountId;

    public FreeboardCommentVo(String fbcommentContent, String fbcommentDate, int fbcommentLikes, Long fbcommentFreeboardNo, Long fbcommentAccountId) {
        this.fbcommentContent = fbcommentContent;
        this.fbcommentDate = fbcommentDate;
        this.fbcommentLikes = fbcommentLikes;
        this.fbcommentFreeboardNo = fbcommentFreeboardNo;
        this.fbcommentAccountId = fbcommentAccountId;
    }
}
