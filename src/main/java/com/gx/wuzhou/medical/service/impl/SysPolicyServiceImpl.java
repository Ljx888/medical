/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysPolicyServiceImpl
 * Author:   Administrator
 * Date:     2020/6/12 0012 19:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service.impl;

import com.gx.wuzhou.medical.domain.SysPolicy;
import com.gx.wuzhou.medical.mapper.SysPolicyMapper;
import com.gx.wuzhou.medical.service.ISysPolicyService;
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
public class SysPolicyServiceImpl implements ISysPolicyService {
    @Autowired
    private SysPolicyMapper policyMapper;


    @Override
    public List<SysPolicy> selectSysPolicyList(SysPolicy policy) {
        return policyMapper.selectSysPolicyList(policy);
    }

    @Override
    public SysPolicy selectSysPolicy(String runyear) {
        return policyMapper.selectSysPolicy(runyear);
    }

    @Override
    public int saveSysPolicy(SysPolicy policy) {
        return policyMapper.saveSysPolicy(policy);
    }

    @Override
    public int updateSysPolicy(SysPolicy policy) {
        return policyMapper.updateSysPolicy(policy);
    }

    @Override
    public int deleteSysPolicy(String runyear) {
        return policyMapper.deleteSysPolicy(runyear);
    }
}
