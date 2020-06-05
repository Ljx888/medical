/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: LoginServiceImpl
 * Author:   Administrator
 * Date:     2020/6/4 0004 15:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service.impl;

import com.gx.wuzhou.medical.domain.SysUser;
import com.gx.wuzhou.medical.mapper.SysUserMapper;
import com.gx.wuzhou.medical.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/4 0004
 * @since 1.0.0
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private SysUserMapper userMapper;

    @Override
    public SysUser login(SysUser user) {
        return userMapper.selectUserIdAndPwd(user);
    }
}
