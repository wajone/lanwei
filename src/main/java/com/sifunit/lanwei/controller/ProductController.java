package com.sifunit.lanwei.controller;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.Product;
import com.sifunit.lanwei.domain.Stock;
import com.sifunit.lanwei.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    IProductService productService;

    //添加产品
    @RequestMapping("add")
    @ResponseBody
    public SysResult goodsAdd(@RequestParam(value = "productImages", required = false) MultipartFile[] files,
                              @RequestParam("productName") String productName,
                              @RequestParam("productNo") String productNo,
                              @RequestParam("productSize") String productSize,
                              @RequestParam("attachInfo") String attachInfo,
                              @RequestParam("productDesc") String productDesc,
                              @RequestParam("productCateId") long productCateId,
                              @RequestParam("productCateName") String productCateName) throws IOException {
        SysResult sysResult = productService.addProduct(files, productName, productNo, productCateName,
                productCateId, productSize, productDesc, attachInfo);

        return sysResult;
    }

    @RequestMapping("page")
    public String page(Page page, Model model) {
        PageInfo pageInfo = productService.getPageInfo(page, model);
        model.addAttribute("pageInfo", pageInfo);
        return "product/product_list";
    }

    @RequestMapping("toAdd")
    public String toAdd() {
        return "product/product_add";
    }

    @GetMapping("toUpdate")
    public String toUpdate(Long productId, Model model) {
        Product product = productService.selectByPrimaryKey(productId);
        model.addAttribute("product", product);
        return "product/product_update";
    }

    @RequestMapping("update")
    @ResponseBody
    public SysResult update(Product product) {
        SysResult sysResult = new SysResult(false);
        int count = productService.updateByPrimaryKeySelective(product);
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
    public SysResult delById(Long productId) {
        SysResult sysResult = productService.delById(productId);
        return sysResult;
    }
}
