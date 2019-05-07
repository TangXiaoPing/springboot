package com.spring.demo.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author tangxiaoping123
 * @since 2019-05-07
 */
@TableName("visitor")
@ApiModel(value = "")
public class Visitor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 来访人id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "来访人id", name = "id")
    private Integer id;
    @ApiModelProperty(value = "", name = "visitorName")
    private String visitorName;
    @ApiModelProperty(value = "", name = "visitorPhone")
    private String visitorPhone;
    /**
     * 访问宿舍
     */
    @ApiModelProperty(value = "访问宿舍", name = "dormRoomId")
    private Integer dormRoomId;
    /**
     * 访问学生
     */
    @ApiModelProperty(value = "访问学生", name = "studentId")
    private Integer studentId;
    /**
     * 访问时间
     */
    @ApiModelProperty(value = "访问时间", name = "visitorTime")
    private Date visitorTime;
    /**
     * 离开时间
     */
    @ApiModelProperty(value = "离开时间", name = "goAwayTime")
    //解决时间类型参数报错问题
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date goAwayTime;
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

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorPhone() {
        return visitorPhone;
    }

    public void setVisitorPhone(String visitorPhone) {
        this.visitorPhone = visitorPhone;
    }

    public Integer getDormRoomId() {
        return dormRoomId;
    }

    public void setDormRoomId(Integer dormRoomId) {
        this.dormRoomId = dormRoomId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Date getVisitorTime() {
        return visitorTime;
    }

    public void setVisitorTime(Date visitorTime) {
        this.visitorTime = visitorTime;
    }

    public Date getGoAwayTime() {
        return goAwayTime;
    }

    public void setGoAwayTime(Date goAwayTime) {
        this.goAwayTime = goAwayTime;
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
        return "Visitor{" +
                ", id=" + id +
                ", visitorName=" + visitorName +
                ", visitorPhone=" + visitorPhone +
                ", dormRoomId=" + dormRoomId +
                ", studentId=" + studentId +
                ", visitorTime=" + visitorTime +
                ", goAwayTime=" + goAwayTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                "}";
    }
}
