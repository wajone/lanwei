package com.sifunit.lanwei.mapper;

import com.sifunit.lanwei.domain.Material;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MaterialMapper extends IBaseMapper<Material> {
    List<Material> list();
}