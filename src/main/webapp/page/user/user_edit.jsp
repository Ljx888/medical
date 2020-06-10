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
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/admin.css">

    <script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="js/admin.js"></script>
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
        <strong><span class="icon-pencil-square-o"></span>增加经办机构信息</strong>
    </div>
    <div class="body-content">
        <form id="form-add" method="post" class="form-x"
              action="<%=path%>/userServlet?type=edit">
            <div class="form-group">
                <div class="label">
                    <label>用户编号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${user.userId }" name="userId" data-validate="required:请输入标题" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>用户名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${user.fullName }" name="fullName" data-validate="required:请输入标题" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>密码：</label>
                </div>
                <div class="field">
                    <input type="password" class="input w50" value="${user.pwd}" name="pwd" data-validate="required:请输入标题" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>其他属性：</label>
                </div>
                <div class="field" style="padding-top:8px;">
                    <c:choose>
                        <c:when test="${user.status == 1 }">
                            启用 <input name="status"  type="radio" value="1" checked="checked"/>
                        </c:when>
                        <c:otherwise>启用 <input name="status"  type="radio" value="1"/></c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${user.status == 0 }">
                            未启用 <input name="status"  type="radio" value="0" checked="checked"/>
                        </c:when>
                        <c:otherwise>未启用 <input name="status"  type="radio" value="0"/></c:otherwise>
                    </c:choose>

                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>农合机构：</label>
                </div>
                <div class="field">
                    <select id="areapid" name="agenCode" class="input w50">
                        <option value="${user.agenCode}">${user.agenCode}</option>
                        <c:forEach items="${inst}" var="inst">
                            <option value="${inst.agenCode}">${inst.agenName}</option>
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
