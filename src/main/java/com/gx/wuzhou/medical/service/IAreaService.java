/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: IAreaService
 * Author:   Administrator
 * Date:     2020/6/8 0008 22:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service;

import com.gx.wuzhou.medical.core.domain.Ztree;
import com.gx.wuzhou.medical.domain.Area;
import com.gx.wuzhou.medical.domain.Institution;
import com.gx.wuzhou.medical.domain.SysUser;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/8 0008
 * @since 1.0.0
 */
public interface IAreaService {
    /**
     * 查询地域信息
     *
     * @return
     */
    public List<Area> selectAreaAll();

    /**
     * 查询角色权限
     *
     * @param agenCode
     * @return
     */
    public List<String> selectInitTree(String agenCode);

    /**
     * 查询所有农村
     *
     * @return
     */
    public List<Area> selectRuralAll();

    /**
     * 查询组
     *
     * @param areaCode
     * @return
     */
    public List<Area> selectGroupAll(String areaCode);

    /**
     *根据用户编号查询
     *
     * @param init
     * @return
     */
    public List<Ztree> roleMenuZtree(Institution init);

    /**
     * 查询所有
     *
     * @param area
     * @return
     */
    public List<Area> selectAreaList(Area area);

    /**
     * 查询
     *
     * @param areaCode
     * @return
     */
    public Area selectArea(String areaCode);

    /**
     * 添加
     *
     * @param area
     * @return
     */
    public int insertArea(Area area);

    /**
     * 修改
     *
     * @param area
     * @return
     */
    public int updateArea(Area area);

    /**
     * 删除
     * @param areaCode
     * @return
     */
    public int deleteArea(String areaCode);
}
