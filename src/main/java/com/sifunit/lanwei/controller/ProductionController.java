package com.sifunit.lanwei.controller;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.domain.Customer;
import com.sifunit.lanwei.domain.Product;
import com.sifunit.lanwei.domain.Unit;
import com.sifunit.lanwei.service.ICustomerService;
import com.sifunit.lanwei.service.IProductService;
import com.sifunit.lanwei.service.IUnitService;
import com.sifunit.lanwei.service.impl.ProductionDetailService;
import com.sifunit.lanwei.vo.ProductionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
