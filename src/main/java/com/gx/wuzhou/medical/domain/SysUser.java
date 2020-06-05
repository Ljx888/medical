/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysUser
 * Author:   Administrator
 * Date:     2020/6/4 0004 14:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.domain;

import com.gx.wuzhou.medical.core.util.BaseUtil;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/4 0004
 * @since 1.0.0
 */
public class SysUser extends BaseUtil {
    private Integer id;
    private String userId;
    private String fullName;  //姓名
    private String pwd;
    private Integer status;  //是否启用
    private String agenCode; //农合机构

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAgenCode() {
        return agenCode;
    }

    public void setAgenCode(String agenCode) {
        this.agenCode = agenCode;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", status=" + status +
                ", agenCode='" + agenCode + '\'' +
                '}';
    }
}
