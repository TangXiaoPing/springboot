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
@TableName("dorm_room_admin")
@ApiModel(value = "")
public class DormRoomAdmin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 宿舍管理员id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "宿舍管理员id",name = "id")
    private Integer id;
    /**
     * 管理员姓名
     */
    @ApiModelProperty(value = "管理员姓名",name = "name")
    private String name;
    /**
     * 管理员电话
     */
    @ApiModelProperty(value = "管理员电话",name = "phone")
    private String phone;
    /**
     * 1-在职 0-离职
     */
    @ApiModelProperty(value = "1-在职 0-离职",name = "status")
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        return "DormRoomAdmin{" +
        ", id=" + id +
        ", name=" + name +
        ", phone=" + phone +
        ", status=" + status +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
