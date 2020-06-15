/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysFamilyServiceImpl
 * Author:   Administrator
 * Date:     2020/6/13 0013 10:17
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
import com.gx.wuzhou.medical.service.ISysFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/13 0013
 * @since 1.0.0
 */
@Service
public class SysFamilyServiceImpl implements ISysFamilyService {
    @Autowired
    private SysFamilyMapper familyMapper;
    @Autowired
    private SysPersonMapper personMapper;

    @Override
    public List<SysFamily> selectFamilyList(SysFamily family) {
        return familyMapper.selectFamilyList(family);
    }

    public String createFamicode(String groupNo){
        String maxcode= familyMapper.createFamicode(groupNo);
        Integer number=1;
        if(maxcode!=null){
            int beginIndex=maxcode.length()-4;
            String no=maxcode.substring(beginIndex);
            number=Integer.parseInt(no);
            ++number;
            //使用0补足位数
            no=String.format("%04d", number);
            maxcode=groupNo+no;
        }else{
            String no=String.format("%04d", number);
            maxcode=groupNo+no;
        }
        return maxcode;
    }

    public String createPerscode(String famiCode){
        String maxcode = personMapper.createPerscode(famiCode);

        Integer number = 1;
        if(maxcode!=null){
            int beginIndex=maxcode.length()-2;
            String no=maxcode.substring(beginIndex);
            number=Integer.parseInt(no);
            ++number;
            //使用0补足位数
            no=String.format("%02d", number);
            maxcode=famiCode+no;
        }else{
            System.out.println("hehehe");
            String no=String.format("%02d", number);
            maxcode=famiCode+no;
        }
        return maxcode;
    }

    @Transactional
    @Override
    public int insert(SysFamily family, SysPerson person) {
        family.setFamiCode(createFamicode(family.getGroupNo()));
        person.setFamiCode(family.getFamiCode());
        person.setPersCode(createPerscode(family.getFamiCode()));
        family.setPersCode(person.getPersCode());
        insertFamily(family);
        insertPerson(person);
        return 0;
    }

    @Transactional
    @Override
    public int insertMemder(SysPerson person, int popuNum, int agriNum) {
        person.setPersCode(createPerscode(person.getFamiCode()));
        insertPerson(person);
        updateFamily(popuNum, agriNum, person.getFamiCode());
        return 0;
    }

    public int updateFamily(int popuNum, int agriNum, String famiCode){
        SysFamily family = new SysFamily();
        family.setFamiCode(famiCode);
        family.setPopuNum(popuNum+1);
        if (agriNum == 1){
            family.setAgriNum(agriNum);
        }
        return familyMapper.updateFamily(family);
    }

    @Override
    public SysPerson selectPerson(String persCode) {
        return personMapper.selectPerson(persCode);
    }

    @Override
    public int updatePerson(SysPerson person){
        return personMapper.updatePerson(person);
    }

    @Override
    public int delete(String famiCode) {
        deleteFamily(famiCode);
        return deletePerson(famiCode);
    }

    public void deleteFamily(String famiCode){
        familyMapper.deleteFamily(famiCode);
    }

    /**
     * 删除
     *
     * @param famiCode
     * @return
     */
    public int deletePerson(String famiCode){
        return personMapper.deletePerson(famiCode);
    }

    public void insertFamily(SysFamily family){
         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         String time= df.format(new Date());
            family.setCreatTime(time);
            familyMapper.insertFamily(family);
    }

    public void insertPerson(SysPerson person){
        personMapper.insertPerson(person);
    }
}
