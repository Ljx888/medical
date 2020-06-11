/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysUserServiceImpl
 * Author:   Administrator
 * Date:     2020/6/4 0004 15:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service.impl;

import com.gx.wuzhou.medical.domain.SysUser;
import com.gx.wuzhou.medical.domain.SysUserRole;
import com.gx.wuzhou.medical.mapper.SysUserMapper;
import com.gx.wuzhou.medical.mapper.SysUserRoleMapper;
import com.gx.wuzhou.medical.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/4 0004
 * @since 1.0.0
 */
@Service
public class SysUserServiceImpl implements ISysUserService {
    @Autowired
    public SysUserMapper userMapper;
    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Override
    public List<SysUser> selectUserList(SysUser user) {
        return userMapper.selectUserList(user);
    }

    @Override
    public SysUser selectUser(String userId) {
        return userMapper.selectUser(userId);
    }

    public List<SysUserRole> userRoleList(SysUser user, String[] roleIds){
        List<SysUserRole> list = new ArrayList<SysUserRole>();
        for (String roleId : roleIds){
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(user.getUserId());
            userRole.setRoleId(roleId);
            list.add(userRole);
        }

        return list;
    }

    @Override
    public int insert(SysUser user, String[] roleId) {
        int row = 0;
        insertUser(user);
        List<SysUserRole> list = userRoleList(user,roleId);
        if (list.size()>0){
            row = insertUserRole(list);
        }
        return row;
    }

    public int insertUser(SysUser user){
        return userMapper.insertUser(user);
    }

    public int insertUserRole(List<SysUserRole> userRoleList){
        return userRoleMapper.insertUserRole(userRoleList);
    }

    public int insertUserRole(SysUser user, String[] roleId){
        List<SysUserRole> list = userRoleList(user, roleId);
        return insertUserRole(list);
    }

    @Override
    public int update(SysUser user, String[] roleId) {
        updateUser(user);
        deleteUserRole(user.getUserId());
        return insertUserRole(user, roleId);
    }

    public void updateUser(SysUser user){
        userMapper.updateUser(user);
    }

    @Override
    public int delete(String userId) {
        deleteUser(userId);
        return deleteUserRole(userId);
    }

    public void deleteUser(String userId){
        userMapper.deleteUser(userId);
    }

    public int deleteUserRole(String userId){
        return userRoleMapper.deleteRoleUserId(userId);
    }
}
