/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysUserMapper
 * Author:   Administrator
 * Date:     2020/6/3 0003 23:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.mapper;

import com.gx.wuzhou.medical.domain.SysUser;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/3 0003
 * @since 1.0.0
 */
public interface SysUserMapper {
    /**
     * 查询账号密码
     *
     * @return
     */
    public SysUser selectUserIdAndPwd(SysUser user);

    /**
     * 查询用户全部数据
     *
     * @return
     */
    public List<SysUser> selectUserList(SysUser user);

}
