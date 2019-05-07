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
@TableName("major")
@ApiModel(value = "")
public class Major implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 专业id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "专业id",name = "id")
    private Integer id;
    /**
     * 专业编号
     */
    @ApiModelProperty(value = "专业编号",name = "majorNo")
    private String majorNo;
    /**
     * 专业名称
     */
    @ApiModelProperty(value = "专业名称",name = "majorName")
    private String majorName;
    /**
     * 专业招收人数
     */
    @ApiModelProperty(value = "专业招收人数",name = "majorNum")
    private Integer majorNum;
    /**
     * 需要时间
     */
    @ApiModelProperty(value = "需要时间",name = "studyYear")
    private Integer studyYear;
    /**
     * 1-开放 0-不开放
     */
    @ApiModelProperty(value = "1-开放 0-不开放",name = "status")
    private Integer status;
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

    public String getMajorNo() {
        return majorNo;
    }

    public void setMajorNo(String majorNo) {
        this.majorNo = majorNo;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Integer getMajorNum() {
        return majorNum;
    }

    public void setMajorNum(Integer majorNum) {
        this.majorNum = majorNum;
    }

    public Integer getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(Integer studyYear) {
        this.studyYear = studyYear;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "Major{" +
        ", id=" + id +
        ", majorNo=" + majorNo +
        ", majorName=" + majorName +
        ", majorNum=" + majorNum +
        ", studyYear=" + studyYear +
        ", status=" + status +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
