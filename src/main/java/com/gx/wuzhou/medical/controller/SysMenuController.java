/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysMenuController
 * Author:   Administrator
 * Date:     2020/6/6 0006 15:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.controller;

import com.gx.wuzhou.medical.core.domain.Ztree;
import com.gx.wuzhou.medical.domain.SysRole;
import com.gx.wuzhou.medical.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("menu")
public class SysMenuController{
    @Autowired
    private ISysMenuService menuService;

    @PostMapping("roleAdd")
    @ResponseBody
    public List<Ztree> roleMenuTree(SysRole role){
        List<Ztree> ztrees = menuService.roleMenuZtree(role);
        return ztrees;
    }
}
