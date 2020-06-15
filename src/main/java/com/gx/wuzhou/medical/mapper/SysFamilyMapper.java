/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysFamilyMapper
 * Author:   Administrator
 * Date:     2020/6/13 0013 9:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.mapper;

import com.gx.wuzhou.medical.domain.SysFamily;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/13 0013
 * @since 1.0.0
 */
public interface SysFamilyMapper {
    /**
     * 查询
     *
     * @param family
     * @return
     */
    public List<SysFamily> selectFamilyList(SysFamily family);

    /**
     * 查询家庭档案信息
     *
     * @param famiCode
     * @return
     */
    public SysFamily selectFamily(String famiCode);

    /**
     * 通过组别名查询最大的家庭编号
     *
     * @param groupNo
     * @return
     */
    public String createFamicode(String groupNo);

    /**
     * 添加
     *
     * @param family
     * @return
     */
    public int insertFamily(SysFamily family);

    /**
     * 修改
     *
     * @param family
     * @return
     */
    public int updateFamily(SysFamily family);

    /**
     * 删除
     *
     * @param famiCode
     * @return
     */
    public int deleteFamily(String famiCode);
}
