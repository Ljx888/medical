/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: AreaServiceImpl
 * Author:   Administrator
 * Date:     2020/6/8 0008 22:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service.impl;

import com.gx.wuzhou.medical.core.domain.Ztree;
import com.gx.wuzhou.medical.domain.Area;
import com.gx.wuzhou.medical.domain.Institution;
import com.gx.wuzhou.medical.domain.SysMenu;
import com.gx.wuzhou.medical.domain.SysUser;
import com.gx.wuzhou.medical.mapper.AreaMapper;
import com.gx.wuzhou.medical.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/8 0008
 * @since 1.0.0
 */
@Service
public class AreaServiceImpl implements IAreaService {
    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<Area> selectAreaAll() {
        return areaMapper.selectAreaAll();
    }

    @Override
    public List<String> selectInitTree(String agenCode) {
        return areaMapper.selectInitTree(agenCode);
    }

    @Override
    public List<Ztree> roleMenuZtree(Institution init) {
        String agenCode = init.getAgenCode();
        List<Ztree> ztrees = new ArrayList<Ztree>();
        List<Area> areaList = selectAreaAll();
        if (agenCode != null){
            List<String> list = selectInitTree(agenCode);
            ztrees = initZtree(areaList, list, true);
        }
        ztrees = initZtree(areaList, null, true);
        return ztrees;
    }

    @Override
    public List<Area> selectAreaList(Area area) {
        return areaMapper.selectAreaList(area);
    }

    @Override
    public Area selectArea(String areaCode) {
        return areaMapper.selectArea(areaCode);
    }

    @Override
    public int insertArea(Area area) {
        return areaMapper.insertArea(area);
    }

    @Override
    public int updateArea(Area area) {
        return areaMapper.updateArea(area);
    }

    @Override
    public int deleteArea(String areaCode) {
        return areaMapper.deleteArea(areaCode);
    }

    /**
     *
     * @param areaList
     * @param sysUserList
     * @param permsFlag 是否需要显示权限标识
     * @return 树构建列表
     */
    public List<Ztree> initZtree (List<Area> areaList, List<String> sysUserList, boolean permsFlag){
        List<Ztree> list = new ArrayList<Ztree>();

        for (Area area: areaList){
            Ztree ztree = new Ztree();
            ztree.setId(area.getAreaCode());
            ztree.setName(transMenuName(area, sysUserList, permsFlag));
            ztree.setPid(area.getParent());
            ztree.setTitle(area.getAreaName());
            if (sysUserList != null){
                ztree.setChecked(sysUserList.contains(area.getAreaCode()));
            }
            list.add(ztree);
        }

        return list;
    }

    public String transMenuName(Area area, List<String> userList, boolean permsFlag)
    {
        StringBuffer sb = new StringBuffer();
        sb.append(area.getAreaName());
        if (permsFlag)
        {
        }
        return sb.toString();
    }

}
