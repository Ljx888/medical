/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysPerson
 * Author:   Administrator
 * Date:     2020/6/12 0012 23:38
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
public class SysPerson extends BaseUtil {
    /**
     * 个人编号
     */
    private String persCode;
    /**
     * 对应家庭档案
     */
    private String famiCode;
    /**
     * 农合证卡号
     */
    private String ruralCard;
    /**
     * 与户主关系
     */
    private String relation;//1:表示户主，2表示配偶,3表示子，4表示女，5表示孙子，6表示孙女
    /**
     * 身份证号
     */
    private String cardId;
    /**
     * 姓名
     */
    private String persName;
    /**
     * 年龄
     */
    private int age;
    /**
     * 性别
     */
    private String sex;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 人员属性
     */
    private String persPro;
    /**
     * 是否农村户口
     */
    private boolean isRural;
    /**
     * 职业
     */
    private String occupation;
    /**
     * 工作单位
     */
    private String workUnit;
    /**
     * 常住地址
     */
    private String liveAddress;
    /**
     * 联系电话
     */
    private String telephone;

    private TPayment payment;

    public String getPersCode() {
        return persCode;
    }

    public void setPersCode(String persCode) {
        this.persCode = persCode;
    }

    public String getFamiCode() {
        return famiCode;
    }

    public void setFamiCode(String famiCode) {
        this.famiCode = famiCode;
    }

    public String getRuralCard() {
        return ruralCard;
    }

    public void setRuralCard(String ruralCard) {
        this.ruralCard = ruralCard;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPersPro() {
        return persPro;
    }

    public void setPersPro(String persPro) {
        this.persPro = persPro;
    }

    public boolean isRural() {
        return isRural;
    }

    public void setRural(boolean rural) {
        isRural = rural;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getLiveAddress() {
        return liveAddress;
    }

    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public TPayment getPayment() {
        return payment;
    }

    public void setPayment(TPayment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "SysPerson{" +
                "persCode='" + persCode + '\'' +
                ", famiCode='" + famiCode + '\'' +
                ", ruralCard='" + ruralCard + '\'' +
                ", relation='" + relation + '\'' +
                ", cardId='" + cardId + '\'' +
                ", persName='" + persName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", persPro='" + persPro + '\'' +
                ", isRural=" + isRural +
                ", occupation='" + occupation + '\'' +
                ", workUnit='" + workUnit + '\'' +
                ", liveAddress='" + liveAddress + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
