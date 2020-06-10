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
        <strong><span class="icon-pencil-square-o"></span>增加经办机构信息</strong>
    </div>
    <div class="body-content">
        <form id="form-add" method="post" class="form-x"
              action="<%=path%>/userServlet?type=save">
            <div class="form-group">
                <div class="label">
                    <label>用户编号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="userId" data-validate="required:请输入标题" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>用户名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="fullName" data-validate="required:请输入标题" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>密码：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="pwd" data-validate="required:请输入标题" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>其他属性：</label>
                </div>
                <div class="field" style="padding-top:8px;">
                    启用 <input name="status"  type="radio" value="1"/>
                    未启用 <input name="status"  type="radio" value="0"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>角色名称：</label>
                </div>
                <div class="field" style="padding-top:8px;">
                    <c:forEach items="${roles}" var="roles">
                        <input name="roleIds" type="checkbox" value="${roles.roleId}" />${roles.roleName}
                    </c:forEach>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>农合机构：</label>
                </div>
                <div class="field">
                    <select id="areapid" name="agenCode" class="input w50">
                        <c:forEach items="${init}" var="init">
                            <option value="${init.agenCode}">${init.agenName}</option>
                        </c:forEach>
                    </select>
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
