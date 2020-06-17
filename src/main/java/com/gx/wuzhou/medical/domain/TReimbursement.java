/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: TReimbursement
 * Author:   Administrator
 * Date:     2020/6/17 0017 9:07
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
 * @create 2020/6/17 0017
 * @since 1.0.0
 */
public class TReimbursement extends BaseUtil {
    /**
     * 报销编号
     */
    private String reimbursementNumber;
    /**
     * 身份证号
     */
    private String cardId;
    /**
     *参合农民名称
     */
    private String persName;
    /**
     * 疾病名称
     */
    private String illName;
    /**
     * 报销时间
     */
    private String creatTime;
    /**
     * 医疗总费用
     */
    private double medicalSum;
    /**
     * 医疗发票号
     */
    private String medicalCode;
    /**
     * 就诊时间
     */
    private String visitTime;
    /**
     * 报销比例
     */
    private double proprotion;
    /**
     * 报销金额
     */
    private double money;
    /**
     * 农合参合人员
     */
    private String creatOr;
    /**
     * 审核状态
     */
    private int status;
    /**
     * 是否汇款
     */
    private int isRemittance;

    public String getReimbursementNumber() {
        return reimbursementNumber;
    }

    public void setReimbursementNumber(String reimbursementNumber) {
        this.reimbursementNumber = reimbursementNumber;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getPersName() {
        return persName;
    }

    public void setPersName(String persName) {
        this.persName = persName;
    }

    public String getIllName() {
        return illName;
    }

    public void setIllName(String illName) {
        this.illName = illName;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public double getMedicalSum() {
        return medicalSum;
    }

    public void setMedicalSum(double medicalSum) {
        this.medicalSum = medicalSum;
    }

    public String getMedicalCode() {
        return medicalCode;
    }

    public void setMedicalCode(String medicalCode) {
        this.medicalCode = medicalCode;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public double getProprotion() {
        return proprotion;
    }

    public void setProprotion(double proprotion) {
        this.proprotion = proprotion;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getCreatOr() {
        return creatOr;
    }

    public void setCreatOr(String creatOr) {
        this.creatOr = creatOr;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIsRemittance() {
        return isRemittance;
    }

    public void setIsRemittance(int isRemittance) {
        this.isRemittance = isRemittance;
    }

    @Override
    public String toString() {
        return "TReimbursement{" +
                "reimbursementNumber='" + reimbursementNumber + '\'' +
                ", cardId='" + cardId + '\'' +
                ", persName='" + persName + '\'' +
                ", illName='" + illName + '\'' +
                ", creatTime='" + creatTime + '\'' +
                ", medicalSum=" + medicalSum +
                ", medicalCode='" + medicalCode + '\'' +
                ", visitTime='" + visitTime + '\'' +
                ", proprotion=" + proprotion +
                ", money=" + money +
                ", creatOr='" + creatOr + '\'' +
                ", status=" + status +
                ", isRemittance=" + isRemittance +
                '}';
    }
}
