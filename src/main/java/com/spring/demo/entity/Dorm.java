package com.spring.demo.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author tangxiaoping123
 * @since 2019-05-07
 */
@TableName("dorm")
@ApiModel(value = "")
public class Dorm implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 宿舍楼id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "宿舍楼id", name = "id")
    private Integer id;
    /**
     * 宿舍楼编号
     */
    @ApiModelProperty(value = "宿舍楼编号", name = "dormNo")
    @NotBlank(message = "宿舍楼编号不能为空")
    private String dormNo;
    /**
     * 宿舍楼名称
     */
    @ApiModelProperty(value = "宿舍楼名称", name = "dormName")
    @NotBlank(message = "宿舍楼名称不能为空")
    private String dormName;
    @ApiModelProperty(value = "", name = "createTime")
    private Date createTime;
    @ApiModelProperty(value = "", name = "updateTime")
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDormNo() {
        return dormNo;
    }

    public void setDormNo(String dormNo) {
        this.dormNo = dormNo;
    }

    public String getDormName() {
        return dormName;
    }

    public void setDormName(String dormName) {
        this.dormName = dormName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Dorm{" +
                ", id=" + id +
                ", dormNo=" + dormNo +
                ", dormName=" + dormName +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                "}";
    }
}
