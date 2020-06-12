/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysMenuServiceImpl
 * Author:   Administrator
 * Date:     2020/6/6 0006 15:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service.impl;

import com.gx.wuzhou.medical.core.domain.Ztree;
import com.gx.wuzhou.medical.domain.SysMenu;
import com.gx.wuzhou.medical.domain.SysRole;
import com.gx.wuzhou.medical.mapper.SysMenuMapper;
import com.gx.wuzhou.medical.mapper.SysRoleMenuMapper;
import com.gx.wuzhou.medical.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/6 0006
 * @since 1.0.0
 */
@Service
public class SysMenuServiceImpl implements ISysMenuService {

    @Autowired
    private SysMenuMapper menuMapper;
    @Autowired
    private SysRoleMenuMapper roleMenuMapper;

    @Override
    public List<SysMenu> selectMenuAll() {
        List<SysMenu> menuList = menuMapper.selectMenuAll();
        return menuList;
    }

    @Override
    public List<SysMenu> selectMenuList(SysMenu menu) {
        return menuMapper.selectMenuList(menu);
    }

    @Override
    public List<SysMenu> selectUserMenuList(String userId) {
        return menuMapper.selectUserMenuList(userId);
    }

    @Override
    public SysMenu selectMenu(String menuId) {
        return menuMapper.selectMenu(menuId);
    }

    public List<Ztree> roleMenuZtree(SysRole role){
        String roleId = role.getRoleId();
        List<Ztree> ztrees = new ArrayList<Ztree>();
        List<SysMenu> menuList = selectMenuAll();
        if (roleId != null){
            List<String> list = menuMapper.selectRoleTree(roleId);
            ztrees = initZtree(menuList, list, true);
        } else {
            ztrees = initZtree(menuList, null, true);
        }
        return ztrees;
    }

    @Override
    public int saveMenu(SysMenu menu) {
        return menuMapper.saveMenu(menu);
    }

    @Override
    public int updateMenu(SysMenu menu) {
        return menuMapper.updateMenu(menu);
    }

    @Transactional
    @Override
    public int delete(String menuId) {
        roleMenuMapper.deleteMenuRoleId(menuId);
        return menuMapper.deleteMenu(menuId);
    }

    /**
     *
     * @param menuList
     * @param sysRoleList
     * @param permsFlag 是否需要显示权限标识
     * @return 树构建列表
     */
    public List<Ztree> initZtree (List<SysMenu> menuList, List<String> sysRoleList, boolean permsFlag){
        List<Ztree> list = new ArrayList<Ztree>();

        for (SysMenu menu: menuList){
            Ztree ztree = new Ztree();
            ztree.setId(menu.getMenuId());
            ztree.setName(transMenuName(menu, sysRoleList, permsFlag));
            ztree.setPid(menu.getMenuPid());
            ztree.setTitle(menu.getMenuName());
            if (sysRoleList != null){
                ztree.setChecked(sysRoleList.contains(menu.getMenuId()));
            }
            list.add(ztree);
        }

        return list;
    }

    public String transMenuName(SysMenu menu, List<String> roleMenuList, boolean permsFlag)
    {
        StringBuffer sb = new StringBuffer();
        sb.append(menu.getMenuName());
        if (permsFlag)
        {
            sb.append(menu.getUrl());
        }
        return sb.toString();
    }
}
