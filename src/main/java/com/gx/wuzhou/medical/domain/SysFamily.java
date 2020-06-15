/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysFamily
 * Author:   Administrator
 * Date:     2020/6/12 0012 23:38
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
 * @create 2020/6/12 0012
 * @since 1.0.0
 */
public class SysFamily extends BaseUtil {
    /**
     * 家庭编号
     */
    private String famiCode;
    /**
     * 乡镇编号
     */
    private String town;
    /**
     * 村编号
     */
    private String village;
    /**
     * 组编号
     */
    private String groupNo;
    /**
     * 户主信息
     */
    private String persCode;
    /**
     *户属性
     */
    private String housePro;
    /**
     * 人口数
     */
    private int popuNum;
    /**
     * 农业人口数
     */
    private int agriNum;
    /**
     * 家庭住址
     */
    private String address;
    /**
     * 建档时间
     */
    private String creatTime;
    /**
     * 建档人
     */
    private String creatOr;

    private SysPerson person;

    private Area area;

    public String getFamiCode() {
        return famiCode;
    }

    public void setFamiCode(String famiCode) {
        this.famiCode = famiCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
    }

    public String getPersCode() {
        return persCode;
    }

    public void setPersCode(String persCode) {
        this.persCode = persCode;
    }

    public String getHousePro() {
        return housePro;
    }

    public void setHousePro(String housePro) {
        this.housePro = housePro;
    }

    public int getPopuNum() {
        return popuNum;
    }

    public void setPopuNum(int popuNum) {
        this.popuNum = popuNum;
    }

    public int getAgriNum() {
        return agriNum;
    }

    public void setAgriNum(int agriNum) {
        this.agriNum = agriNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public String getCreatOr() {
        return creatOr;
    }

    public void setCreatOr(String creatOr) {
        this.creatOr = creatOr;
    }

    public SysPerson getPerson() {
        return person;
    }

    public void setPerson(SysPerson person) {
        this.person = person;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "SysFamily{" +
                "famiCode='" + famiCode + '\'' +
                ", town='" + town + '\'' +
                ", village='" + village + '\'' +
                ", groupNo='" + groupNo + '\'' +
                ", persCode='" + persCode + '\'' +
                ", housePro='" + housePro + '\'' +
                ", popuNum=" + popuNum +
                ", agriNum=" + agriNum +
                ", address='" + address + '\'' +
                ", creatTime=" + creatTime +
                ", creatOr='" + creatOr + '\'' +
                ", person=" + person +
                ", area=" + area +
                '}';
    }
}
