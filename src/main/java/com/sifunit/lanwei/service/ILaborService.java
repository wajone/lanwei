package com.sifunit.lanwei.service;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.Labor;
import org.springframework.ui.Model;

public interface ILaborService extends IBaseService<Labor> {
    PageInfo<Labor> getPage(Page page, Model model);

    SysResult delById(Long laborId);
}
