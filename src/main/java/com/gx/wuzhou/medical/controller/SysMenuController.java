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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gx.wuzhou.medical.core.domain.Ztree;
import com.gx.wuzhou.medical.domain.SysMenu;
import com.gx.wuzhou.medical.domain.SysRole;
import com.gx.wuzhou.medical.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("page/menu")
public class SysMenuController{
    @Autowired
    private ISysMenuService menuService;

    @GetMapping("ztree")
    @ResponseBody
    public List<Ztree> roleMenuTree(SysRole role){
        List<Ztree> ztrees = menuService.roleMenuZtree(role);
        System.out.println(ztrees.toString());
        return ztrees;
    }

    @GetMapping("list")
    public String menuList(SysMenu menu, ModelMap mmap, @RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo){
        Integer pageSize = 5;
        PageHelper.startPage(pageNo, pageSize);
        List<SysMenu> list = menuService.selectMenuList(menu);
        PageInfo<SysMenu> pageInfo = new PageInfo<SysMenu>(list);
        mmap.put("pageInfo", pageInfo);
        return "menu_list";
    }

    @GetMapping("input")
    public String input(SysMenu menu, ModelMap mmap){
        List<SysMenu> list = menuService.selectMenuList(menu);
        mmap.put("menu", list);
        return "menu_add";
    }

    @GetMapping("get")
    public String get(String menuId, ModelMap mmap){
        SysMenu menu = menuService.selectMenu(menuId);
        List<SysMenu> list = menuService.selectMenuList(null);
        mmap.put("list", list);
        mmap.put("menu", menu);
        return "menu_edit";
    }

    @PostMapping("add")
    public String add(SysMenu menu, String cid){
        String menuPid = cid.split("-")[0];
        String levels = cid.split("-")[1];
        menu.setMenuPid(menuPid);
        Integer level = Integer.parseInt(levels);
        menu.setLevel(level+1);
        if (menuService.saveMenu(menu) == 0){
            return "error";
        }
        return "redirect:/page/menu/list";
    }

    @PostMapping("edit")
    public String edit(SysMenu menu, String cid){
        String menuPid = cid.split("-")[0];
        String levels = cid.split("-")[1];
        Integer level = Integer.parseInt(levels);
        menu.setMenuPid(menuPid);
        menu.setLevel(level+1);
        menuService.updateMenu(menu);
        return "redirect:/page/menu/list";
    }

    @GetMapping("del")
    public String delete(String menuId){
        menuService.delete(menuId);
        return "redirect:/page/menu/list";
    }
}
