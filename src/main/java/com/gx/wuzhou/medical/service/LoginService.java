/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: LoginService
 * Author:   Administrator
 * Date:     2020/6/4 0004 15:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service;

import com.gx.wuzhou.medical.domain.SysUser;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/4 0004
 * @since 1.0.0
 */
public interface LoginService {
    /**
     * 登录
     *
     * @param user
     * @return
     */
    public SysUser login(SysUser user);
}
