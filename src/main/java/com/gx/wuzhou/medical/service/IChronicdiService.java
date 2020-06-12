/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: IChronicdiService
 * Author:   Administrator
 * Date:     2020/6/11 0011 20:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service;

import com.gx.wuzhou.medical.domain.Chronicdis;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/11 0011
 * @since 1.0.0
 */
public interface IChronicdiService {
    public List<Chronicdis> selectChronicdisList(Chronicdis chronicdis);

    public Chronicdis selectChronicdis(String illCode);

    public int saveChronicdis(Chronicdis chronicdis);

    public int updateChronicdis(Chronicdis chronicdis);

    public int deleteChronicdis(String illCode);
}
