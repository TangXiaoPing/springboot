package com.spring.demo.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author tangxiaoping123
 * @since 2019-05-07
 */
@TableName("stu_class")
@ApiModel(value = "")
public class StuClass implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 班级表id
     */
    @ApiModelProperty(value = "班级表id",name = "id")
    private Integer id;
    /**
     * 院系id
     */
    @ApiModelProperty(value = "院系id",name = "departmentId")
    private Integer departmentId;
    /**
     * 班级编号
     */
    @ApiModelProperty(value = "班级编号",name = "classNo")
    private String classNo;
    /**
     * 班级名称
     */
    @ApiModelProperty(value = "班级名称",name = "className")
    private String className;
    /**
     * 班级招收学生数量
     */
    @ApiModelProperty(value = "班级招收学生数量",name = "classNum")
    private Integer classNum;
    /**
     * 班级状态 1-开班 0-不开班
     */
    @ApiModelProperty(value = "班级状态 1-开班 0-不开班",name = "classStatus")
    private Integer classStatus;
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

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getClassNum() {
        return classNum;
    }

    public void setClassNum(Integer classNum) {
        this.classNum = classNum;
    }

    public Integer getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(Integer classStatus) {
        this.classStatus = classStatus;
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
        return "StuClass{" +
        ", id=" + id +
        ", departmentId=" + departmentId +
        ", classNo=" + classNo +
        ", className=" + className +
        ", classNum=" + classNum +
        ", classStatus=" + classStatus +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
