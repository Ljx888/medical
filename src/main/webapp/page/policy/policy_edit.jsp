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
    <link rel="shortcut icon" href="images/logo.jpg">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script type="text/javascript">
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
        <strong><span class="icon-pencil-square-o"></span>修改慢性病政策信息</strong>
    </div>
    <div class="body-content">
        <form id="form-add" method="post" class="form-x"
              action="page/policy/edit">
            <div class="form-group">
                <div class="label">
                    <label>执行年度：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${policy.runyear}" name="runyear"
                           data-validate="required:请输入执行年度" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>封顶线：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${policy.maxline}" name="maxline"
                           data-validate="number:请输入数值" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>状态：</label>
                </div>
                <div class="field">
                    <select  class="input w50" name="status">
                        <c:if test="${policy.status == 1}">
                            <option value="${policy.status}">启用</option>
                        </c:if>
                        <c:if test="${policy.status == 0}">
                            <option value="${policy.status}">禁用</option>
                        </c:if>
                        <option value="1" selected="selected" >启用</option>
                        <option value="0">禁用</option>
                    </select>

                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>备注</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${policy.remark}" name="remark"
                           data-validate="required:不超过100个字" />
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
