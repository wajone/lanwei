package com.sifunit.lanwei.service;

import com.sifunit.lanwei.domain.MaterialCate;
import com.sifunit.lanwei.vo.ProceCateTree;
import com.sifunit.lanwei.vo.ProductCateTree;

import java.util.List;

public interface ICateService {
    List<ProceCateTree> getProceCateTree();

    List<ProductCateTree> getProductCateTree();

    List<MaterialCate> getMaterialCateTree();
}
