/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: Ztree
 * Author:   Administrator
 * Date:     2020/6/6 0006 15:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.core.domain;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/6 0006
 * @since 1.0.0
 */
public class Ztree implements Serializable {
    private String id; //节点编号
    private String pid; //父节点编号
    private String name; //节点名称
    private String title; //标题
    private boolean checked = false; // 是否勾选
    private boolean open = false; //是否打开
    private boolean nocheck = false; //是否勾选

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isNocheck() {
        return nocheck;
    }

    public void setNocheck(boolean nocheck) {
        this.nocheck = nocheck;
    }

    @Override
    public String toString() {
        return "Ztree{" +
                "id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", checked=" + checked +
                ", open=" + open +
                ", nocheck=" + nocheck +
                '}';
    }
}
