package cn.fog.tj.mapper;

import cn.fog.tj.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Fog
 * @since 2023-11-28
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
    public List<String> getRoleNameByEmployeeId(Integer userId);
}
