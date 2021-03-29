package com.sifunit.lanwei.service;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.domain.GoodCate;
import com.sifunit.lanwei.domain.MaterialCate;
import org.springframework.ui.Model;

public interface IGoodCateService extends IBaseService<GoodCate> {
    PageInfo<GoodCate> getPage(Page page, Model model);
}
