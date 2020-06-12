/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: S201Mapper
 * Author:   Administrator
 * Date:     2020/6/12 0012 11:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.mapper;

import com.gx.wuzhou.medical.domain.S201;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/12 0012
 * @since 1.0.0
 */
public interface S201Mapper {
    /**
     * 显示201
     *
     * @return
     */
    public List<S201> selectS201List();
}
