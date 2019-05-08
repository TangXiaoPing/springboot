package com.spring.demo.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import com.baomidou.mybatisplus.enums.IdType;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author tangxiaoping123
 * @since 2019-05-07
 */
@TableName("fee")
@ApiModel(value = "")
public class Fee implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 费用表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "费用表id", name = "id")
    private Integer id;
    /**
     * 宿舍id
     */
    @ApiModelProperty(value = "宿舍id", name = "dormRoomId")
    @NotEmpty(message = "宿舍id不能为空")
    private Integer dormRoomId;
    /**
     * 管理员id--录入的管理员
     */
    @ApiModelProperty(value = "管理员id--录入的管理员", name = "dormRoomAdminId")
    @NotEmpty(message = "管理员id不能为空")
    private Integer dormRoomAdminId;
    /**
     * 水费
     */
    @ApiModelProperty(value = "水费", name = "waterFee")
    @NotEmpty(message = "水费不能为空")
    private BigDecimal waterFee;
    /**
     * 电费
     */
    @ApiModelProperty(value = "电费", name = "electricityFee")
    @NotEmpty(message = "电费不能为空")
    private BigDecimal electricityFee;
    /**
     * 缴纳时间
     */
    @ApiModelProperty(value = "缴纳时间", name = "payTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date payTime;
    /**
     * 缴费周数
     */
    @ApiModelProperty(value = "缴费周数", name = "feeTime")
    private Integer feeTime;
    /**
     * 1-已缴纳 0-未缴纳
     */
    @ApiModelProperty(value = "1-已缴纳 0-未缴纳", name = "status")
    private Integer status;
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

    public Integer getDormRoomId() {
        return dormRoomId;
    }

    public void setDormRoomId(Integer dormRoomId) {
        this.dormRoomId = dormRoomId;
    }

    public Integer getDormRoomAdminId() {
        return dormRoomAdminId;
    }

    public void setDormRoomAdminId(Integer dormRoomAdminId) {
        this.dormRoomAdminId = dormRoomAdminId;
    }

    public BigDecimal getWaterFee() {
        return waterFee;
    }

    public void setWaterFee(BigDecimal waterFee) {
        this.waterFee = waterFee;
    }

    public BigDecimal getElectricityFee() {
        return electricityFee;
    }

    public void setElectricityFee(BigDecimal electricityFee) {
        this.electricityFee = electricityFee;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getFeeTime() {
        return feeTime;
    }

    public void setFeeTime(Integer feeTime) {
        this.feeTime = feeTime;
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
        return "Fee{" +
                ", id=" + id +
                ", dormRoomId=" + dormRoomId +
                ", dormRoomAdminId=" + dormRoomAdminId +
                ", waterFee=" + waterFee +
                ", electricityFee=" + electricityFee +
                ", payTime=" + payTime +
                ", feeTime=" + feeTime +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                "}";
    }
}
