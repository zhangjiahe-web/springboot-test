package com.kgc.zhang.springboottest.service.impl;

import com.kgc.zhang.springboottest.bean.Bills;
import com.kgc.zhang.springboottest.mapper.BillsMapper;
import com.kgc.zhang.springboottest.service.BillsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class BillsServiceImpl  implements BillsService {
    @Resource
    BillsMapper billsMapper;
    @Override
    public List<Bills> BillList() {
        return billsMapper.selectByExample(null);
    }
}
