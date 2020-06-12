<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script type="javascript">
        $(document).ready(function() {
            //重新绑定表单提交
            $("#add_btn").bind("click", function() {
                $('form').submit();
            });
        });
    </script>

</head>

<body>

<div class="panel admin-panel">
    <div class="panel-head" id="add">
        <strong><span class="icon-pencil-square-o"></span>增加医疗机构信息</strong>
    </div>
    <div class="body-content">
        <form id="form-add" method="post" class="form-x" action="page/medical/add">
            <div class="form-group">
                <div class="label">
                    <label>医疗机构编码：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="jgbm"
                           data-validate="required:请输入医疗机构编码" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>组织机构编码：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="zzjgbm"
                           data-validate="required:请输入组织机构编码" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>机构名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="jgmc"
                           data-validate="required:必填项" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>地区编码：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="dqbm"
                           data-validate="required:必填项" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>行政区域编码：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="areaCode"
                           data-validate="required:必填项" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>隶属关系：</label>
                </div>
                <div class="field">
                    <select id="lsgx1" name="lsgx" class="input w50">
                            <c:forEach items="${list02}" var="list">
                                <option value="${list.itemCode}">${list.itemName}</option>
                            </c:forEach>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>机构级别：</label>
                </div>
                <div class="field">
                    <select id="jgjb" name="jgjb" class="input w50">
                            <c:forEach items="${list06}" var="list">
                                <option value="${list.itemCode}">${list.itemName}</option>
                            </c:forEach>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>申请定点类型：</label>
                </div>
                <div class="field">
                    <select id="sbddlx" name="sbddlx" class="input w50">
                        <c:forEach items="${list04}" var="list">
                            <option value="${list.itemCode}">${list.itemName}</option>
                        </c:forEach>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>批准定点类型：</label>
                </div>
                <div class="field">
                    <select id="lsgx2" name="pzddlx" class="input w50">
                        <c:forEach items="${list04}" var="list">
                            <option value="${list.itemCode}">${list.itemName}</option>
                        </c:forEach>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>所属经济类型：</label>
                </div>
                <div class="field">
                    <select id="lsgx" name="ssjjlx" class="input w50">
                        <c:forEach items="${list01}" var="list">
                            <option value="${list.itemCode}">${list.itemName}</option>
                        </c:forEach>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>卫生机构大类：</label>
                </div>
                <div class="field">
                    <select id="wsjgdl" name="wsjgdl" class="input w50">
                        <c:forEach items="${list03}" var="list">
                            <option value="${list.itemCode}">${list.itemName}</option>
                        </c:forEach>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>卫生机构小类：</label>
                </div>
                <div class="field">
                    <select id="wsjgxl" name="wsjgxl" class="input w50">
                        <c:forEach items="${list301}" var="list">
                            <option value="${list.itemCode}">${list.itemName}</option>
                        </c:forEach>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>主管单位：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="zgdw"
                           data-validate="required:必填项" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>开业时间：</label>
                </div>
                <div class="field">
                    <input type="datetime-loca" class="input w50" name="kysj"
                           data-validate="required:必填项" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>法人代表：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="frdb"
                           data-validate="required:必填项" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>注册资金：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="zczj"
                           data-validate="number:必填项" />
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button id="addRole_btn" class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>