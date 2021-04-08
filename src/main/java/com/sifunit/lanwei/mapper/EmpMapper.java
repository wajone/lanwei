package com.sifunit.lanwei.mapper;

import com.sifunit.lanwei.domain.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper extends IBaseMapper<Emp> {
   List<Emp> list();
}