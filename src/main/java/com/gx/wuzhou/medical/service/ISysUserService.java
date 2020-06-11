/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: ISysUserService
 * Author:   Administrator
 * Date:     2020/6/4 0004 15:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service;

import com.gx.wuzhou.medical.domain.SysUser;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/4 0004
 * @since 1.0.0
 */
public interface ISysUserService {
    /**
     * 查询用户全部数据
     *
     * @return
     */
    public List<SysUser> selectUserList(SysUser user);

    /**
     * 对象查询
     *
     * @return
     */
    public SysUser selectUser(String userId);

    /**
     * 添加
     *
     * @param user
     * @return
     */
    public int insert(SysUser user, String[] roleId);

    /**
     * 修改
     *
     * @param user
     * @return
     */
    public int update(SysUser user, String[] roleId);

    /**
     * 删除
     *
     * @param userId
     * @return
     */
    public int delete(String userId);
}
