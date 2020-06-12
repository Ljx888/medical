/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysPolicyController
 * Author:   Administrator
 * Date:     2020/6/12 0012 19:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.controller;

import com.gx.wuzhou.medical.domain.SysPolicy;
import com.gx.wuzhou.medical.service.ISysPolicyService;
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
 * @create 2020/6/12 0012
 * @since 1.0.0
 */
@Controller
@RequestMapping("page/policy")
public class SysPolicyController {
    @Autowired
    private ISysPolicyService policyService;

    @GetMapping("list")
    public String list(ModelMap mmap, SysPolicy policy){
        List<SysPolicy> list = policyService.selectSysPolicyList(policy);
        mmap.put("list", list);
        return "policy_list";
    }

    @GetMapping("get")
    public String get(ModelMap mmap, String runyear){
        SysPolicy policy = policyService.selectSysPolicy(runyear);
        mmap.put("policy", policy);
        return "policy_edit";
    }

    @PostMapping("add")
    public String add(SysPolicy policy){
        policyService.saveSysPolicy(policy);
        return "redirect:/page/policy/list";
    }

    @PostMapping("edit")
    public String edit(SysPolicy policy){
        policyService.updateSysPolicy(policy);
        return "redirect:/page/policy/list";
    }

    @GetMapping("del")
    public String delete(String runyear){
        policyService.deleteSysPolicy(runyear);
        return "redirect:/page/policy/list";
    }
}
