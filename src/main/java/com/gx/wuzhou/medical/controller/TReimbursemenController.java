/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: TReimbursemenController
 * Author:   Administrator
 * Date:     2020/6/17 0017 10:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.controller;

import com.gx.wuzhou.medical.core.util.DataUtil;
import com.gx.wuzhou.medical.core.util.UUIDUtil;
import com.gx.wuzhou.medical.domain.SysPerson;
import com.gx.wuzhou.medical.domain.TPayment;
import com.gx.wuzhou.medical.domain.TReimbursement;
import com.gx.wuzhou.medical.service.ISysFamilyService;
import com.gx.wuzhou.medical.service.ISysPersonService;
import com.gx.wuzhou.medical.service.ITReimbursementService;
import com.gx.wuzhou.medical.service.ITpaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/17 0017
 * @since 1.0.0
 */
@Controller
@RequestMapping("page/reimbursement")
public class TReimbursemenController {
    @Autowired
    private ITpaymentService tpaymentService;
    @Autowired
    private ISysFamilyService familyService;
    @Autowired
    private ITReimbursementService reimbursementService;

    @GetMapping("list")
    public String list(){
        return "reimbursement_list";
    }

    @GetMapping("listAll")
    public String listAll(ModelMap mmap, TReimbursement reimbursement){
        List<TReimbursement> list = reimbursementService.selectTReimbursementList(reimbursement);
        mmap.put("list", list);
        return "reimbursement_listAll";
    }

    @GetMapping("input")
    @ResponseBody
    public TPayment input(String cardId){
        int payTime = DataUtil.getYear(new java.util.Date());
        TPayment payment = tpaymentService.selectPaymentPersCode(cardId, payTime);
        return payment;
    }

    @GetMapping("info")
    public String addInfo(String persCode, ModelMap mmap){
        SysPerson person = familyService.selectPerson(persCode);
        mmap.put("person", person);
        return "reimbursement_add";
    }

    @PostMapping("add")
    public String add(TReimbursement reimbursement, HttpServletRequest request){
        reimbursement.setReimbursementNumber(UUIDUtil.uuid());
        reimbursement.setCreatTime(DataUtil.format());

        HttpSession session = request.getSession();
        String creatOr = (String) session.getAttribute("user.fullName");
        reimbursement.setCreatOr(creatOr);

        reimbursementService.insertTreimbursement(reimbursement);
        return "redirect:/page/reimbursement/listAll";
    }

    @GetMapping("listStatus")
    public String listStatus(ModelMap mmap, TReimbursement reimbursement){
        if (reimbursement.getPersName() == null || reimbursement.getCreatTime() == null){
            return "reimbursement_status";
        }else{
        reimbursement.setStatus(3);
        List<TReimbursement> list = reimbursementService.selectTReimbursementList(reimbursement);
            System.out.println(list.toString());
        mmap.put("list", list);
        return "reimbursement_status";
        }
    }

    @GetMapping("listRemittance")
    public String listRemittance(ModelMap mmap, TReimbursement reimbursement){
        if (reimbursement.getPersName() == null || reimbursement.getCreatTime() == null){
            return "reimbursement_remittance";
        }else {
            reimbursement.setStatus(1);
            List<TReimbursement> list = reimbursementService.selectTReimbursementList(reimbursement);
            mmap.put("list", list);
            return "reimbursement_remittance";
        }
    }

    @GetMapping("editStatus")
    public String editStatus(TReimbursement reimbursement){
        reimbursementService.updateTReimbursement(reimbursement);
        return "redirect:/page/reimbursement/listStatus";
    }

    @GetMapping("editRemittance")
    public String editRemittance(TReimbursement reimbursement){
        reimbursementService.updateTReimbursement(reimbursement);
        return "redirect:/page/reimbursement/listRemittance";
    }
}
