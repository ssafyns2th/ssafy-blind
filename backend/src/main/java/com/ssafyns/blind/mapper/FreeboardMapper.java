package com.ssafyns.blind.mapper;

import com.ssafyns.blind.dto.BoardDto;
import com.ssafyns.blind.vo.AccountVo;
import com.ssafyns.blind.vo.FreeboardVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FreeboardMapper {

    void save(FreeboardVo freeboard);

    List<FreeboardVo> findFreeboards();

    FreeboardVo findByBoardNo(Long freeboardNo);

    void updateByBoardNo(BoardDto boardDto);

    void deleteByBoardNo(Long freeboardNo);

    FreeboardVo findByTitle(String title);
}
