package com.sifunit.lanwei.mapper;

import com.sifunit.lanwei.domain.Procedure;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProcedureMapper extends IBaseMapper<Procedure> {

    List<Procedure> list();
}