/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: ITpaymentService
 * Author:   Administrator
 * Date:     2020/6/15 0015 20:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service;

import com.gx.wuzhou.medical.domain.TPayment;
import com.gx.wuzhou.medical.domain.TPayperiod;
import org.apache.ibatis.annotations.Param;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/15 0015
 * @since 1.0.0
 */
public interface ITpaymentService {
    /**
     * 添加
     *
     * @param persCodes
     * @return
     */
    public int insert(String persCodes, TPayperiod payperiod, String famiCode);

    /**
     * 查询出对应的参合农民信息
     *
     * @param cardUd
     * @param runtime
     * @return
     */
    public TPayment selectPaymentPersCode(String cardUd, int runtime);
}
