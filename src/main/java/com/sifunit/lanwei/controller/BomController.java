package com.sifunit.lanwei.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.*;
import com.sifunit.lanwei.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("bom")
public class BomController {
    @Autowired
    IBomService bomService;
    @Autowired
    IProgressService progressService;
    @Autowired
    IProductService productService;
    @Autowired
    IUnitService unitService;
    @Autowired
    IMaterialService materialService;
    @Autowired
    IProcedureService procedureService;
    @Autowired
    IProductionService productionService;

    @GetMapping("page")
    public String list(Page page, Model model) {
        PageInfo<Bom> pageInfo = bomService.getPageInfo(page, model);
        model.addAttribute("pageInfo", pageInfo);
        return "bom/bom_list";
    }


    @RequestMapping("add")
    @ResponseBody
    public SysResult add(@RequestBody String  bomjson) {
        SysResult sysResult = new SysResult();
        JSONObject jsonObject = JSON.parseObject(bomjson);
        List<Bom> boms = new LinkedList<>();
        JSONArray bomArray =  jsonObject.getJSONArray("boms");
        for (int i = 0 ; i < bomArray.size();i++){
            // 取出当前的节点并且赋值给 jsonObject
            JSONObject jsobj = bomArray.getJSONObject(i);
            Bom bom = jsobj.toJavaObject(Bom.class);
            boms.add(bom);
        }
        System.out.println(boms);
        List<Progress> progress = new LinkedList<>();
        JSONArray progressArray =  jsonObject.getJSONArray("proces");
        for (int i = 0 ; i < progressArray.size();i++){
            // 取出当前的节点并且赋值给 jsonObject
            JSONObject jsobj = progressArray.getJSONObject(i);
            Progress pro = jsobj.toJavaObject(Progress.class);
            progress.add(pro);
        }
        int bcount = bomService.insertBoms(boms);
        int pcount = progressService.insertProress(progress);
        if (bcount > 0 && pcount > 0) {
            sysResult.setResult(true);
            sysResult.setData("添加成功!");
        } else {
            sysResult.setResult(false);
            sysResult.setData("添加失败!");
        }

        return sysResult;
    }

    @GetMapping("toAdd")
    public String toAdd(Model model) {
        PageInfo<Unit> units = unitService.listUnits();
        //获取所有产品信息，下一步可以实行分页返回数据，全端用流加载，目前还没找到解决办法，先全部返回
        PageInfo<Product> products = productService.listProducts();
        PageInfo<Material> materials = materialService.listMaterials();
        PageInfo<Procedure> proces = procedureService.listproces();
        PageInfo<Production> productions = productionService.listproductions();
        model.addAttribute("units", units);
        model.addAttribute("productions", productions);
        model.addAttribute("proces", proces);
        model.addAttribute("products", products);
        model.addAttribute("materials", materials);
        return "bom/bom_add";
    }

    @GetMapping("toUpdate")
    public String toUpdate(Long laborId, Model model) {
        Bom bom = bomService.selectByPrimaryKey(laborId);
        model.addAttribute("bom", bom);
        return "labor/labor_update";
    }

    @RequestMapping("update")
    @ResponseBody
    public SysResult update(Bom bom) {
        SysResult sysResult = new SysResult();
        int count = bomService.updateByPrimaryKeySelective(bom);
        if (count > 0) {
            sysResult.setResult(true);
            sysResult.setData("修改成功!");
        } else {
            sysResult.setResult(false);
            sysResult.setData("修改失败!");
        }
        return sysResult;
    }

}
