/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: Area
 * Author:   Administrator
 * Date:     2020/6/8 0008 22:22
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
 * @create 2020/6/8 0008
 * @since 1.0.0
 */
public class Area extends BaseUtil {
    private Integer id;
    /**
     * 乡镇区域编码:县、镇、村、组
     */
    private String areaCode;
    /**
     * 上一级
     */
    private String  parent;

    /**
     * 行政区域名称
     */
    private String areaName;
    /**
     * 行政区域级别：1表示县级，2表示镇级，3表示村，4表示组
     */
    private Integer grade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaCode='" + areaCode + '\'' +
                ", parent=" + parent +
                ", areaName='" + areaName + '\'' +
                ", grade=" + grade +
                '}';
    }
}
