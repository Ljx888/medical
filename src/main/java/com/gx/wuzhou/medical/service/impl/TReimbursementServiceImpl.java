/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: TReimbursementServiceImpl
 * Author:   Administrator
 * Date:     2020/6/17 0017 12:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service.impl;

import com.gx.wuzhou.medical.core.util.DataUtil;
import com.gx.wuzhou.medical.domain.TPayperiod;
import com.gx.wuzhou.medical.domain.TReimbursement;
import com.gx.wuzhou.medical.mapper.TPayperiodMapper;
import com.gx.wuzhou.medical.mapper.TReimbursementMapper;
import com.gx.wuzhou.medical.service.ITReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/17 0017
 * @since 1.0.0
 */
@Service
public class TReimbursementServiceImpl implements ITReimbursementService {
    @Autowired
    private TReimbursementMapper reimbursementMapper;
    @Autowired
    private TPayperiodMapper payperiodMapper;

    @Override
    public List<TReimbursement> selectTReimbursementList(TReimbursement reimbursement) {
        return reimbursementMapper.selectTReimbursementList(reimbursement);
    }

    @Override
    public int insertTreimbursement(TReimbursement reimbursement) {
        TPayperiod payperiod = payperiodMapper.selectPayperiod(DataUtil.getYear(new java.util.Date()));

        double aount = payperiod.getAmount(); //封顶线
        double scale = payperiod.getScale();  //报销比例
        double forecast = reimbursement.getMedicalSum()*scale;  //预测报销
        double moneyCount = reimbursementMapper.selectMoneyCount(reimbursement.getCardId()); //慢性病报销总金额
        double money = ((aount-moneyCount)>=forecast)?forecast:(aount-moneyCount); //报销金额

        reimbursement.setProprotion(scale);
        reimbursement.setMoney(money);
        reimbursement.setStatus(3);
        reimbursement.setIsRemittance(3);

        return reimbursementMapper.insertTReimbursement(reimbursement);
    }

    @Override
    public int updateTReimbursement(TReimbursement reimbursement) {
        return reimbursementMapper.updateTReimbursement(reimbursement);
    }
}
