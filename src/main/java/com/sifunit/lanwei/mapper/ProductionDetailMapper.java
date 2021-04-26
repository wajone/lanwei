package com.sifunit.lanwei.mapper;

import com.sifunit.lanwei.domain.Product;
import com.sifunit.lanwei.domain.Production;
import com.sifunit.lanwei.vo.ProductionDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductionDetailMapper extends IBaseMapper<Production> {

    List<ProductionDetail> list();

    List<Product> selectProductByProductionId(Long productionId);

    List<Product> selectProductByProductionNo(String productionNo);
}