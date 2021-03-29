package com.sifunit.lanwei.mapper;

import com.sifunit.lanwei.domain.GoodCate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodCateMapper extends IBaseMapper<GoodCate> {

    List<GoodCate> list();
}