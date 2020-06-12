/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysMedicalServiceImpl
 * Author:   Administrator
 * Date:     2020/6/12 0012 9:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service.impl;

import com.gx.wuzhou.medical.domain.S201;
import com.gx.wuzhou.medical.domain.SysMedical;
import com.gx.wuzhou.medical.mapper.S201Mapper;
import com.gx.wuzhou.medical.mapper.SysMedicalMapper;
import com.gx.wuzhou.medical.service.ISysMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/12 0012
 * @since 1.0.0
 */
@Service
public class SysMedicalServiceImpl implements ISysMedicalService {
    @Autowired
    private SysMedicalMapper medicalMapper;
    @Autowired
    private S201Mapper s201Mapper;

    @Override
    public List<SysMedical> selectMedicalList(SysMedical medical) {
        return medicalMapper.selectMedicalList(medical);
    }

    @Override
    public List<S201> selectS201List() {
        return s201Mapper.selectS201List();
    }

    @Override
    public SysMedical selectMedical(String jgbm) {
        return medicalMapper.selectMedical(jgbm);
    }

    @Override
    public int saveSysMedical(SysMedical medical) {
        return medicalMapper.saveSysMedical(medical);
    }

    @Override
    public int updateSysMedical(SysMedical medical) {
        return medicalMapper.updateSysMedical(medical);
    }

    @Override
    public int deleteSysMedical(String jgbm) {
        return medicalMapper.deleteSysMedical(jgbm);
    }
}
