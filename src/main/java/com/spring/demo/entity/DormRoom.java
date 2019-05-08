package com.spring.demo.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;

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
@TableName("dorm_room")
@ApiModel(value = "")
public class DormRoom implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 宿舍id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "宿舍id", name = "id")
    private Integer id;

    /**
     * 所属宿舍楼
     */
    @ApiModelProperty(value = "所属宿舍楼", name = "dormId")
    @NotEmpty(message = "所属宿舍楼不能为空")
    private Integer dormId;
    /**
     * 所属院系
     */
    @ApiModelProperty(value = "所属院系", name = "departmentId")
    @NotEmpty(message = "所属院系不能为空")
    private Integer departmentId;
    /**
     * 宿舍编号
     */
    @ApiModelProperty(value = "宿舍编号", name = "dormRoomNo")
    @NotBlank(message = "宿舍编号不能为空")
    private String dormRoomNo;
    /**
     * 宿舍人数
     */
    @ApiModelProperty(value = "宿舍人数", name = "dormRoomNum")
    private Integer dormRoomNum;
    /**
     * 宿舍状态 1-未满员 0-已损坏 2-已满员
     */
    @ApiModelProperty(value = "宿舍状态 1-未满员 0-已损坏 2-已满员 ", name = "dromRoomStatus")
    private Integer dromRoomStatus;
    /**
     * 宿舍描述
     */
    @ApiModelProperty(value = "宿舍描述", name = "description")
    private String description;
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

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDormRoomNo() {
        return dormRoomNo;
    }

    public void setDormRoomNo(String dormRoomNo) {
        this.dormRoomNo = dormRoomNo;
    }

    public Integer getDormRoomNum() {
        return dormRoomNum;
    }

    public void setDormRoomNum(Integer dormRoomNum) {
        this.dormRoomNum = dormRoomNum;
    }

    public Integer getDromRoomStatus() {
        return dromRoomStatus;
    }

    public void setDromRoomStatus(Integer dromRoomStatus) {
        this.dromRoomStatus = dromRoomStatus;
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

    public Integer getDormId() {
        return dormId;
    }

    public void setDormId(Integer dormId) {
        this.dormId = dormId;
    }

    @Override
    public String toString() {
        return "DormRoom{" +
                "id=" + id +
                ", dormId=" + dormId +
                ", departmentId=" + departmentId +
                ", dormRoomNo='" + dormRoomNo + '\'' +
                ", dormRoomNum=" + dormRoomNum +
                ", dromRoomStatus=" + dromRoomStatus +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
