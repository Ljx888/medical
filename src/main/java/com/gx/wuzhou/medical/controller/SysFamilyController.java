/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysFamilyController
 * Author:   Administrator
 * Date:     2020/6/13 0013 10:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.controller;

import com.gx.wuzhou.medical.core.util.DataUtil;
import com.gx.wuzhou.medical.domain.Area;
import com.gx.wuzhou.medical.domain.SysFamily;
import com.gx.wuzhou.medical.domain.SysPerson;
import com.gx.wuzhou.medical.service.IAreaService;
import com.gx.wuzhou.medical.service.ISysFamilyService;
import com.gx.wuzhou.medical.service.ISysPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/13 0013
 * @since 1.0.0
 */
@Controller
@RequestMapping("page/family")
public class SysFamilyController {
    @Autowired
    private ISysFamilyService familyService;
    @Autowired
    private IAreaService areaService;
    @Autowired
    private ISysPersonService personService;

    @GetMapping("list")
    public String list(ModelMap mmap, SysFamily family){
        List<SysFamily> list = familyService.selectFamilyList(family);
        mmap.put("list", list);
        return "family_list";
    }

    @GetMapping("input")
    public String input(ModelMap mmap){
        List<Area> list = areaService.selectRuralAll();
        mmap.put("list", list);
        return "family_add";
    }

    @GetMapping("find")
    public String findFamilyId(ModelMap mmap, String famiCode, String popuNum){
        mmap.put("famiCode", famiCode);
        mmap.put("popuNum", popuNum);
        return "family_addMember";
    }

    @GetMapping("get")
    public String get(ModelMap mmap, String persCode){
        SysPerson person = familyService.selectPerson(persCode);
        mmap.put("person", person);
        return "family_edit";
    }

    @PostMapping("add")
    public String add(SysFamily family, String villages, String isRurals, SysPerson person, HttpServletRequest request){
        family.setVillage(villages.split("-")[0]);
        family.setTown(villages.split("-")[1]);
        family.setPersCode(person.getPersCode());
        family.setPopuNum(1);
        family.setAgriNum(1);

        HttpSession session = request.getSession();
        String creatOr = (String) session.getAttribute("user.fullName");
        family.setCreatOr(creatOr);

        person.setRelation("1");
        person.setRural("1".equals(isRurals)?true:false);
        person.setAge(DataUtil.diffYear(person.getBirthday()));

        familyService.insert(family, person);
        return "redirect:/page/family/list";
    }

    @PostMapping("addMember")
    public String addMember(SysPerson person, String isRurals, int popuNum){
        person.setRural("1".equals(isRurals)?true:false);
        person.setAge(DataUtil.diffYear(person.getBirthday()));
        int agriNum = person.isRural()?1:0;

        familyService.insertMemder(person, popuNum, agriNum);
        return "redirect:/page/family/list";
    }

    @PostMapping("edit")
    public String edit(SysPerson person, String isRurals){
        person.setRural("1".equals(isRurals)?true:false);
        person.setAge(DataUtil.diffYear(person.getBirthday()));

        familyService.updatePerson(person);
        return "redirect:/page/family/list";
    }

    @GetMapping("del")
    public String delete(String famiCode){
        familyService.delete(famiCode);
        return "redirect:/page/family/list";
    }

    @GetMapping("person")
    public String findByPerson(SysPerson sysPerson, ModelMap mmap){
        List<SysPerson> list = personService.selectPersonList(sysPerson);
        mmap.put("list", list);
        return "person/person_list";
    }

    @GetMapping("delPerson")
    public String deletePerson(String persCode, String famiCode){
        personService.deletePerson(persCode, famiCode);
        return "redirect:/page/family/list";
    }
}
