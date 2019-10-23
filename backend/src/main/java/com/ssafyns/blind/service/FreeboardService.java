package com.ssafyns.blind.service;

import com.ssafyns.blind.mapper.FreeboardMapper;
import com.ssafyns.blind.vo.AccountVo;
import com.ssafyns.blind.vo.FreeboardVo;
import org.springframework.transaction.annotation.Transactional;

public class FreeboardService {
    private FreeboardMapper freeboardMapper;

    public FreeboardService(FreeboardMapper accountMapper){
        this.freeboardMapper = freeboardMapper;
    }

    @Transactional
    public void createFreeboard(FreeboardVo freeboard){
        freeboardMapper.save(freeboard);
    }
    @Transactional
    public FreeboardVo findByTitle(String title){
        return freeboardMapper.selectByTitle(title);
    }
    @Transactional
    public FreeboardVo findByWriter(long writerId){
        return freeboardMapper.selectByAccountId(writerId);
    }
}
