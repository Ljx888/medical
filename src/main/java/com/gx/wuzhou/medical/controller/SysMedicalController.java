/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysMedicalController
 * Author:   Administrator
 * Date:     2020/6/12 0012 9:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.controller;

import com.gx.wuzhou.medical.domain.S201;
import com.gx.wuzhou.medical.domain.SysMedical;
import com.gx.wuzhou.medical.service.ISysMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/12 0012
 * @since 1.0.0
 */
@Controller
@RequestMapping("page/medical")
public class SysMedicalController {
    @Autowired
    private ISysMedicalService medicalService;

    @GetMapping("list")
    public String list(ModelMap mmap, SysMedical medical){
        List<SysMedical> list = medicalService.selectMedicalList(medical);
        mmap.put("list", list);
        return "medical_list";
    }

    @GetMapping("input")
    public String input(ModelMap mmap){
        List<S201> list = medicalService.selectS201List();
        List<S201> list02 = new ArrayList<S201>();
        List<S201> list06 = new ArrayList<S201>();
        List<S201> list04 = new ArrayList<S201>();
        List<S201> list01 = new ArrayList<S201>();
        List<S201> list03 = new ArrayList<S201>();
        List<S201> list301 = new ArrayList<S201>();
        for (S201 type: list){
            if (type.getType().equals("02")){
                list02.add(type);
                mmap.put("list02", list02);
            }else if (type.getType().equals("06")){
                list06.add(type);
                mmap.put("list06", list06);
            }else if (type.getType().equals("04")){
                list04.add(type);
                mmap.put("list04", list04);
            }else if (type.getType().equals("01")){
                list01.add(type);
                mmap.put("list01", list01);
            }else if (type.getType().equals("03")){
                list03.add(type);
                mmap.put("list03", list03);
            }else if (type.getType().equals("0301")){
                list301.add(type);
                mmap.put("list301", list301);
            }
        }

            return "medical_add";
    }

    @GetMapping("get")
    public String get(String jgbm, ModelMap mmap){
        List<S201> list = medicalService.selectS201List();
        List<S201> list02 = new ArrayList<S201>();
        List<S201> list06 = new ArrayList<S201>();
        List<S201> list04 = new ArrayList<S201>();
        List<S201> list01 = new ArrayList<S201>();
        List<S201> list03 = new ArrayList<S201>();
        List<S201> list301 = new ArrayList<S201>();
        for (S201 type: list){
            if (type.getType().equals("02")){
                list02.add(type);
                mmap.put("list02", list02);
            }else if (type.getType().equals("06")){
                list06.add(type);
                mmap.put("list06", list06);
            }else if (type.getType().equals("04")){
                list04.add(type);
                mmap.put("list04", list04);
            }else if (type.getType().equals("01")){
                list01.add(type);
                mmap.put("list01", list01);
            }else if (type.getType().equals("03")){
                list03.add(type);
                mmap.put("list03", list03);
            }else if (type.getType().equals("0301")){
                list301.add(type);
                mmap.put("list301", list301);
            }
        }
        SysMedical sysMedical = medicalService.selectMedical(jgbm);
        mmap.put("medical", sysMedical);
        return "medical_edit";
    }

    @PostMapping("add")
    public String add(SysMedical sysMedical){
        medicalService.saveSysMedical(sysMedical);
        return "redirect:/page/medical/list";
    }

    @PostMapping("edit")
    public String edit(SysMedical medical){
        medicalService.updateSysMedical(medical);
        return "redirect:/page/medical/list";
    }

    @GetMapping("del")
    public String delete(String jgbm){
        medicalService.deleteSysMedical(jgbm);
        return "redirect:/page/medical/list";
    }
}
