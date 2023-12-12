package cn.fog.tj.service;

import cn.fog.tj.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Fog
 * @since 2023-11-28
 */
public interface IEmployeeService extends IService<Employee> {
    Map<String, Object> login(Employee user);

    Map<String, Object> getUserInfo(String token);

    void logout(String token);
}
