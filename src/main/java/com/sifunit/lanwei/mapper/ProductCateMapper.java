package com.sifunit.lanwei.mapper;

import com.sifunit.lanwei.domain.GoodCate;
import com.sifunit.lanwei.domain.ProductCate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductCateMapper extends IBaseMapper<ProductCate> {
    List<ProductCate> list();

    int selectCountById(Long productCateId);
}