package com.sifunit.lanwei.service;

import com.github.pagehelper.PageInfo;
import com.sifunit.lanwei.common.Page;
import com.sifunit.lanwei.common.SysResult;
import com.sifunit.lanwei.domain.Customer;
import com.sifunit.lanwei.domain.SysDept;
import org.springframework.ui.Model;

import java.util.List;

public interface ICustomerService extends IBaseService<Customer> {
    SysResult batchDel(List<Long> ids);

    SysResult delById(Long customerId);

    PageInfo<Customer> getPage(Page page, Model model);

    PageInfo<Customer> listCustomers();
}
