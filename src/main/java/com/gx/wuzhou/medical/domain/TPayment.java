/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: TPayment
 * Author:   Administrator
 * Date:     2020/6/14 0014 20:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.domain;

import com.gx.wuzhou.medical.core.util.BaseUtil;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/14 0014
 * @since 1.0.0
 */
public class TPayment extends BaseUtil {
    /**
     * 缴费编号
     */
    private String payNo;
    /**
     * 农合证号
     */
    private String persCode;
    /**
     * 缴费金额
     */
    private double payCost;
    /**
     * 执行年度
     */
    private int runyear;
    /**
     * 缴费时间
     */
    private java.util.Date paytime;
    /**
     *
     */
    private String famiCode;
    /**
     * 经办人
     */
    private String creatOr;

    private SysPerson person;

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getPersCode() {
        return persCode;
    }

    public void setPersCode(String persCode) {
        this.persCode = persCode;
    }

    public double getPayCost() {
        return payCost;
    }

    public void setPayCost(double payCost) {
        this.payCost = payCost;
    }

    public int getRunyear() {
        return runyear;
    }

    public void setRunyear(int runyear) {
        this.runyear = runyear;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public String getCreatOr() {
        return creatOr;
    }

    public void setCreatOr(String creatOr) {
        this.creatOr = creatOr;
    }

    public String getFamiCode() {
        return famiCode;
    }

    public void setFamiCode(String famiCode) {
        this.famiCode = famiCode;
    }

    public SysPerson getPerson() {
        return person;
    }

    public void setPerson(SysPerson person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "TPayment{" +
                "payNo='" + payNo + '\'' +
                ", persCode='" + persCode + '\'' +
                ", payCost=" + payCost +
                ", runyear=" + runyear +
                ", paytime=" + paytime +
                ", famiCode='" + famiCode + '\'' +
                ", creatOr='" + creatOr + '\'' +
                ", person=" + person +
                '}';
    }
}
