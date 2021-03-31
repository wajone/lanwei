package com.sifunit.lanwei.controller;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.GoodCate;
import com.sifunit.lanwei.domain.ProductCate;
import com.sifunit.lanwei.service.IGoodCateService;
import com.sifunit.lanwei.service.IProductCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("productCate")
public class ProductCateController {
    @Autowired
    IProductCateService productCateService;

    @GetMapping("page")
    public String page(Page page, Model model) {
        PageInfo<ProductCate> pageInfo = productCateService.getPage(page, model);
        model.addAttribute("pageInfo", pageInfo);
        return "productCate/productCate_list";
    }

    @RequestMapping("add")
    @ResponseBody
    public SysResult add(ProductCate productCate) {
        SysResult sysResult = new SysResult(false);
        int count = productCateService.insertSelective(productCate);
        if (count > 0) {
            sysResult.setResult(true);
            sysResult.setData("添加成功!");
        } else {
            sysResult.setData("添加失败!");
        }
        return sysResult;
    }

    @GetMapping("toAdd")
    public String toAdd() {
        return "productCate/productCate_add";
    }

    @GetMapping("toUpdate")
    public String toUpdate(Long productCateId, Model model) {
        ProductCate productCate = productCateService.selectByPrimaryKey(productCateId);
        model.addAttribute("productCate", productCate);
        return "productCate/productCate_update";
    }

    @RequestMapping("update")
    @ResponseBody
    public SysResult update(ProductCate productCate) {
        SysResult sysResult = new SysResult(false);
        int count = productCateService.updateByPrimaryKeySelective(productCate);
        if (count > 0) {
            sysResult.setResult(true);
            sysResult.setData("修改成功!");
        } else {
            sysResult.setData("修改失败!");
        }
        return sysResult;
    }

    @GetMapping("delById")
    @ResponseBody
    public SysResult delById(Long productCateId) {
        SysResult sysResult = productCateService.delById(productCateId);
        return sysResult;
    }
}
