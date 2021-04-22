package com.sifunit.lanwei.service;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.domain.Stock;
import org.springframework.ui.Model;

public interface IStockService extends IBaseService<Stock> {
    PageInfo<Stock> getPage(Page page, Model model);

    Long getStockNumByNo(String materialNo);
}
