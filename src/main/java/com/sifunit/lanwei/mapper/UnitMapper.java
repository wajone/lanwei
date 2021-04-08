package com.sifunit.lanwei.mapper;

import com.sifunit.lanwei.domain.Unit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UnitMapper extends IBaseMapper<Unit> {
    List<Unit> list();
}