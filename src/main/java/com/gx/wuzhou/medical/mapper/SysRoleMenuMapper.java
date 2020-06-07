/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysRoleMenuMapper
 * Author:   Administrator
 * Date:     2020/6/7 0007 21:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.mapper;

import com.gx.wuzhou.medical.domain.SysRoleMenu;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/7 0007
 * @since 1.0.0
 */
public interface SysRoleMenuMapper {
    /**
     * 保存角色菜单编号
     * @param roleMenuList
     */
    public int insertRoleMenu(List<SysRoleMenu> roleMenuList);
}
