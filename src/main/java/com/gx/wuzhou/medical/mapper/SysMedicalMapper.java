/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysMedicalMapper
 * Author:   Administrator
 * Date:     2020/6/12 0012 9:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.mapper;

import com.gx.wuzhou.medical.domain.SysMedical;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/12 0012
 * @since 1.0.0
 */
public interface SysMedicalMapper {
    /**
     * 查询医疗机构
     *
     * @param medical
     * @return
     */
    public List<SysMedical> selectMedicalList(SysMedical medical);

    /**
     *查询对应信息
     *
     * @param jgbm
     * @return
     */
    public SysMedical selectMedical(String jgbm);

    /**
     * 添加
     *
     * @param medical
     * @return
     */
    public int saveSysMedical(SysMedical medical);

    /**
     * 修改
     *
     * @param medical
     * @return
     */
    public int updateSysMedical(SysMedical medical);

    /**
     * 删除
     *
     * @param jgbm
     * @return
     */
    public int deleteSysMedical(String jgbm);
}
