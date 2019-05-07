package com.spring.demo.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author tangxiaoping123
 * @since 2019-05-07
 */
@TableName("department")
@ApiModel(value = "")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 院系表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "院系表id",name = "id")
    private Integer id;
    /**
     * 院系编号
     */
    @ApiModelProperty(value = "院系编号",name = "departmentNo")
    private String departmentNo;
    /**
     * 院系名称
     */
    @ApiModelProperty(value = "院系名称",name = "departmentName")
    private String departmentName;
    /**
     * 院系描述
     */
    @ApiModelProperty(value = "院系描述",name = "description")
    private String description;
    @ApiModelProperty(value = "",name = "createTime")
    private Date createTime;
    @ApiModelProperty(value = "",name = "updateTime")
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentNo() {
        return departmentNo;
    }

    public void setDepartmentNo(String departmentNo) {
        this.departmentNo = departmentNo;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "Department{" +
        ", id=" + id +
        ", departmentNo=" + departmentNo +
        ", departmentName=" + departmentName +
        ", description=" + description +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
