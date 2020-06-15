/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysPersonMapper
 * Author:   Administrator
 * Date:     2020/6/13 0013 9:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.mapper;

import com.gx.wuzhou.medical.domain.SysPerson;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/13 0013
 * @since 1.0.0
 */
public interface SysPersonMapper {
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
    public List<SysPerson> selectPersonAndPaymentList(@Param("areaCode") String areaCode, @Param("persName") String persName);

    /**
     * 查询没有缴费的家庭
     *
     * @param famiCode
     * @param runyear
     * @return
     */
    public List<SysPerson> findByPersonAndPayment(@Param("famiCode") String famiCode,@Param("runyear") int runyear);

    /**
     * 添加
     *
     * @param person
     * @return
     */
    public int insertPerson(SysPerson person);

    /**
     * 修改
     *
     * @param person
     * @return
     */
    public int updatePerson(SysPerson person);

    /**
     * 查询
     *
     * @param persCode
     * @return
     */
    public SysPerson selectPerson(String persCode);

    /**
     *
     *
     * @param famiCode
     * @return
     */
    public String createPerscode(String famiCode);

    /**
     * 删除
     *
     * @param persCode
     * @return
     */
    public int deletePerson(String persCode);

    /**
     * 懒得解释
     *
     * @param persCode
     * @return
     */
    public int deletePersonId(String persCode);
}
