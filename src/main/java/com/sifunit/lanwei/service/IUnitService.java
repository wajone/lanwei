package com.sifunit.lanwei.service;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.domain.Unit;
import org.springframework.ui.Model;

public interface IUnitService extends IBaseService<Unit> {
    PageInfo<Unit> getPage(Page page, Model model);
}
