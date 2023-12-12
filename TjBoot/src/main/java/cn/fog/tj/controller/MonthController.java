package cn.fog.tj.controller;

import cn.fog.tj.common.PageParam;
import cn.fog.tj.entity.JsonResult;
import cn.fog.tj.entity.Month;
import cn.fog.tj.service.IMonthService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Fog
 * @since 2023-12-04
 */
@RestController
@RequestMapping("/month")
public class MonthController {
    @Autowired
    private IMonthService monthService;

    //查询全部
    @GetMapping("/list")
    public JsonResult getAll() {
        List<Month> list = monthService.list();
        return JsonResult.ok(list);
    }

    //    新增
    @PostMapping("/save")
    public JsonResult save(@RequestBody Month month) {
        monthService.save(month);
        return JsonResult.ok("新增成功");
    }

    //    修改
    @PutMapping("/update")
    public JsonResult update(@RequestBody Month month) {
        monthService.updateById(month);
        return JsonResult.ok("修改成功");
    }

    //    新增或者更新
    @PostMapping("/saveOrupdate")
    public JsonResult saveOrUpdate(@RequestBody Month month) {
        monthService.saveOrUpdate(month);
        return JsonResult.ok("操作成功");
    }

    //    删除
    @GetMapping("/delete")
    public JsonResult delete(Integer id) {
       monthService.removeById(id);
        return JsonResult.ok("删除成功");
    }
//    模糊查询
    @GetMapping("/listP")
    public JsonResult listP(@RequestBody Month month){
        LambdaQueryWrapper<Month> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Month::getMonth,month.getMonth());
        monthService.list(wrapper);
        return JsonResult.ok("查询成功");
    }
    @GetMapping("/listPage")
    public JsonResult listPage(@RequestBody PageParam query){
        System.out.println(query);
        System.out.println("num:"+query.getPageNum());
        System.out.println("size:"+query.getPageSize());

        Page<Month> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        IPage result  = monthService.pageC(page);
        System.out.println("total:"+result.getTotal());
        return JsonResult.ok(result.getRecords());
    }


    @PostMapping("/listPageC1")
    public JsonResult listPageC1(@RequestBody PageParam query){
        HashMap param = query.getParam();
        String month = (String)param.get("month");


        Page<Month> page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<Month> lambdaQueryWrapper = new LambdaQueryWrapper();
        if(StringUtils.isNotBlank(month) && !"null".equals(month)){
            lambdaQueryWrapper.like(Month::getMonth,month);
        }

        IPage result = monthService.pageCC(page,lambdaQueryWrapper);

        System.out.println("total=="+result.getTotal());

        return JsonResult.ok(result.getRecords());
    }

}
