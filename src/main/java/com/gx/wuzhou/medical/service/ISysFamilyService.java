/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: ISysFamilyService
 * Author:   Administrator
 * Date:     2020/6/13 0013 10:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service;

import com.gx.wuzhou.medical.domain.SysFamily;
import com.gx.wuzhou.medical.domain.SysPerson;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/13 0013
 * @since 1.0.0
 */
public interface ISysFamilyService {
    /**
     * 查询
     *
     * @param family
     * @return
     */
    public List<SysFamily> selectFamilyList(SysFamily family);

    /**
     * 添加
     *
     * @param family
     * @param person
     * @return
     */
    public int insert(SysFamily family, SysPerson person);

    /**
     * 添加家人信息
     *
     * @return
     */
    public int insertMemder(SysPerson person, int popuNum, int agriNum);

    /**
     * 条件查询
     * @param persCode
     * @return
     */
    public SysPerson selectPerson(String persCode);

    /**
     * 修改个人用户信息
     *
     * @param person
     * @return
     */
    public int updatePerson(SysPerson person);

    /**
     * 删除
     *
     * @return
     */
    public int delete(String famiCode);
}
