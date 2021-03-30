package com.kgc.zhang.springboottest.controller;

import com.kgc.zhang.springboottest.bean.Bills;
import com.kgc.zhang.springboottest.service.BillsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/jizhang")
public class BillsController {
    @Resource
    BillsService billsService;

    @RequestMapping("/list")
    public  String billslist(Model model){
        List<Bills> bills = billsService.BillList();
        model.addAttribute("bills",bills);
        return "index.html";
    }

}
