/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: ChronicInfo
 * Author:   Administrator
 * Date:     2020/6/15 0015 23:51
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
 * @create 2020/6/15 0015
 * @since 1.0.0
 */
public class ChronicInfo extends BaseUtil {
    /**
     * 慢病档案编号=农合证号(14位)+建档时间（14位）
     */
    private String id;
    /**
     * 农合证号
     */
    private String persCode;
    /**
     * 疾病编码
     */
    private String illCode;
    /**
     * 慢病起始时间
     */
    private String startTime;
    /**
     * 慢病治愈时间
     */
    private String endTime;

    /**
     * 状态:1表示正常、0表示注销
     */
    private String status;
    /**
     * 建档时间
     */
    private String creatTime;
    /**
     * 建档人
     */
    private String creatOr;

    private SysPerson person;

    private Chronicdis chronicdis;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersCode() {
        return persCode;
    }

    public void setPersCode(String persCode) {
        this.persCode = persCode;
    }

    public String getIllCode() {
        return illCode;
    }

    public void setIllCode(String illCode) {
        this.illCode = illCode;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Chronicdis getChronicdis() {
        return chronicdis;
    }

    public void setChronicdis(Chronicdis chronicdis) {
        this.chronicdis = chronicdis;
    }

    @Override
    public String toString() {
        return "ChronicInfo{" +
                "id='" + id + '\'' +
                ", persCode='" + persCode + '\'' +
                ", illCode='" + illCode + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", status='" + status + '\'' +
                ", creatTime=" + creatTime +
                ", creatOr='" + creatOr + '\'' +
                ", person=" + person +
                ", chronicdis=" + chronicdis +
                '}';
    }
}
