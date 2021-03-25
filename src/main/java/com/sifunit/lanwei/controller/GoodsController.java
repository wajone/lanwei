package com.sifunit.lanwei.controller;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.FileUploadUtils;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.Goods;
import com.sifunit.lanwei.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsServiceImpl goodsServiceImpl;

    //添加产品
    @RequestMapping("goodsAdd")
    @ResponseBody
    public SysResult goodsAdd(@RequestParam("goodImages") MultipartFile[] files,
                              @RequestParam("goodName") String goodName,
                              @RequestParam("goodNum") String goodNum,
                              @RequestParam("goodSize") String goodSize,
                              @RequestParam("goodInnerRing") String goodInnerRing,
                              @RequestParam("goodDesc") String goodDesc) throws IOException {
        SysResult sysResult = new SysResult(false);
        String uploadPath = "E:/upload/";
        Goods goods = new Goods();
        StringBuffer imagesUrl = new StringBuffer();
        if (files.length > 0 ) {
            for(MultipartFile file: files) {
                if (!file.isEmpty()) {
                    //上传图片并把路径添加到imagesUrl
                    String ori = file.getOriginalFilename();
                    String imageUrl = FileUploadUtils.UploadPath + ori;
                    file.transferTo(new File(imageUrl));
                    imagesUrl.append(FileUploadUtils.MappingPath + ori);
                }
            }
            goods.setGoodImages(imagesUrl.toString());
        }
        if (goodName != null) {
            goods.setGoodName(goodName);
        }
        if (goodNum!= null) {
            goods.setGoodNum(goodNum);
        }
        if (goodSize != null) {

            goods.setGoodSize(goodSize);
        }

        if (goodInnerRing != null) {
            goods.setGoodInnerRing(goodInnerRing);
        }

        if (goodDesc != null) {
            goods.setGoodDesc(goodDesc);
        }

        if (goodsServiceImpl.insertSelective(goods) > 0) {
            sysResult.setResult(true);
            sysResult.setData("产品添加成功");
        } else {
            sysResult.setData("产品添加失败");
        }

        return sysResult;
    }

    @RequestMapping("page")
    public String page(Page page, Model model) {
        PageInfo pageInfo = goodsServiceImpl.getPageInfo(page, model);
        model.addAttribute("pageInfo", pageInfo);
        return "goods/goods_list";
    }

    @RequestMapping("toAdd")
    public String toAdd() {
        return "goods/goods_add";
    }

}
