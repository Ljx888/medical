/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: ISysMenuService
 * Author:   Administrator
 * Date:     2020/6/6 0006 15:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service;

import com.gx.wuzhou.medical.core.domain.Ztree;
import com.gx.wuzhou.medical.domain.SysMenu;
import com.gx.wuzhou.medical.domain.SysRole;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/6 0006
 * @since 1.0.0
 */
public interface ISysMenuService {
    /**
     * 查询所有权限树
     * @return
     */
    public List<SysMenu> selectMenuAll();

    /**
     * 查询菜单信息
     *
     * @return
     */
    public List<SysMenu> selectMenuList(SysMenu menu);

    /**
     * 查询用户权限信息
     *
     * @param userId
     * @return
     */
    public List<SysMenu> selectUserMenuList(String userId);

    /**
     * 查询菜单
     *
     * @param menuId
     * @return
     */
    public SysMenu selectMenu(String menuId);

    /**
     *根据角色编号查询
     *
     * @param role
     * @return
     */
    public List<Ztree> roleMenuZtree(SysRole role);

    /**
     * 添加菜单
     *
     * @param menu
     * @return
     */
    public int saveMenu(SysMenu menu);

    /**
     * 修改菜单
     *
     * @param menu
     * @return
     */
    public int updateMenu(SysMenu menu);

    /**
     * 删除
     *
     * @param menuId
     * @return
     */
    public int delete(String menuId);
}
