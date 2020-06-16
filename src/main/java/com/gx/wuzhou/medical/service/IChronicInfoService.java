/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: IChronicInfoService
 * Author:   Administrator
 * Date:     2020/6/16 0016 11:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service;

import com.gx.wuzhou.medical.domain.ChronicInfo;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/16 0016
 * @since 1.0.0
 */
public interface IChronicInfoService {
    /**
     * 查询
     *
     * @param chronicInfo
     * @return
     */
    public List<ChronicInfo> selectChroniclnfoList(ChronicInfo chronicInfo);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    public ChronicInfo selectChroniclnfo(String id);

    /**
     *
     * 添加
     * @param chronicInfo
     * @return
     */
    public int insertChroniclnfo(ChronicInfo chronicInfo);

    /**
     * 修改
     *
     * @param chronicInfo
     * @return
     */
    public int updateChroniclnfo(ChronicInfo chronicInfo);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int deleteChroniclnfo(String id);
}
