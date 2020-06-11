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

    @Override
    public List<SysRole> selectRoleByUserId(String userId) {
        List<SysRole> userRoles = roleMapper.selectRoleByUserId(userId);
        List<SysRole> roles = roleMapper.selectSysRoleList(null);
        for (SysRole role : roles){
            for (SysRole userRole : userRoles){
                if (role.getRoleId().equals(userRole.getRoleId())){
                    role.setFlag(true);
                    break;
                }
            }
        }
        return roles;
    }

    @Override
    public SysRole selectRoleId(String roleId) {
        return roleMapper.selectRoleId(roleId);
    }

    /**
     * 封装添加角色权限方法
     *
     * @param role
     * @param fid
     * @return
     */
    public List<SysRoleMenu> findList(SysRole role, String[] fid){
        List<SysRoleMenu> list = new ArrayList<SysRoleMenu>();
        for (String menuId : fid){
            SysRoleMenu roleMenu = new SysRoleMenu();
            roleMenu.setRoleId(role.getRoleId());
            roleMenu.setMenuId(menuId);
            list.add(roleMenu);
        }
        return list;
    }

    @Transactional
    @Override
    public int insert(SysRole role, String[] fid) {
        int row=0;
        insertRole(role);
        List<SysRoleMenu> list =findList(role, fid);
        if (list.size()>0){
        row = insertRoleMenu(list);
        }
        return row;
    }

    @Transactional
    @Override
    public int update(SysRole role, String[] fid) {
        updateRole(role);
        deleteRoleMenu(role.getRoleId());
        return insertRoleMenu(role, fid);
    }

    @Transactional
    @Override
    public void delete(String roleId) {
        deleteRole(roleId);
        deleteRoleMenu(roleId);
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

    /**
     * 添加角色菜单权限
     *
     * @param role
     * @param fid
     * @return
     */
    public int insertRoleMenu(SysRole role, String[] fid){
        List<SysRoleMenu> list = findList(role, fid);
        return roleMenuMapper.insertRoleMenu(list);
    }

    /**
     * 修改角色
     *
     * @param role
     */
    public void updateRole(SysRole role){
        roleMapper.updateRole(role);
    }

    /**
     * 删除角色权限信息
     *
     * @param roleId
     * @return
     */
    public int deleteRoleMenu(String roleId){
        return roleMenuMapper.deleteRoleMenuId(roleId);
    }

    /**
     * 删除角色
     *
     * @param roleId
     */
    public void deleteRole(String roleId){
        roleMapper.deleteRole(roleId);
    }
}
