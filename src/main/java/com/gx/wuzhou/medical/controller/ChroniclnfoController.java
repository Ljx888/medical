/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: ChroniclnfoController
 * Author:   Administrator
 * Date:     2020/6/16 0016 11:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.controller;

import com.gx.wuzhou.medical.core.util.UUIDUtil;
import com.gx.wuzhou.medical.domain.ChronicInfo;
import com.gx.wuzhou.medical.domain.Chronicdis;
import com.gx.wuzhou.medical.service.IChronicInfoService;
import com.gx.wuzhou.medical.service.IChronicdiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/16 0016
 * @since 1.0.0
 */
@Controller
@RequestMapping("page/chronicinfo")
public class ChroniclnfoController {
    @Autowired
    private IChronicInfoService chronicInfoService;
    @Autowired
    private IChronicdiService chronicdiService;

    @GetMapping("list")
    public String list(ChronicInfo chronicInfo, ModelMap mmap){
        List<ChronicInfo> list = chronicInfoService.selectChroniclnfoList(chronicInfo);
        mmap.put("list", list);
        return "lnfo_list";
    }

    @GetMapping("input")
    public String input(ModelMap mmap){
        List<Chronicdis> chro = chronicdiService.selectChronicdisList(null);
        mmap.put("chro", chro);
        return "lnfo_add";
    }

    @GetMapping("get")
    public String get(String id, ModelMap mmap){
        ChronicInfo chronicInfo = chronicInfoService.selectChroniclnfo(id);
        mmap.put("info", chronicInfo);

        List<Chronicdis> chro = chronicdiService.selectChronicdisList(null);
        mmap.put("chro", chro);

        return "lnfo_edit";
    }

    @PostMapping("add")
    public String add(ChronicInfo chronicInfo){
        chronicInfo.setId(UUIDUtil.uuid());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = new Date();
        String data = formatter.format(currentTime);
        chronicInfo.setCreatTime(data);
        chronicInfoService.insertChroniclnfo(chronicInfo);
        return "redirect:/page/chronicinfo/list";
    }

    @PostMapping("edit")
    public String edit(ChronicInfo chronicInfo){
        chronicInfoService.updateChroniclnfo(chronicInfo);
        return "redirect:/page/chronicinfo/list";
    }

    @GetMapping("del")
    public String delete(String id){
        chronicInfoService.deleteChroniclnfo(id);
        return "redirect:/page/chronicinfo/list";
    }
}
