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
@TableName("student")
@ApiModel(value = "")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "",name = "id")
    private Integer id;
    /**
     * 学生班级id
     */
    @ApiModelProperty(value = "学生班级id",name = "stuClassId")
    private Integer stuClassId;
    /**
     * 学生宿舍id
     */
    @ApiModelProperty(value = "学生宿舍id",name = "stuDormRoomId")
    private String stuDormRoomId;
    /**
     * 学号
     */
    @ApiModelProperty(value = "学号",name = "stuNo")
    private String stuNo;
    /**
     * 学生密码
     */
    @ApiModelProperty(value = "学生密码",name = "stuPwd")
    private String stuPwd;
    /**
     * 学生姓名
     */
    @ApiModelProperty(value = "学生姓名",name = "stuName")
    private String stuName;
    /**
     * 学生手机号码
     */
    @ApiModelProperty(value = "学生手机号码",name = "stuPhone")
    private String stuPhone;
    /**
     * 学生性别 1-男 0-女
     */
    @ApiModelProperty(value = "学生性别 1-男 0-女",name = "stuSex")
    private Integer stuSex;
    /**
     * 专业id
     */
    @ApiModelProperty(value = "专业id",name = "majorId")
    private Integer majorId;
    /**
     * 毕业年份
     */
    @ApiModelProperty(value = "毕业年份",name = "graduationYear")
    private String graduationYear;
    /**
     * 入学年份
     */
    @ApiModelProperty(value = "入学年份",name = "startYear")
    private String startYear;
    /**
     * 学生姓名
     */
    @ApiModelProperty(value = "学生姓名",name = "stuAge")
    private Integer stuAge;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间",name = "createTime")
    private Date createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间",name = "updateTime")
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStuClassId() {
        return stuClassId;
    }

    public void setStuClassId(Integer stuClassId) {
        this.stuClassId = stuClassId;
    }

    public String getStuDormRoomId() {
        return stuDormRoomId;
    }

    public void setStuDormRoomId(String stuDormRoomId) {
        this.stuDormRoomId = stuDormRoomId;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuPwd() {
        return stuPwd;
    }

    public void setStuPwd(String stuPwd) {
        this.stuPwd = stuPwd;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public Integer getStuSex() {
        return stuSex;
    }

    public void setStuSex(Integer stuSex) {
        this.stuSex = stuSex;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
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
        return "Student{" +
        ", id=" + id +
        ", stuClassId=" + stuClassId +
        ", stuDormRoomId=" + stuDormRoomId +
        ", stuNo=" + stuNo +
        ", stuPwd=" + stuPwd +
        ", stuName=" + stuName +
        ", stuPhone=" + stuPhone +
        ", stuSex=" + stuSex +
        ", majorId=" + majorId +
        ", graduationYear=" + graduationYear +
        ", startYear=" + startYear +
        ", stuAge=" + stuAge +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
