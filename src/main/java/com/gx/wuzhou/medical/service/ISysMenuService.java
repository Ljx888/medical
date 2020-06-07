/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: ISysMenuService
 * Author:   Administrator
 * Date:     2020/6/6 0006 15:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service;

import com.gx.wuzhou.medical.core.domain.Ztree;
import com.gx.wuzhou.medical.domain.SysMenu;
import com.gx.wuzhou.medical.domain.SysRole;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/6 0006
 * @since 1.0.0
 */
public interface ISysMenuService {
    /**
     * 查询所有权限树
     * @return
     */
    public List<SysMenu> selectMenuAll();

    /**
     *根据角色编号查询
     *
     * @param role
     * @return
     */
    public List<Ztree> roleMenuZtree(SysRole role);
}
