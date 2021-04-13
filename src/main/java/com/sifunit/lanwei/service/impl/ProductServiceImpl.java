package com.sifunit.lanwei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.FileUploadUtils;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.Product;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.mapper.ProductMapper;
import com.sifunit.lanwei.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product> implements IProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public IBaseMapper<Product> getMapper() {
        return productMapper;
    }

    @Override
    public SysResult addProduct(MultipartFile[] files, String productName, String productNo, String productCateName,
                                long productCateId, String productSize, String productDesc, String attachInfo) throws IOException {
        SysResult sysResult = new SysResult(false);

        Product product = new Product();
        if (productNo != null) {
            int count = productMapper.getCountByNo(productNo);
            if (count > 0) {
                sysResult.setData("编号已经存在，请修改编号再提交！");
                return sysResult;
            } else {
                product.setProductNo(productNo);
            }

        }


        StringBuffer imagesUrl = new StringBuffer();
        if (files != null ) {
            for(MultipartFile file: files) {
                if (!file.isEmpty()) {
                    //上传图片并把路径添加到imagesUrl
                    String ori = file.getOriginalFilename();
                    String imageUrl = FileUploadUtils.UploadPath + ori;
                    file.transferTo(new File(imageUrl));
                    imagesUrl.append(FileUploadUtils.MappingPath + ori);
                }
            }
            product.setImageUrl(imagesUrl.toString());
        }

        if (productName != null) {
            product.setProductName(productName);
        }
        if (productCateName != null) {
            product.setProductCateName(productCateName);
        }
        if (productCateId != 0) {
            product.setProductCateId(productCateId);
        }
        if (productSize != null) {
            product.setProductSize(productSize);
        }
        if (productDesc != null) {
            product.setProductDesc(productDesc);
        }
        if (attachInfo != null) {
            product.setAttachInfo(attachInfo);
        }

        if (productMapper.insertSelective(product) > 0) {
            sysResult.setResult(true);
            sysResult.setData("产品添加成功");
        } else {
            sysResult.setData("产品添加失败");
        }
        return sysResult;
    }

    @Override
    public PageInfo getPageInfo(Page page, Model model) {
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<Product> list = productMapper.list();
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public SysResult delById(Long productId) {
        SysResult sysResult = new SysResult();
        Product product = new Product();
        product.setProductId(productId);
        product.setFlag(false);
        int count = productMapper.updateByPrimaryKeySelective(product);
        if (count == 0) {
            sysResult.setResult(false);
            sysResult.setData("删除失败！");
        } else {
            sysResult.setResult(true);
            sysResult.setData("删除成功！");
        }
        return sysResult;
    }

    @Override
    public PageInfo<Product> listProducts() {
        List<Product> list = productMapper.list();
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
