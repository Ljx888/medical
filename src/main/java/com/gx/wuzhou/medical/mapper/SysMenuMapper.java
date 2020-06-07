/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysMenuMapper
 * Author:   Administrator
 * Date:     2020/6/6 0006 15:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.mapper;

import com.gx.wuzhou.medical.domain.SysMenu;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/6 0006
 * @since 1.0.0
 */
public interface SysMenuMapper {
    /**
     * 查询权限全部信息
     *
     * @return
     */
    public List<SysMenu> selectMenuAll();

    /**
     * 查询角色权限
     *
     * @param roleId
     * @return
     */
    public List<String> selectRoleTree(String roleId);
}
