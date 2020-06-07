/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysRoleServiceImpl
 * Author:   Administrator
 * Date:     2020/6/6 0006 8:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service.impl;

import com.gx.wuzhou.medical.domain.SysRole;
import com.gx.wuzhou.medical.domain.SysRoleMenu;
import com.gx.wuzhou.medical.mapper.SysRoleMapper;
import com.gx.wuzhou.medical.mapper.SysRoleMenuMapper;
import com.gx.wuzhou.medical.service.ISysRoleService;
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
public class SysRoleServiceImpl implements ISysRoleService {
    @Autowired
    private SysRoleMapper roleMapper;
    @Autowired
    private SysRoleMenuMapper roleMenuMapper;

    @Override
    public List<SysRole> selectSysRoleList(SysRole role) {
        return roleMapper.selectSysRoleList(role);
    }

    @Transactional
    @Override
    public int insert(SysRole role, String[] fid) {
        int row=0;
        insertRole(role);
        List<SysRoleMenu> list = new ArrayList<SysRoleMenu>();
        for (String menuId : fid){
            SysRoleMenu roleMenu = new SysRoleMenu();
            roleMenu.setRoleId(role.getRoleId());
            roleMenu.setMenuId(menuId);
            list.add(roleMenu);
        }
        if (list.size()>0){
        row = insertRoleMenu(list);
        }
        return row;
    }

    /**
     * 添加用户
     * @param role
     */
    public void insertRole(SysRole role){
        roleMapper.insertRole(role);
    }

    /**
     * 添加角色菜单编号
     * @param roleMenuList
     * @return
     */
    public int insertRoleMenu(List<SysRoleMenu> roleMenuList){
        return roleMenuMapper.insertRoleMenu(roleMenuList);
    }
}
