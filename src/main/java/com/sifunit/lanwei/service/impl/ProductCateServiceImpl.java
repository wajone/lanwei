package com.sifunit.lanwei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.GoodCate;
import com.sifunit.lanwei.domain.ProductCate;
import com.sifunit.lanwei.domain.SysDept;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.mapper.ProductCateMapper;
import com.sifunit.lanwei.service.IProductCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ProductCateServiceImpl extends BaseServiceImpl<ProductCate> implements IProductCateService {
    @Autowired
    ProductCateMapper productCateMapper;

    @Override
    public IBaseMapper<ProductCate> getMapper() {
        return productCateMapper;
    }

    @Override
    public PageInfo<ProductCate> getPage(Page page, Model model) {
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<ProductCate> list = productCateMapper.list();
        PageInfo<ProductCate> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public SysResult delById(Long productCateId) {
        long count = productCateMapper.selectCountById(productCateId);
        SysResult sysResult = new SysResult(false);

        if (count > 0) {
            sysResult.setData("删除失败！");
        } else {
            ProductCate productCate = new ProductCate();
            productCate.setProductCateId(productCateId);
            productCate.setFlag(false);
            productCateMapper.updateByPrimaryKeySelective(productCate);
            sysResult.setResult(true);
        }
        return sysResult;
    }
}
