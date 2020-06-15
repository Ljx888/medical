/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: TPayperiodMapper
 * Author:   Administrator
 * Date:     2020/6/14 0014 21:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.mapper;

import com.gx.wuzhou.medical.domain.TPayperiod;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/14 0014
 * @since 1.0.0
 */
public interface TPayperiodMapper {
    /**
     * 查询对应年份
     *
     * @param runyear
     * @return
     */
    public TPayperiod selectPayperiod(int runyear);
}
