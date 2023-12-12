package cn.fog.tj.mapper;

import cn.fog.tj.entity.Month;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Fog
 * @since 2023-12-04
 */
public interface MonthMapper extends BaseMapper<Month> {

    IPage pageC(Page<Month> page);
    IPage pageCC(IPage<Month> page, @Param(Constants.WRAPPER) Wrapper wrapper);
}
