/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysUserController
 * Author:   Administrator
 * Date:     2020/6/10 0010 23:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.controller;

import com.gx.wuzhou.medical.domain.Institution;
import com.gx.wuzhou.medical.domain.SysRole;
import com.gx.wuzhou.medical.domain.SysUser;
import com.gx.wuzhou.medical.service.ISysRoleService;
import com.gx.wuzhou.medical.service.ISysUserService;
import com.gx.wuzhou.medical.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/10 0010
 * @since 1.0.0
 */
@Controller
@RequestMapping("page/user")
public class SysUserController {
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysRoleService roleService;
    @Autowired
    private InstitutionService initService;

    @GetMapping("list")
    public String list(ModelMap mmap, SysUser user){
        List<SysUser> list = userService.selectUserList(user);
        mmap.put("list", list);
        return "user_list";
    }

    @GetMapping("input")
    public String input(ModelMap mmap){
        List<SysRole> roles = roleService.selectSysRoleList(null);
        List<Institution> init = initService.selectInitList(null);

        mmap.put("roles", roles);
        mmap.put("init", init);

        return "user_add";
    }

    @GetMapping("get")
    public String get(String userId, ModelMap mmap){
        SysUser user = userService.selectUser(userId);
        List<SysRole> roles = roleService.selectRoleByUserId(userId);
        List<Institution> init = initService.selectInitList(null);

        mmap.put("user", user);
        mmap.put("roles", roles);
        mmap.put("init", init);

        return "user_edit";
    }

    @PostMapping("add")
    public String add(SysUser user, String[] roleIds){
        System.out.println(user.toString()+""+roleIds.toString());
        userService.insert(user, roleIds);
        return "redirect:/page/user/list";
    }

    @PostMapping("edit")
    public String edit(SysUser user, String[] roleIds){
        userService.update(user, roleIds);
        return "redirect:/page/user/list";
    }

    @GetMapping("del")
    public String delete(String userId){
        userService.delete(userId);
        return "redirect:/page/user/list";
    }
}
