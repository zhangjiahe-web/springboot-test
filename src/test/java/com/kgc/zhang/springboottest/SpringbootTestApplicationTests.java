package com.kgc.zhang.springboottest;

import com.kgc.zhang.springboottest.bean.Bills;
import com.kgc.zhang.springboottest.service.BillsService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringbootTestApplicationTests {
@Resource
	BillsService billsService;
	@Test
	void contextLoads() {
		List<Bills> bills = billsService.BillList();
		for (Bills bill : bills) {
			System.out.println(bill.getTitle());
		}
	}

}
