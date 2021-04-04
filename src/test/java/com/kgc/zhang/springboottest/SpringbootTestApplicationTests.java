package com.kgc.zhang.springboottest;

import com.kgc.zhang.springboottest.bean.Bills;
import com.kgc.zhang.springboottest.service.BillsService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	@Test
	    public void test(){
		String str = "123abcedfadbf abc321";
		Pattern p= Pattern.compile("abc(.*?)abc");
		Matcher m=p.matcher(str);
		String old="";
		while(m.find()){
			old+=m.group(1);
			System.out.println(old);
		}
		String replace = str.replace(old, "*");
		System.out.println(replace);

	}


}
