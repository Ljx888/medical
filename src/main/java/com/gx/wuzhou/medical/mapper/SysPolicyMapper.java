/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: SysPolicyMapper
 * Author:   Administrator
 * Date:     2020/6/12 0012 17:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.mapper;

import com.gx.wuzhou.medical.domain.Institution;
import com.gx.wuzhou.medical.domain.SysPolicy;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/12 0012
 * @since 1.0.0
 */
public interface SysPolicyMapper {
    public List<SysPolicy> selectSysPolicyList(SysPolicy policy);

    public SysPolicy selectSysPolicy(String runyear);

    public int saveSysPolicy(SysPolicy policy);

    public int updateSysPolicy(SysPolicy policy);

    public int deleteSysPolicy(String runyear);
}
