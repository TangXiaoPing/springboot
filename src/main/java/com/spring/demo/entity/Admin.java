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
@TableName("admin")
@ApiModel(value = "")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "",name = "id")
    private Integer id;
    /**
     * 管理员昵称
     */
    @ApiModelProperty(value = "管理员昵称",name = "nickname")
    private String nickname;
    /**
     * 管理员账号
     */
    @ApiModelProperty(value = "管理员账号",name = "loginName")
    private String loginName;
    /**
     * 管理员密码
     */
    @ApiModelProperty(value = "管理员密码",name = "passwd")
    private String passwd;
    /**
     * 管理员状态1-可用 0-不可用
     */
    @ApiModelProperty(value = "管理员状态1-可用 0-不可用",name = "adminStatus")
    private Integer adminStatus;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Integer getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(Integer adminStatus) {
        this.adminStatus = adminStatus;
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
        return "Admin{" +
        ", id=" + id +
        ", nickname=" + nickname +
        ", loginName=" + loginName +
        ", passwd=" + passwd +
        ", adminStatus=" + adminStatus +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
