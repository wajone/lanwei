package com.sifunit.lanwei.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.*;
import com.sifunit.lanwei.service.*;
import com.sifunit.lanwei.service.impl.ProductionDetailService;
import com.sifunit.lanwei.vo.ProductionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("pro")
public class ProductionController {

    @Autowired
    ProductionDetailService productionDetailService;
    @Autowired
    ICustomerService customerService;
    @Autowired
    IUnitService unitService;
    @Autowired
    IProductService productService;
    @Autowired
    IProductionService productionService;
    @Autowired
    IProductionContentService productionContentService;

    @GetMapping("page")
    public String list(Page page, Model model) {
        PageInfo<ProductionDetail> pageInfo = productionDetailService.getPageInfo(page, model);
        System.out.println(pageInfo.getList());
        model.addAttribute("pageInfo", pageInfo);
        return "production/production_list";
    }

    @GetMapping("toAdd")
    public String toAdd(Model model) {
        PageInfo<Customer> customers = customerService.listCustomers();
        PageInfo<Unit> units = unitService.listUnits();
        PageInfo<Product> products = productService.listProducts();

        model.addAttribute("customers", customers);
        model.addAttribute("products", products);
        model.addAttribute("units", units);
        return "production/production_add";
    }

    @RequestMapping("add")
    @ResponseBody
    public SysResult add(@RequestBody String  json) {
        SysResult sysResult = new SysResult();
        System.out.println(json);
        JSONObject jsonObject = JSON.parseObject(json);
        Production production = jsonObject.getObject("production", Production.class);
        List<ProductionContent> productionContents = new LinkedList<>();
        JSONArray jsonArray =  jsonObject.getJSONArray("productionContents");
        for (int i = 0 ; i < jsonArray.size();i++){
            // 取出当前的节点并且赋值给 jsonObject
            JSONObject jsobj = jsonArray.getJSONObject(i);
            System.out.println(jsobj.toJSONString());
            ProductionContent productionContent = jsobj.toJavaObject(ProductionContent.class);
            productionContents.add(productionContent);
        }
        System.out.println(production);
        int count = productionService.insertSelective(production);
        System.out.println(count);
        if (count > 0) {
            for (ProductionContent productionContent : productionContents) {
                productionContent.setProductionId(new Long(production.getProductionId()));
                int count2 = productionContentService.insertSelective(productionContent);
                if (count2 == 0){
                    sysResult.setResult(false);
                    sysResult.setData("添加生产单细节失败!");
                    return sysResult;
                }
            }
            sysResult.setResult(true);
            sysResult.setData("添加生产单成功!");

        } else {
            sysResult.setResult(false);
            sysResult.setData("添加生产单失败!");
        }

        return sysResult;
    }

    @RequestMapping("selectProductByProductionId")
    @ResponseBody
    public List<Product> selectById(Long productionId){
        System.out.println(productionId);
        List<Product> products = productionDetailService.selectProductByProductionId(productionId);
        for (Product product : products) {
            System.out.println(product.getProductId());
        }
        return products;
    }
}
