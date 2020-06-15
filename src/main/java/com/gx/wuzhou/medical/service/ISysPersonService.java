/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: ISysPersonService
 * Author:   Administrator
 * Date:     2020/6/14 0014 11:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service;

import com.gx.wuzhou.medical.domain.SysPerson;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/14 0014
 * @since 1.0.0
 */
public interface ISysPersonService {
    /**
     * 查询所有家庭信息
     *
     * @param sysPerson
     * @return
     */
    public List<SysPerson> selectPersonList(SysPerson sysPerson);

    /**
     * 查询村里面的农民
     *
     * @param areaCode
     * @param persName
     * @return
     */
    public List<SysPerson> selectPersonAndPaymentList(String areaCode, String persName);

    /**
     * 查询没有缴费的家庭
     *
     * @param famiCode
     * @param runyear
     * @return
     */
    public List<SysPerson> findByPersonAndPayment(String famiCode, int runyear);

    /**
     * 删除
     *
     * @param persCode
     * @return
     */
    public int deletePerson(String persCode, String famiCode);
}
