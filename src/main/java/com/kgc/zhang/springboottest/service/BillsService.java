package com.kgc.zhang.springboottest.service;


import com.kgc.zhang.springboottest.bean.Bills;

import java.util.List;

public interface BillsService {
    /*查看账本详情信息*/
    List<Bills>  BillList();
}
