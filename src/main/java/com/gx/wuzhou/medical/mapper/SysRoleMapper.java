/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysRoleMapper
 * Author:   Administrator
 * Date:     2020/6/6 0006 8:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.mapper;

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
public interface SysRoleMapper {
    /**
     * 查询角色所有信息
     *
     * @param role
     * @return
     */
    public List<SysRole> selectSysRoleList(SysRole role);

    /**
     * 通过编号查询对应的角色
     *
     * @param userId
     * @return
     */
    public List<SysRole> selectRoleByUserId(String userId);

    /**
     * 查询用户信息
     *
     * @param roleId
     * @return
     */
    public SysRole selectRoleId(String roleId);

    /**
     * 添加角色
     *
     * @param role
     */
    public void insertRole(SysRole role);

    /**
     * 修改角色信息
     *
     * @param role
     */
    public void updateRole(SysRole role);

    /**
     * 删除角色
     *
     * @param roleId
     */
    public void deleteRole(String roleId);
}
