package com.sifunit.lanwei.mapper;

import com.sifunit.lanwei.domain.Labor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LaborMapper extends IBaseMapper<Labor> {

    List<Labor> list();
}