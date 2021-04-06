package com.sifunit.lanwei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.Customer;
import com.sifunit.lanwei.mapper.CustomerMapper;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements ICustomerService {
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public IBaseMapper getMapper() {
        return customerMapper;
    }

    @Override
    public SysResult batchDel(List<Long> ids) {
        return null;
    }

    @Override
    public SysResult delById(Long customerId) {
        SysResult sysResult = new SysResult(false);
        int count = customerMapper.deleteByPrimaryKey(customerId);
        System.out.println(count);
        if (count == 0) {
            sysResult.setData("删除客户失败！");
        } else {
            sysResult.setResult(true);
            sysResult.setData("删除客户成功！");
        }
        return sysResult;
    }

    @Override
    public PageInfo<Customer> getPage(Page page, Model model) {
        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<Customer> list = customerMapper.list();
        PageInfo<Customer> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Customer> listCustomers() {
        List<Customer> list = customerMapper.list();
        PageInfo<Customer> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
