package com.sifunit.lanwei.service;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.domain.Material;
import org.springframework.ui.Model;

public interface IMaterialService extends IBaseService<Material> {
    PageInfo<Material> getPage(Page page, Model model);
}
