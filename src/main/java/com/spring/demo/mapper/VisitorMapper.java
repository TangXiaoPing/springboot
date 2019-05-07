package com.spring.demo.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.demo.entity.Visitor;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author tangxiaoping123
 * @since 2019-05-07
 */
public interface VisitorMapper extends BaseMapper<Visitor> {

    List<Visitor> getPageVisitorList(Page<Visitor> page, @Param("visitorName") String visitorName);
}
