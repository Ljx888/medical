/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysPersonServiceImpl
 * Author:   Administrator
 * Date:     2020/6/14 0014 11:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service.impl;

import com.gx.wuzhou.medical.domain.SysFamily;
import com.gx.wuzhou.medical.domain.SysPerson;
import com.gx.wuzhou.medical.mapper.SysFamilyMapper;
import com.gx.wuzhou.medical.mapper.SysPersonMapper;
import com.gx.wuzhou.medical.service.ISysPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/14 0014
 * @since 1.0.0
 */
@Service
public class SysPersonServiceImpl implements ISysPersonService {
    @Autowired
    private SysPersonMapper personMapper;
    @Autowired
    private SysFamilyMapper familyMapper;
    @Override
    public List<SysPerson> selectPersonList(SysPerson sysPerson) {
        return personMapper.selectPersonList(sysPerson);
    }

    @Override
    public List<SysPerson> selectPersonAndPaymentList(String areaCode, String persName) {
        return personMapper.selectPersonAndPaymentList(areaCode, persName);
    }

    @Override
    public List<SysPerson> findByPersonAndPayment(String famiCode, int runyear) {
        return personMapper.findByPersonAndPayment(famiCode, runyear);
    }

    @Override
    public int deletePerson(String persCode, String famiCode) {
        SysFamily family = familyMapper.selectFamily(famiCode);
        SysPerson person = personMapper.selectPerson(persCode);

        String poprCode = family.getFamiCode();
        if (person.isRural()){
            family.setAgriNum(-1);
        }
        family.setPopuNum(family.getPopuNum()-1);

        familyMapper.updateFamily(family);
        return personMapper.deletePersonId(persCode);
    }
}
