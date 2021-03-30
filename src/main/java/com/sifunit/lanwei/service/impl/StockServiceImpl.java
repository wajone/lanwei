package com.sifunit.lanwei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.domain.Stock;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.mapper.StockMapper;
import com.sifunit.lanwei.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class StockServiceImpl extends BaseServiceImpl<Stock> implements IStockService {
    @Autowired
    StockMapper stockMapper;
    @Override
    public IBaseMapper<Stock> getMapper() {
        return stockMapper;
    }

    @Override
    public PageInfo<Stock> getPage(Page page, Model model) {
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<Stock> list = stockMapper.list();
        PageInfo<Stock> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
