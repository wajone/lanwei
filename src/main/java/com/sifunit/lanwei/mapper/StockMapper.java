package com.sifunit.lanwei.mapper;

import com.sifunit.lanwei.domain.Stock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StockMapper extends IBaseMapper<Stock> {
    List<Stock> list();

    Long getStockNumByNo(String materialNo);
}