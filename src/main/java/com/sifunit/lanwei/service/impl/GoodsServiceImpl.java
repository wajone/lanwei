package com.sifunit.lanwei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.domain.Goods;
import com.sifunit.lanwei.mapper.GoodsMapper;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Service
public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public IBaseMapper getMapper() {
        return goodsMapper;
    }

    @Override
    public PageInfo getPageInfo(Page page, Model model) {
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<Goods> list = goodsMapper.list();
        PageInfo<Goods> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public boolean handleUpload(MultipartFile[] files) {
        if (files == null) {
            
        }
        return false;
    }
}
