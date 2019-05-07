package com.spring.demo.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.demo.entity.Visitor;
import com.spring.demo.mapper.VisitorMapper;
import com.spring.demo.service.VisitorService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.spring.demo.util.PageDataResult;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author tangxiaoping123
 * @since 2019-05-07
 */
@Service
public class VisitorServiceImpl extends ServiceImpl<VisitorMapper, Visitor> implements VisitorService {

    @Override
    public PageDataResult getPageVisitorList(Integer page, Integer limit, String visitorName) {
        Page<Visitor> p = new Page<>(page, limit);
        p.setRecords(baseMapper.getPageVisitorList(p, visitorName));
        PageDataResult pdr = new PageDataResult(p.getTotal(), p.getRecords());
        return pdr;
    }
}
