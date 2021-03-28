package com.sifunit.lanwei.service;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.domain.MaterialCate;
import org.springframework.ui.Model;

public interface IMaterialCateService extends IBaseService<MaterialCate> {
    PageInfo<MaterialCate> getPage(Page page, Model model);
}
