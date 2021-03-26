package com.sifunit.lanwei.service;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.domain.ProceCate;
import org.springframework.ui.Model;

public interface IProceCateService extends IBaseService<ProceCate> {
    PageInfo<ProceCate> getPage(Page page, Model model);
}
