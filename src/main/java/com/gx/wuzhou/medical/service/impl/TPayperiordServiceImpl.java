/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: TPayperiordServiceImpl
 * Author:   Administrator
 * Date:     2020/6/15 0015 9:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service.impl;

import com.gx.wuzhou.medical.domain.TPayperiod;
import com.gx.wuzhou.medical.mapper.TPayperiodMapper;
import com.gx.wuzhou.medical.service.ITpayperiordService;
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
public class TPayperiordServiceImpl implements ITpayperiordService {
    @Autowired
    private TPayperiodMapper payperiodMapper;
    @Override
    public TPayperiod selectPayperiod(int runyear) {
        return payperiodMapper.selectPayperiod(runyear);
    }
}
