package com.sifunit.lanwei.service;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.ProductCate;
import org.springframework.ui.Model;

public interface IProductCateService extends IBaseService<ProductCate> {
    PageInfo<ProductCate> getPage(Page page, Model model);

    SysResult delById(Long productCateId);
}
