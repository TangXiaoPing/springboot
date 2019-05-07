package com.spring.demo.service.impl;

import com.spring.demo.entity.Fee;
import com.spring.demo.mapper.FeeMapper;
import com.spring.demo.service.FeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tangxiaoping123
 * @since 2019-05-07
 */
@Service
public class FeeServiceImpl extends ServiceImpl<FeeMapper, Fee> implements FeeService {

}
