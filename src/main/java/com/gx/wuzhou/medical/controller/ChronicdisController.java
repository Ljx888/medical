/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: ChronicdisController
 * Author:   Administrator
 * Date:     2020/6/11 0011 20:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.controller;

import com.gx.wuzhou.medical.domain.Chronicdis;
import com.gx.wuzhou.medical.service.IChronicdiService;
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
 * @create 2020/6/11 0011
 * @since 1.0.0
 */
@Controller
@RequestMapping("page/chronicdis")
public class ChronicdisController {
    @Autowired
    private IChronicdiService chronicdiService;

    @GetMapping("list")
    public String list(Chronicdis chronicdis, ModelMap mmap){
        List<Chronicdis> list = chronicdiService.selectChronicdisList(chronicdis);
        mmap.put("list", list);
        return "chro_list";
    }

    @GetMapping("get")
    public String get(String illCode, ModelMap mmap){
        Chronicdis chro = chronicdiService.selectChronicdis(illCode);
        mmap.put("chro", chro);
        return "chro_edit";
    }

    @PostMapping("add")
    public String add(Chronicdis chronicdis){
        chronicdiService.saveChronicdis(chronicdis);
        return "redirect:/page/chronicdis/list";
    }

    @PostMapping("edit")
    public String edit(Chronicdis chronicdis){
        chronicdiService.updateChronicdis(chronicdis);
        return "redirect:/page/chronicdis/list";
    }

    @GetMapping("del")
    public String delete(String illCode){
        chronicdiService.deleteChronicdis(illCode);
        return "redirect:/page/chronicdis/list";
    }
}
