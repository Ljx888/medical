/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysUserRoleMapper
 * Author:   Administrator
 * Date:     2020/6/11 0011 13:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.mapper;

import com.gx.wuzhou.medical.domain.SysUserRole;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/11 0011
 * @since 1.0.0
 */
public interface SysUserRoleMapper {
    /**
     * 添加
     *
     * @param userRoleList
     * @return
     */
    public int insertUserRole(List<SysUserRole> userRoleList);

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    public int deleteRoleUserId(String userId);

    /**
     * 删除角色
     *
     * @return
     */
    public int deleteUserRoleId(String roleId);
}
