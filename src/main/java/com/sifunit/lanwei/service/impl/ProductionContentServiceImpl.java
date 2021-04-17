package com.sifunit.lanwei.service.impl;

import com.sifunit.lanwei.domain.ProductionContent;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.mapper.ProductionContentMapper;
import com.sifunit.lanwei.service.IProductionContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductionContentServiceImpl extends BaseServiceImpl<ProductionContent> implements IProductionContentService {

    @Autowired
    ProductionContentMapper productionContentMapper;

    @Override
    public IBaseMapper getMapper() {
        return productionContentMapper;
    }
}
