/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysMedical
 * Author:   Administrator
 * Date:     2020/6/12 0012 9:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.domain;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/12 0012
 * @since 1.0.0
 */
public class SysMedical {
    /**
     * 机构编码
     */
    private String jgbm;
    /**
     * 组织机构编码
     */
    private String zzjgbm;
    /**
     * 机构名称
     */
    private String jgmc;
    /**
     * 地区编码
     */
    private String dqbm;
    /**
     * 行政区域编码
     */
    private String areaCode;
    /**
     * 隶属关系
     */
    private String lsgx;


    /**
     * 机构级别
     */
    private String jgjb;
    /**
     * 申报定点类型
     */
    private String sbddlx;
    /**
     * 批准定点类型
     */
    private String pzddlx;
    /**
     * 所属经济类型
     */
    private String ssjjlx;
    /**
     * 卫生机构大类
     */
    private String wsjgdl;
    /**
     * 卫生机构小类
     */
    private String wsjgxl;

    /**
     * 主管单位
     */
    private String zgdw;
    /**
     * 开业时间
     */
    private String kysj;
    /**
     * 法人代表
     */
    private String frdb;
    /**
     * 注册资金
     */
    private double zczj;

    private Area area;

    private S201 s201;


    public String getJgbm() {
        return jgbm;
    }

    public void setJgbm(String jgbm) {
        this.jgbm = jgbm;
    }

    public String getZzjgbm() {
        return zzjgbm;
    }

    public void setZzjgbm(String zzjgbm) {
        this.zzjgbm = zzjgbm;
    }

    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    public String getDqbm() {
        return dqbm;
    }

    public void setDqbm(String dqbm) {
        this.dqbm = dqbm;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getLsgx() {
        return lsgx;
    }

    public void setLsgx(String lsgx) {
        this.lsgx = lsgx;
    }

    public String getJgjb() {
        return jgjb;
    }

    public void setJgjb(String jgjb) {
        this.jgjb = jgjb;
    }

    public String getSbddlx() {
        return sbddlx;
    }

    public void setSbddlx(String sbddlx) {
        this.sbddlx = sbddlx;
    }

    public String getPzddlx() {
        return pzddlx;
    }

    public void setPzddlx(String pzddlx) {
        this.pzddlx = pzddlx;
    }

    public String getSsjjlx() {
        return ssjjlx;
    }

    public void setSsjjlx(String ssjjlx) {
        this.ssjjlx = ssjjlx;
    }

    public String getWsjgdl() {
        return wsjgdl;
    }

    public void setWsjgdl(String wsjgdl) {
        this.wsjgdl = wsjgdl;
    }

    public String getWsjgxl() {
        return wsjgxl;
    }

    public void setWsjgxl(String wsjgxl) {
        this.wsjgxl = wsjgxl;
    }

    public String getZgdw() {
        return zgdw;
    }

    public void setZgdw(String zgdw) {
        this.zgdw = zgdw;
    }

    public String getKysj() {
        return kysj;
    }

    public void setKysj(String kysj) {
        this.kysj = kysj;
    }

    public String getFrdb() {
        return frdb;
    }

    public void setFrdb(String frdb) {
        this.frdb = frdb;
    }

    public double getZczj() {
        return zczj;
    }

    public void setZczj(double zczj) {
        this.zczj = zczj;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public S201 getS201() {
        return s201;
    }

    public void setS201(S201 s201) {
        this.s201 = s201;
    }

    @Override
    public String toString() {
        return "SysMedical{" +
                "jgbm='" + jgbm + '\'' +
                ", zzjgbm='" + zzjgbm + '\'' +
                ", jgmc='" + jgmc + '\'' +
                ", dqbm='" + dqbm + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", lsgx='" + lsgx + '\'' +
                ", jgjb='" + jgjb + '\'' +
                ", sbddlx='" + sbddlx + '\'' +
                ", pzddlx='" + pzddlx + '\'' +
                ", ssjjlx='" + ssjjlx + '\'' +
                ", wsjgdl='" + wsjgdl + '\'' +
                ", wsjgxl='" + wsjgxl + '\'' +
                ", zgdw='" + zgdw + '\'' +
                ", kysj='" + kysj + '\'' +
                ", frdb='" + frdb + '\'' +
                ", zczj=" + zczj +
                ", area=" + area +
                ", s201=" + s201 +
                '}';
    }
}
