/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysRoleController
 * Author:   Administrator
 * Date:     2020/6/6 0006 8:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.controller;

import com.gx.wuzhou.medical.domain.SysRole;
import com.gx.wuzhou.medical.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/6 0006
 * @since 1.0.0
 */
@Controller
@RequestMapping("page/role")
public class SysRoleController {
    private String prefix = "page/role";

    @Autowired
    private ISysRoleService roleService;

    @GetMapping("list")
    public String list(ModelMap mmap, SysRole role){
        List<SysRole> list = roleService.selectSysRoleList(role);
        mmap.put("list", list);
        return "role_list";
    }

    @PostMapping("add")
    public String add(SysRole role, String[] fid){
        if (roleService.insert(role, fid) == 0){
            return "error";
        }else
        return "redirect:/page/role/list";
    }
}
