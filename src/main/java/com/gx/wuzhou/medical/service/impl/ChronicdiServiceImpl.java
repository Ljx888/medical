/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: ChronicdiServiceImpl
 * Author:   Administrator
 * Date:     2020/6/11 0011 20:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service.impl;

import com.gx.wuzhou.medical.domain.Chronicdis;
import com.gx.wuzhou.medical.mapper.ChronicdisMapper;
import com.gx.wuzhou.medical.service.IChronicdiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/11 0011
 * @since 1.0.0
 */
@Service
public class ChronicdiServiceImpl implements IChronicdiService {
    @Autowired
    private ChronicdisMapper chronicdisMapper;

    @Override
    public List<Chronicdis> selectChronicdisList(Chronicdis chronicdis) {
        return chronicdisMapper.selectChronicdisList(chronicdis);
    }

    @Override
    public Chronicdis selectChronicdis(String illCode) {
        return chronicdisMapper.selectChronicdis(illCode);
    }

    @Override
    public int saveChronicdis(Chronicdis chronicdis) {
        return chronicdisMapper.saveChronicdis(chronicdis);
    }

    @Override
    public int updateChronicdis(Chronicdis chronicdis) {
        return chronicdisMapper.updateChronicdis(chronicdis);
    }

    @Override
    public int deleteChronicdis(String illCode) {
        return chronicdisMapper.deleteChronicdis(illCode);
    }
}
