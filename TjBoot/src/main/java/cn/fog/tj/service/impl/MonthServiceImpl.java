package cn.fog.tj.service.impl;

import cn.fog.tj.entity.Month;
import cn.fog.tj.mapper.MonthMapper;
import cn.fog.tj.service.IMonthService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Fog
 * @since 2023-12-04
 */
@Service
public class MonthServiceImpl extends ServiceImpl<MonthMapper, Month> implements IMonthService {

    @Autowired
    private MonthMapper monthMapper;
    @Override
    public IPage pageC(Page<Month> page) {

        return monthMapper.pageC(page);
    }

    @Override
    public IPage pageCC(IPage<Month> page, Wrapper wrapper) {
        return monthMapper.pageCC(page,wrapper);
    }
}
