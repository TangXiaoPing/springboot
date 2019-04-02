package com.spring.demo.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 测试类
 * </p>
 *
 * @author tangxiaoping123
 * @since 2019-04-02
 */
@TableName("test")
@ApiModel(value = "测试类")
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "编号",name = "id")
    private Integer id;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名",name = "name")
    private String name;
    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄",name = "age")
    private Integer age;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Test{" +
        ", id=" + id +
        ", name=" + name +
        ", age=" + age +
        "}";
    }
}
