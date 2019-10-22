package com.ssafyns.blind.mapper;

import com.ssafyns.blind.vo.AccountVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountMapper {

    void save(AccountVo account);

    AccountVo selectByEmail(String email);

    AccountVo selectById(Long id);
}
