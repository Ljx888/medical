/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: InstitutionController
 * Author:   Administrator
 * Date:     2020/6/9 0009 10:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.controller;

import com.gx.wuzhou.medical.core.domain.Ztree;
import com.gx.wuzhou.medical.domain.Area;
import com.gx.wuzhou.medical.domain.Institution;
import com.gx.wuzhou.medical.domain.SysUser;
import com.gx.wuzhou.medical.service.IAreaService;
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
 * @create 2020/6/9 0009
 * @since 1.0.0
 */
@Controller
@RequestMapping("page/init")
public class InstitutionController {
    @Autowired
    private InstitutionService initService;
    @Autowired
    private IAreaService areaService;

    @GetMapping("list")
    public String list(Institution institution, ModelMap mmap){
        List<Institution> list = initService.selectInitList(institution);
        mmap.put("list", list);
        return "init_list";
    }

    @GetMapping("input")
    public String input(ModelMap mmap){
        List<Area> list = areaService.selectAreaAll();
        mmap.put("list", list);
        return "init_add";
    }

    @PostMapping("add")
    public String add(Institution init, String cid){
        Integer grade = init.getAreaCode().length()==6?1:2;
        init.setGrade(grade);
        initService.saveInit(init);
        return "redirect:/page/init/list";
    }

    @GetMapping("get")
    public String get(String agenCode, ModelMap mmap){
        Institution init = initService.selectInit(agenCode);
        mmap.put("init", init);
        return "init_edit";
    }

    @PostMapping("edit")
    public String edit(Institution institution){
        System.out.println(institution.toString()+"6666");
        Integer grade = institution.getAreaCode().length()==6?1:2;
        institution.setGrade(grade);
        initService.updateInit(institution);
        return "redirect:/page/init/list";
    }

    @GetMapping("del")
    public String delete(String agenCode){
        initService.deleteInit(agenCode);
        return "redirect:/page/init/list";
    }
}
