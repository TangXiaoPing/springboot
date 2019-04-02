package com.spring.demo.service.impl;

import com.spring.demo.entity.Test;
import com.spring.demo.mapper.TestMapper;
import com.spring.demo.service.TestService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试类 服务实现类
 * </p>
 *
 * @author tangxiaoping123
 * @since 2019-04-02
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

}
