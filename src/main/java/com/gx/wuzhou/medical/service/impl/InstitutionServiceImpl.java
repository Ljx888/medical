/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: InstitutionServiceImpl
 * Author:   Administrator
 * Date:     2020/6/9 0009 10:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service.impl;

import com.gx.wuzhou.medical.domain.Institution;
import com.gx.wuzhou.medical.mapper.InstitutionMapper;
import com.gx.wuzhou.medical.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/9 0009
 * @since 1.0.0
 */
@Service
public class InstitutionServiceImpl implements InstitutionService {
    @Autowired
    private InstitutionMapper institutionMapper;

    @Override
    public List<Institution> selectInitList(Institution institution) {
        return institutionMapper.selectInitList(institution);
    }

    @Override
    public Institution selectInit(String agenCode) {
        return institutionMapper.selectInit(agenCode);
    }

    @Override
    public int saveInit(Institution institution) {
        return institutionMapper.saveInit(institution);
    }

    @Override
    public int updateInit(Institution institution) {
        return institutionMapper.updateInit(institution);
    }

    @Override
    public int deleteInit(String agenCode) {
        return institutionMapper.deleteInit(agenCode);
    }
}
