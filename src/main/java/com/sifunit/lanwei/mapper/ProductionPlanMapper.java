package com.sifunit.lanwei.mapper;

import com.sifunit.lanwei.domain.ProductionPlan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductionPlanMapper extends IBaseMapper<ProductionPlan> {
    List<ProductionPlan> list();
}