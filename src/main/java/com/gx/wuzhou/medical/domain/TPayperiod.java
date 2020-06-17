/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: TPayperiod
 * Author:   Administrator
 * Date:     2020/6/14 0014 21:00
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
 * @create 2020/6/14 0014
 * @since 1.0.0
 */
public class TPayperiod extends BaseUtil {
    /**
     * 缴费执行年度
     */
    private int runyear;
    /**
     * 缴费金额
     */
    private double amount;
    /**
     * 起始时间 yyyy-MM-dd
     */
    private String startime;
    /**
     * 结束时间 yyyy-MM-dd
     */
    private String endtime;
    /**
     * 状态：1 启用，0 停用
     */
    private String status;
    /**
     * 报销比例
     */
    private double scale;

    public int getRunyear() {
        return runyear;
    }

    public void setRunyear(int runyear) {
        this.runyear = runyear;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStartime() {
        return startime;
    }

    public void setStartime(String startime) {
        this.startime = startime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    @Override
    public String toString() {
        return "TPayperiod{" +
                "runyear=" + runyear +
                ", amount=" + amount +
                ", startime='" + startime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", status='" + status + '\'' +
                ", scale=" + scale +
                '}';
    }
}
