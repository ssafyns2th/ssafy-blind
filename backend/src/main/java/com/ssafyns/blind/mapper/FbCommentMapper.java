package com.ssafyns.blind.mapper;

import com.ssafyns.blind.vo.FreeboardVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FbCommentMapper {

    void save(FreeboardVo freeboard);

    FreeboardVo selectByTitle(String title);

    FreeboardVo selectByAccountId(Long accountId);
}
