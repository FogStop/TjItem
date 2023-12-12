package cn.fog.tj.controller;

import cn.fog.tj.common.Result;
import cn.fog.tj.entity.Employee;
import cn.fog.tj.entity.JsonResult;
import cn.fog.tj.service.IEmployeeService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fog
 * @since 2023-11-28
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private PasswordEncoder passwordEncoder;

//    @PostMapping("/list")
//    public Result<List<Employee>> getAll(){
//        List<Employee> list = employeeService.list();
//        return Result.success(list,"成功");
//    }




    @GetMapping("/list")
    public JsonResult getAll(){
        List<Employee> list = employeeService.list();
        return JsonResult.ok(list);
    }

    @PostMapping
    public Result<?> addUser(@RequestBody Employee user){
//        加密处理
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        employeeService.save(user);
        return Result.success("新增成功");
    }

    @PutMapping
    public Result<?> updateUser(@RequestBody Employee user){
        user.setPassword(null);
        employeeService.updateById(user);
        return Result.success("修改用户成功");
    }

    @GetMapping("/{id}")
    public Result<Employee> getUserById(@PathVariable("id") Integer id){
        Employee user = employeeService.getById(id);
        return Result.success(user);
    }
    @DeleteMapping("/{id}")
    public Result<Employee> deleteUserById(@PathVariable("id") Integer id){
        employeeService.removeById(id);
        return Result.success("删除成功");
    }



}
