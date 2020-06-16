/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: ChroniclnfoServiceImpl
 * Author:   Administrator
 * Date:     2020/6/16 0016 11:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service.impl;

import com.gx.wuzhou.medical.domain.ChronicInfo;
import com.gx.wuzhou.medical.mapper.ChroniclnfoMapper;
import com.gx.wuzhou.medical.service.IChronicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/16 0016
 * @since 1.0.0
 */
@Service
public class ChroniclnfoServiceImpl implements IChronicInfoService {
    @Autowired
    private ChroniclnfoMapper chroniclnfoMapper;
    @Override
    public List<ChronicInfo> selectChroniclnfoList(ChronicInfo chronicInfo) {
        return chroniclnfoMapper.selectChroniclnfoList(chronicInfo);
    }

    @Override
    public ChronicInfo selectChroniclnfo(String id) {
        return chroniclnfoMapper.selectChroniclnfo(id);
    }

    @Override
    public int insertChroniclnfo(ChronicInfo chronicInfo) {
        return chroniclnfoMapper.insertChroniclnfo(chronicInfo);
    }

    @Override
    public int updateChroniclnfo(ChronicInfo chronicInfo) {
        return chroniclnfoMapper.updateChroniclnfo(chronicInfo);
    }

    @Override
    public int deleteChroniclnfo(String id) {
        return chroniclnfoMapper.deleteChroniclnfo(id);
    }
}
