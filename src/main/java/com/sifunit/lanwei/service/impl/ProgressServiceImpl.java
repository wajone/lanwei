package com.sifunit.lanwei.service.impl;

import com.sifunit.lanwei.domain.Progress;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.mapper.ProgressMapper;
import com.sifunit.lanwei.service.IProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressServiceImpl extends BaseServiceImpl<Progress> implements IProgressService {
    @Autowired
    ProgressMapper progressMapper;

    @Override
    public IBaseMapper<Progress> getMapper() {
        return progressMapper;
    }

    @Override
    public int insertProress(List<Progress> progress) {
        for (Progress pro : progress) {
            if (progressMapper.insertSelective(pro) < 0) {
                return -1;
            }
        }
        return 1;
    }
}
