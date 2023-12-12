package cn.fog.tj.controller;

import cn.fog.tj.common.Result;
import cn.fog.tj.entity.Employee;
import cn.fog.tj.entity.User;
import cn.fog.tj.service.IEmployeeService;
import cn.fog.tj.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fog
 * @since 2023-11-25
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IEmployeeService employeeService;

    @PostMapping("/list")
    public Result<List<User>> getAll(){
        List<User> list = userService.list();
        return Result.success(list,"成功");
    }

    @PostMapping("/list2")
    public Result<List<Employee>> getAll2(){
        List<Employee> list = employeeService.list();
        return Result.success(list,"成功");
    }

    @PostMapping("/login")
    public Result<Map<String,Object>> login(@RequestBody User user){
        Map<String,Object> data = userService.login(user);
        if (data!= null)
            return Result.success(data);
        return Result.fail(201,"用户密码或者用户名错误");
    }

    @GetMapping("/info")
    public Result<Map<String,Object>> getUserInfo(@RequestParam("token") String token){
//        获取信息token
        Map<String,Object> data  = userService.getUserInfo(token);
        if (data!= null)
            return Result.success(data);
        return Result.fail(203,"无效用户名，请重新登录");
    }

    @PostMapping("logout")
    public Result<?> logout(@RequestHeader("X-Token") String token){
        userService.logout(token);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<Map<String,Object>> getUserList(@RequestParam(value="username",required = false) String username,
                                               @RequestParam(value="phone",required = false) String phone,
                                               @RequestParam(value="pageNo") Long pageNo,
                                               @RequestParam(value="pageSize") Long pageSize){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.hasLength(username),User::getUsername,username);
        queryWrapper.eq(StringUtils.hasLength(phone),User::getPhone,phone);

        Page<User> page = new Page<>(pageNo,pageSize);
        userService.page(page,queryWrapper);
        Map<String,Object> data = new HashMap<>();
        data.put("total",page.getTotal());
        data.put("rows",page.getRecords());
        return Result.success(data);
    }

    @PostMapping
    public Result<?> addUser(@RequestBody User user){
//        加密处理
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return Result.success("新增成功");
    }

    @PutMapping
    public Result<?> updateUser(@RequestBody User user){
        user.setPassword(null);
        userService.updateById(user);
        return Result.success("修改用户成功");
    }

    @GetMapping("/{id}")
    public Result<User> getUserById(@PathVariable("id") Integer id){
        User user = userService.getById(id);
        return Result.success(user);
    }
    @DeleteMapping("/{id}")
    public Result<User> deleteUserById(@PathVariable("id") Integer id){
        userService.removeById(id);
        return Result.success("删除成功");
    }
}
