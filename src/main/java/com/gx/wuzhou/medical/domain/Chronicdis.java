/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: Chronicdis
 * Author:   Administrator
 * Date:     2020/6/11 0011 20:17
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
 * @create 2020/6/11 0011
 * @since 1.0.0
 */
public class Chronicdis extends BaseUtil {
    //疾病编号
    private String illCode;
    //疾病名称
    private String illName;
    //拼音码
    private String pyCode;
    //五笔码
    private String wbCode;

    public String getIllCode() {
        return illCode;
    }

    public void setIllCode(String illCode) {
        this.illCode = illCode;
    }

    public String getIllName() {
        return illName;
    }

    public void setIllName(String illName) {
        this.illName = illName;
    }

    public String getPyCode() {
        return pyCode;
    }

    public void setPyCode(String pyCode) {
        this.pyCode = pyCode;
    }

    public String getWbCode() {
        return wbCode;
    }

    public void setWbCode(String wbCode) {
        this.wbCode = wbCode;
    }

    @Override
    public String toString() {
        return "Chronicdis{" +
                "illCode='" + illCode + '\'' +
                ", illName='" + illName + '\'' +
                ", pyCode='" + pyCode + '\'' +
                ", wbCode='" + wbCode + '\'' +
                '}';
    }
}
