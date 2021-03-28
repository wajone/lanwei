package com.sifunit.lanwei.mapper;

import com.sifunit.lanwei.domain.MaterialCate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MaterialCateMapper extends IBaseMapper<MaterialCate> {
    List<MaterialCate> list();
}