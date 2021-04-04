package com.kgc.zhang.springboottest.service;


import com.kgc.zhang.springboottest.bean.Bills;

import java.util.List;

public interface BillsService {
    /*查看账本详情信息*/
    List<Bills>  BillList();
/*删除记账本ID*/
    int deleteID(Integer id);

    int insert(Bills bills);

    int update(Bills bills);

    Bills selectID(Integer id);
}
