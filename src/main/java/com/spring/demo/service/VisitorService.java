package com.spring.demo.service;

import com.spring.demo.entity.Visitor;
import com.baomidou.mybatisplus.service.IService;
import com.spring.demo.util.PageDataResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tangxiaoping123
 * @since 2019-05-07
 */
public interface VisitorService extends IService<Visitor> {

    PageDataResult getPageVisitorList(Integer page, Integer limit, String visitorName);
}
