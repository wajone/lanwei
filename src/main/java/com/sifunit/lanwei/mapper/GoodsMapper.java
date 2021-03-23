package com.sifunit.lanwei.mapper;

import com.sifunit.lanwei.domain.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper extends IBaseMapper<Goods>{
    List<Goods> list();
}