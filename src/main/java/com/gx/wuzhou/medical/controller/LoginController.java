/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: LoginController
 * Author:   Administrator
 * Date:     2020/6/4 0004 15:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.controller;

import com.gx.wuzhou.medical.domain.SysMenu;
import com.gx.wuzhou.medical.domain.SysUser;
import com.gx.wuzhou.medical.service.ISysMenuService;
import com.gx.wuzhou.medical.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/4 0004
 * @since 1.0.0
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private ISysMenuService menuService;

    @PostMapping("login")
    public String login(SysUser user, ModelMap mmap, HttpServletRequest request){
        if (loginService.login(user) != null){
            List<SysMenu> list = menuService.selectUserMenuList(user.getUserId());
            mmap.put("list", list);

            SysUser sysUser = loginService.login(user);
            HttpSession session = request.getSession();
            session.setAttribute("user", sysUser);
        }
        return "/index";
    }

    @GetMapping("quit")
    public String quit(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "/login";
    }
}
