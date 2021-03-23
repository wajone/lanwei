package com.sifunit.lanwei.service;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.domain.Goods;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface IGoodsService extends IBaseService<Goods> {
    PageInfo getPageInfo(Page page, Model model);

    boolean handleUpload(MultipartFile[] files);
}
