    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

        <title>菜单信息列表</title>

        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">

        <link rel="stylesheet" href="css/pintuer.css">
        <link rel="stylesheet" href="css/admin.css">
        <link rel="shortcut icon" href="images/logo.jpg">
        <script src="js/jquery.js"></script>
        <script src="js/pintuer.js"></script>
        </head>

        <body>
        <form method="get" action="page/role/list" id="listform">
        <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
        <div class="padding border-bottom">
        <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="page/menu/input"> 添加内容</a> </li>
        <li>搜索：</li>
        <li>
        <input type="text" placeholder="请输入搜索菜单名称" name="menuName" class="input" style="width:250px; line-height:17px;display:inline-block" />
        <button class="button border-main icon-search" type="submit"> 搜索</button></li>
        </ul>
        </div>
        <table class="table table-hover text-center">
        <tr>
        <th width="100" style="text-align:left; padding-left:20px;">ID</th>
        <th>菜单编号</th>
        <th>菜单名称</th>
        <th>路径</th>
        <th>父菜单编号</th>
        <th width="310">操作</th>
        </tr>

        <c:forEach items="${pageInfo.list}" var="list" varStatus="i">
            <tr>
            <td>${i.index}</td>
            <td>${list.menuId}</td>
            <td>${list.menuName}</td>
            <td>${list.url}</td>
            <td>${list.menuPid}</td>
            <td>
            <div class="button-group">
            <a class="button border-main" href="page/menu/get?menuId=${list.menuId}"><span class="icon-edit"></span> 修改</a>
            <a class="button border-red" href="page/menu/del?menuId=${list.menuId}"><span class="icon-trash-o"></span> 删除</a>
            </div>
            </td>
            </tr>
        </c:forEach>

        </table>
        </div>
        <div class="pagelist">
        <p>当前 ${pageInfo.pageNum }页,总${pageInfo.pages }
        页,总 ${pageInfo.total } 条记录</p>
        <a href="page/menu/list?pageNo=${pageInfo.firstPage}">第一页</a>
        <c:if test="${pageInfo.hasPreviousPage }">
            <a href="page/menu/list?pageNo=${pageInfo.pageNum-1}">上一页</a>
        </c:if>

        <c:if test="${pageInfo.hasNextPage }">
            <a href="page/menu/list?pageNo=${pageInfo.pageNum+1}">下一页</a>
        </c:if>

        <a href="page/menu/list?pageNo=${pageInfo.lastPage}">最后页</a>
        </div>

        </form>
        </body>

        </html>
    