package com.sifunit.lanwei.mapper;

import com.sifunit.lanwei.domain.ProceCate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProceCateMapper extends IBaseMapper<ProceCate> {

    List<ProceCate> list();

}