package cn.fog.tj.service;

import cn.fog.tj.entity.Month;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Fog
 * @since 2023-12-04
 */
public interface IMonthService extends IService<Month> {

    IPage pageC(Page<Month> page);

    IPage pageCC(IPage<Month> page, Wrapper wrapper);
}
