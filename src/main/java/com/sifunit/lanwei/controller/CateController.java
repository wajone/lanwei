package com.sifunit.lanwei.controller;

import com.sifunit.lanwei.common.Layui;
import com.sifunit.lanwei.domain.MaterialCate;
import com.sifunit.lanwei.service.ICateService;
import com.sifunit.lanwei.vo.ProceCateTree;
import com.sifunit.lanwei.vo.ProductCateTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("cate")
public class CateController {
    @Autowired
    ICateService cateService;

    @RequestMapping("getProceCateTree")
    @ResponseBody
    public List<ProceCateTree>  getProceCateTree() {
        List<ProceCateTree> list = cateService.getProceCateTree();
        return list;
    }

    @RequestMapping("getProductCateTree")
    @ResponseBody
    public List<ProductCateTree> getProductCateTree() {
        List<ProductCateTree> list = cateService.getProductCateTree();
        return list;
    }

    @RequestMapping("getMaterialCateTree")
    @ResponseBody
    public Layui getMaterialCateTree() {
        List<MaterialCate> list = cateService.getMaterialCateTree();
        return Layui.data(list.size(), list);
    }

}
