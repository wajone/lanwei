package com.sifunit.lanwei.mapper;

import com.sifunit.lanwei.domain.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper extends IBaseMapper<Customer> {

    List<Customer> list();
}