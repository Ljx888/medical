/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: ITReimbursementService
 * Author:   Administrator
 * Date:     2020/6/17 0017 12:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.service;

import com.gx.wuzhou.medical.domain.TPayment;
import com.gx.wuzhou.medical.domain.TReimbursement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/17 0017
 * @since 1.0.0
 */
public interface ITReimbursementService {

    /**
     * 查询慢性报销信息
     *
     * @param reimbursement
     * @return
     */
    public List<TReimbursement> selectTReimbursementList(TReimbursement reimbursement);

    /**
     * 添加
     *
     * @param reimbursement
     * @return
     */
    public int insertTreimbursement(TReimbursement reimbursement);

    /**
     * 修改
     *
     * @param reimbursement
     * @return
     */
    public int updateTReimbursement(TReimbursement reimbursement);
}
