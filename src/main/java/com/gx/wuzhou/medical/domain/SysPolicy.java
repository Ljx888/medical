/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysPolicy
 * Author:   Administrator
 * Date:     2020/6/12 0012 17:41
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
 * @create 2020/6/12 0012
 * @since 1.0.0
 */
public class SysPolicy extends BaseUtil {
    /**
     * 年份
     */
    private String runyear;
    /**
     * 封顶线
     */
    private double maxline;
    /**
     * 状态
     */
    private String status;
    /**
     * 备注
     */
    private String remark;

    public String getRunyear() {
        return runyear;
    }

    public void setRunyear(String runyear) {
        this.runyear = runyear;
    }

    public double getMaxline() {
        return maxline;
    }

    public void setMaxline(double maxline) {
        this.maxline = maxline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "SysPolicy{" +
                "runyear='" + runyear + '\'' +
                ", maxline=" + maxline +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
