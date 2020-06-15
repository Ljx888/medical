/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: AreaController
 * Author:   Administrator
 * Date:     2020/6/8 0008 22:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.controller;

import com.gx.wuzhou.medical.core.domain.Ztree;
import com.gx.wuzhou.medical.domain.Area;
import com.gx.wuzhou.medical.domain.Institution;
import com.gx.wuzhou.medical.domain.SysRole;
import com.gx.wuzhou.medical.domain.SysUser;
import com.gx.wuzhou.medical.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
 * @create 2020/6/8 0008
 * @since 1.0.0
 */
@Controller
@RequestMapping("page/area")
public class AreaController {
    @Autowired
    private IAreaService areaService;

    @GetMapping("ztree")
    @ResponseBody
    public List<Ztree> roleMenuTree(Institution init){
        List<Ztree> ztrees = areaService.roleMenuZtree(init);
        return ztrees;
    }

    @PostMapping("group")
    @ResponseBody
    public List<Area> familyGroup(String areaCode){
        String areaCodes = areaCode.split("-")[0];
        List<Area> list = areaService.selectGroupAll(areaCodes);
        return list;
    }

    @GetMapping("list")
    public String list(Area area, ModelMap mmap){
        List<Area> list = areaService.selectAreaList(area);
        mmap.put("list", list);
        return "area_list";
    }

    @GetMapping("input")
    public String input(ModelMap mmap){
        List<Area> list = areaService.selectAreaAll();
        mmap.put("area", list);
        return "area_add";
    }

    @PostMapping("add")
    public String add(Area area, String cid){
        String parent = cid.split("-")[0];
        String grades = cid.split("-")[1];
        area.setParent(parent);
        Integer grade = Integer.parseInt(grades);
        area.setGrade(grade+1);
        areaService.insertArea(area);
        return "redirect:/page/area/list";
    }

    @GetMapping("get")
    public String get(String areaCode, ModelMap mmap){
        Area area = areaService.selectArea(areaCode);
        mmap.put("area", area);
        return "area_edit";
    }

    @PostMapping("edit")
    public String edit(Area area){
        areaService.updateArea(area);
        return "redirect:/page/area/list";
    }

    @GetMapping("del")
    public String delete(String areaCode){
        areaService.deleteArea(areaCode);
        return "redirect:/page/area/list";
    }
}
