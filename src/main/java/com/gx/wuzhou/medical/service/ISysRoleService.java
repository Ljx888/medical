/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: ISysRoleService
 * Author:   Administrator
 * Date:     2020/6/6 0006 8:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service;

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
public interface ISysRoleService {
    /**
     * 查询角色所有信息
     *
     * @param role
     * @return
     */
    public List<SysRole> selectSysRoleList(SysRole role);

    /**
     * 查询角色信息
     *
     * @param roleId
     * @return
     */
    public SysRole selectRoleId(String roleId);

    /**
     * 添加
     *
     * @param role
     * @param fid
     * @return
     */
    public int insert(SysRole role, String[] fid);

    /**
     * 修改角色权限
     *
     * @param role
     * @param fid
     * @return
     */
    public int update(SysRole role, String[] fid);

    /**
     * 删除
     *
     * @param roleId
     */
    public void delete(String roleId);
}
