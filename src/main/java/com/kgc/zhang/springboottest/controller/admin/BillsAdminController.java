package com.kgc.zhang.springboottest.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.zhang.springboottest.bean.Bills;
import com.kgc.zhang.springboottest.service.BillsService;
import com.kgc.zhang.springboottest.vo.R;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "记账本管理后台")
@RestController
@CrossOrigin
@RequestMapping("/jizhang")
public class BillsAdminController {
    @Resource
    BillsService billsService;


    @ApiOperation(value = "记账本查询")
    @GetMapping("/lists")
    public R billslists(
            @ApiParam(name = "pageNum", value = "分页页数", required = false)
            @RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
            @ApiParam(name = "pageSize", value = "分页数量", required = false)
                       @RequestParam(value = "pageSize",required = false,defaultValue = "3")Integer pageSize){
        try {
            PageHelper.startPage(pageNum,pageSize);
            PageHelper.orderBy("id desc");
            List<Bills> bills = billsService.BillList();
            PageInfo<Bills> billsPageInfo = new PageInfo<>(bills);
            return R.ok().data("pageInfo",billsPageInfo);
        }catch (Exception e){
            return R.error().message("查询失败");
        }
    }

    @ApiOperation(value = "记账本删除")
    @DeleteMapping("/deletes/{id}")
    public  R deletes(@PathVariable @ApiParam(name = "id",value = "记账本数据ID",required = true)Integer id){
        int i=billsService.deleteID(id);
        if (i>0){
            return R.ok().message("删除成功");
        }else {
            return  R.error().message("删除失败");
        }

    }
    @ApiOperation(value = "添加记账本数据")
    @PostMapping("/inserts")
    public  R inserts(@RequestBody @ApiParam(name = "bills",value = "记账本对象",required = true)Bills bills){
        int insert = billsService.insert(bills);
        if (insert>0){
            return R.ok().message("增加成功");
        }else {
            return  R.error().message("增加失败");
        }
    }

    @ApiOperation(value = "查询单条记账本记录")
    @GetMapping("/selectsID/{id}")
    public  R selectsID(@PathVariable @ApiParam(name = "id",value = "记账本ID",required = true) Integer id){
        Bills bills=billsService.selectID(id);
        return R.ok().data("bills",bills);
    }

    @ApiOperation(value = "修改账本记录")
    @PostMapping("/updates")
    public  R updates(@RequestBody @ApiParam(name = "bills",value = "记账本对象",required = true) Bills bills){
        int update=billsService.update(bills);
        if (update>0){
            return R.ok().message("修改成功");
        }else {
            return  R.error().message("修改失败");
        }

    }

}
