/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: InstitutionService
 * Author:   Administrator
 * Date:     2020/6/9 0009 10:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service;

import com.gx.wuzhou.medical.domain.Institution;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/9 0009
 * @since 1.0.0
 */
public interface InstitutionService {
    public List<Institution> selectInitList(Institution institution);

    public Institution selectInit(String agenCode);

    public int saveInit(Institution institution);

    public int updateInit(Institution institution);

    public int deleteInit(String agenCode);
}
