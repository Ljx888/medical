<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
        <strong><span class="icon-pencil-square-o"></span>添加行政区域信息</strong>
    </div>
    <div class="body-content">
        <form id="form-add" method="post" class="form-x" action="page/area/add">
            <div class="form-group">
            <div class="label">
                <label>父级菜单：</label>
            </div>
            <div class="field">
                <select name="cid" class="input w50">
                    <c:forEach items="${area}" var="area" varStatus="i">
                       <c:if test="${area.grade==1}">
                           <option value="${area.areaCode}-${area.grade}">${area.areaName} |-</option>
                       </c:if>
                        <c:if test="${area.grade !=4 && area.grade !=1}">
                            <option value="${area.areaCode}-${area.grade}">${area.areaName}   <c:forEach begin="1" end="${area.grade}">-</c:forEach>
                            </option>
                        </c:if>
                    </c:forEach>
                </select>
                <div class="tips"></div>
            </div></div>
            <div class="form-group">
                <div class="label">
                    <label>行政区域编号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="areaCode" data-validate="required:请输入标题" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>行政区域名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="areaName" data-validate="required:请输入标题" />
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
