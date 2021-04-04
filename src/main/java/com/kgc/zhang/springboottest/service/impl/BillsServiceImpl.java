package com.kgc.zhang.springboottest.service.impl;

import com.kgc.zhang.springboottest.bean.Bills;
import com.kgc.zhang.springboottest.mapper.BillsMapper;
import com.kgc.zhang.springboottest.service.BillsService;
import com.sun.org.apache.regexp.internal.RE;
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

    @Override
    public int deleteID(Integer id) {
        return billsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Bills bills) {
        return billsMapper.insertSelective(bills);
    }

    @Override
    public int update(Bills bills) {
        return billsMapper.updateByPrimaryKey(bills);
    }

    @Override
    public Bills selectID(Integer id) {
        return billsMapper.selectByPrimaryKey(id);
    }
}
