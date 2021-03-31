package com.sifunit.lanwei.service.impl;

import com.sifunit.lanwei.mapper.CateMapper;
import com.sifunit.lanwei.service.ICateService;
import com.sifunit.lanwei.vo.ProceCateTree;
import com.sifunit.lanwei.vo.ProductCateTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CateServiceImpl implements ICateService {
    @Autowired
    CateMapper mapper;

    @Override
    public List<ProceCateTree> getProceCateTree() {
        return mapper.getProceCateTree();
    }

    @Override
    public List<ProductCateTree> getProductCateTree() {
        return mapper.getProductCateTree();
    }
}
