package com.sifunit.lanwei.service;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.Product;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IProductService extends IBaseService<Product> {
    SysResult addProduct(MultipartFile[] files, String productName, String productNo, String productCateName, long productCateId, String productSize, String productDesc, String attachInfo) throws IOException;

    PageInfo getPageInfo(Page page, Model model);

    SysResult delById(Long productId);

    PageInfo<Product> list();
}
