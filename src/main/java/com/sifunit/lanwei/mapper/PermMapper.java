package com.sifunit.lanwei.mapper;

import com.sifunit.lanwei.domain.Perm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermMapper extends IBaseMapper<Perm> {

    List<Perm> getPermList(Integer userId);
}