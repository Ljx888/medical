/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: Institution
 * Author:   Administrator
 * Date:     2020/6/9 0009 10:01
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
 * @create 2020/6/9 0009
 * @since 1.0.0
 */
public class Institution extends BaseUtil {
    /**
     * 行政区域编码，类标识符
     */
    private String areaCode;
    /**
     * 经办机构编码
     */
    private String agenCode;
    /**
     * 经办机构名称
     */
    private String agenName;
    /**
     * 经办机构级别，区别于行政区域级别，1表示县级农合办，2表示镇级农合点
     */
    private int grade;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAgenCode() {
        return agenCode;
    }

    public void setAgenCode(String agenCode) {
        this.agenCode = agenCode;
    }

    public String getAgenName() {
        return agenName;
    }

    public void setAgenName(String agenName) {
        this.agenName = agenName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Institution{" +
                "areaCode='" + areaCode + '\'' +
                ", agenCode='" + agenCode + '\'' +
                ", agenName='" + agenName + '\'' +
                ", grade=" + grade +
                '}';
    }
}
