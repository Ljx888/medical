/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: UUIDUtil
 * Author:   Administrator
 * Date:     2020/6/15 0015 20:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.core.util;

import java.util.UUID;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/15 0015
 * @since 1.0.0
 */
public class UUIDUtil {
    public static String uuid(){
        String uuid = UUID.randomUUID().toString().replaceAll("","").toUpperCase();
        return uuid;
    }

    public static void main(String [] ag){
        System.out.println(uuid());
    }
}
