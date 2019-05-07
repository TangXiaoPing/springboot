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
@TableName("repair")
@ApiModel(value = "")
public class Repair implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 保修表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "保修表id",name = "id")
    private Integer id;
    /**
     * 保修宿舍
     */
    @ApiModelProperty(value = "保修宿舍",name = "dormRoomId")
    private Integer dormRoomId;
    /**
     * 报修人
     */
    @ApiModelProperty(value = "报修人",name = "repairName")
    private String repairName;
    /**
     * 报修人电话
     */
    @ApiModelProperty(value = "报修人电话",name = "repairPhone")
    private String repairPhone;
    /**
     * 报修时间
     */
    @ApiModelProperty(value = "报修时间",name = "repairTime")
    private Date repairTime;
    /**
     * 报修描述
     */
    @ApiModelProperty(value = "报修描述",name = "repaitDescription")
    private String repaitDescription;
    /**
     * 维修者描述
     */
    @ApiModelProperty(value = "维修者描述",name = "dealWithDescription")
    private String dealWithDescription;
    /**
     * 0-未处理 1-已处理
     */
    @ApiModelProperty(value = "0-未处理 1-已处理",name = "status")
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

    public Integer getDormRoomId() {
        return dormRoomId;
    }

    public void setDormRoomId(Integer dormRoomId) {
        this.dormRoomId = dormRoomId;
    }

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }

    public String getRepairPhone() {
        return repairPhone;
    }

    public void setRepairPhone(String repairPhone) {
        this.repairPhone = repairPhone;
    }

    public Date getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(Date repairTime) {
        this.repairTime = repairTime;
    }

    public String getRepaitDescription() {
        return repaitDescription;
    }

    public void setRepaitDescription(String repaitDescription) {
        this.repaitDescription = repaitDescription;
    }

    public String getDealWithDescription() {
        return dealWithDescription;
    }

    public void setDealWithDescription(String dealWithDescription) {
        this.dealWithDescription = dealWithDescription;
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
        return "Repair{" +
        ", id=" + id +
        ", dormRoomId=" + dormRoomId +
        ", repairName=" + repairName +
        ", repairPhone=" + repairPhone +
        ", repairTime=" + repairTime +
        ", repaitDescription=" + repaitDescription +
        ", dealWithDescription=" + dealWithDescription +
        ", status=" + status +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
