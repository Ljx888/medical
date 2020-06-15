/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: TPaymentController
 * Author:   Administrator
 * Date:     2020/6/14 0014 21:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.controller;

import com.gx.wuzhou.medical.core.util.DataUtil;
import com.gx.wuzhou.medical.domain.Area;
import com.gx.wuzhou.medical.domain.SysPerson;
import com.gx.wuzhou.medical.domain.TPayment;
import com.gx.wuzhou.medical.domain.TPayperiod;
import com.gx.wuzhou.medical.service.IAreaService;
import com.gx.wuzhou.medical.service.ISysPersonService;
import com.gx.wuzhou.medical.service.ITpaymentService;
import com.gx.wuzhou.medical.service.ITpayperiordService;
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
 * @create 2020/6/14 0014
 * @since 1.0.0
 */
@Controller
@RequestMapping("page/payment")
public class TPaymentController {
    @Autowired
    private IAreaService areaService;
    @Autowired
    private ISysPersonService personService;
    @Autowired
    private ITpayperiordService tpayperiordService;
    @Autowired
    private ITpaymentService iTpaymentService;

    @GetMapping("input")
    public String input(ModelMap mmap){
        List<Area> list = areaService.selectRuralAll();
        mmap.put("area", list);
        return "payment_list";
    }

    @GetMapping("list")
    public String list(ModelMap mmap, String villages, String groupNo, String persName){
        String areaCode = villages;

        if (groupNo != null && !groupNo.equals("")){
            areaCode = groupNo;
        }

        List<Area> area = areaService.selectRuralAll();
        mmap.put("area", area);

        List<SysPerson> list = personService.selectPersonAndPaymentList(areaCode, persName);
        mmap.put("list", list);

        return "payment_list";
    }

    @GetMapping("members")
    public String members(String famiCode, ModelMap mmap){
        int paYear = DataUtil.getYear(new java.util.Date());
        List<SysPerson> list = personService.findByPersonAndPayment(famiCode, paYear);
        TPayperiod payperiod = tpayperiordService.selectPayperiod(paYear);

        mmap.put("list", list);
        mmap.put("amount", payperiod.getAmount());

        return "payment_member";
    }

    @PostMapping("add")
    public String add(String[] persCode){
        String famiCode = "";
        for (String persCodes : persCode){
             String pers = persCodes.split("-")[0];
             famiCode = persCodes.split("-")[1];

             int paYear = DataUtil.getYear(new java.util.Date());
             TPayperiod payperiod = tpayperiordService.selectPayperiod(paYear);
             iTpaymentService.insert(pers, payperiod, famiCode);
        }
        return "redirect:/page/payment/members?famiCode="+famiCode;
    }
}
