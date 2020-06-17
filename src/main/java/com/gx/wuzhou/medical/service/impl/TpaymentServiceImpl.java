/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: TpaymentServiceImpl
 * Author:   Administrator
 * Date:     2020/6/15 0015 20:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service.impl;

import com.gx.wuzhou.medical.core.util.UUIDUtil;
import com.gx.wuzhou.medical.domain.TPayment;
import com.gx.wuzhou.medical.domain.TPayperiod;
import com.gx.wuzhou.medical.mapper.TPaymentMapper;
import com.gx.wuzhou.medical.service.ITpaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/15 0015
 * @since 1.0.0
 */
@Service
public class TpaymentServiceImpl implements ITpaymentService {
    @Autowired
    private TPaymentMapper paymentMapper;
    @Override
    public int insert(String persCodes, TPayperiod payperiod, String famiCode) {
        TPayment payment = new TPayment();
        payment.setPayNo(UUIDUtil.uuid());
        payment.setPersCode(persCodes);
        payment.setRunyear(payperiod.getRunyear());
        payment.setPaytime(new java.util.Date());
        payment.setPayCost(payperiod.getAmount());
        payment.setFamiCode(famiCode);

        paymentMapper.insertPayment(payment);
        return 0;
    }

    @Override
    public TPayment selectPaymentPersCode(String cardUd, int runtime) {
        return paymentMapper.selectPaymentPersCode(cardUd, runtime);
    }
}
