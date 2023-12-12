package cn.fog.tj.service.impl;

import cn.fog.tj.entity.Employee;
import cn.fog.tj.entity.User;
import cn.fog.tj.mapper.EmployeeMapper;
import cn.fog.tj.service.IEmployeeService;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Fog
 * @since 2023-11-28
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Map<String, Object> login(Employee user) {
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
//        条件筛选
        queryWrapper.eq(Employee::getUsername,user.getUsername());

        Employee loginUser = this.baseMapper.selectOne(queryWrapper);
//        是否为空
        if (loginUser!= null&& passwordEncoder.matches(user.getPassword(), loginUser.getPassword())){
            String key = "user"+ UUID.randomUUID();
//            存到redis
            loginUser.setPassword(null);
            redisTemplate.opsForValue().set(key,loginUser,30, TimeUnit.MINUTES);
//            返回数据
            Map<String,Object> data = new HashMap<>();
            data.put("token",key);
            return data;
        }
        return null;
    }

    @Override
    public Map<String, Object> getUserInfo(String token) {
//        redis获取用户细心
        Object obj = redisTemplate.opsForValue().get(token);
//        反序列化
        User user = JSON.parseObject(JSON.toJSONString(obj),User.class);
        if (obj!=null){
            User loginUser = JSON.parseObject(JSON.toJSONString(obj),User.class);//字符串转换
            Map<String, Object> data = new HashMap<>();
            data.put("name",loginUser.getUsername());
            data.put("avatar", loginUser.getAvatar());
            List<String> list = this.baseMapper.getRoleNameByEmployeeId(loginUser.getId());
            data.put("roles",list);

            return data;
        }
        return  null;
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete(token);
    }

}
