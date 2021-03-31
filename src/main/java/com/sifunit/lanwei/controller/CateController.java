package com.sifunit.lanwei.controller;

import com.sifunit.lanwei.common.Layui;
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
    public Layui getProceCateTree() {
        List<ProceCateTree> list = cateService.getProceCateTree();
        return Layui.data(list.size(), list);
    }

    @RequestMapping("getProceCateTree")
    @ResponseBody
    public Layui getProductCateTree() {
        List<ProductCateTree> list = cateService.getProductCateTree();
        return Layui.data(list.size(), list);
    }
}
