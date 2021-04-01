package com.sifunit.lanwei.mapper;

import com.sifunit.lanwei.domain.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper extends IBaseMapper<Product> {

    List<Product> list();

    int getCountByNo(String productNo);
}