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

    <title>用户信息列表</title>

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
<form method="post" action="" id="listform">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">
                <li> <a class="button border-main icon-plus-square-o" href="page/role/role_add.jsp"> 添加内容</a> </li>
                <li>搜索：</li>
                <li>首页
                    <select name="s_ishome" class="input" onchange="changesearch()" style="width:60px; line-height:17px; display:inline-block">
                        <option value="">选择</option>
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                    &nbsp;&nbsp;
                    推荐
                    <select name="s_isvouch" class="input" onchange="changesearch()"  style="width:60px; line-height:17px;display:inline-block">
                        <option value="">选择</option>
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                    &nbsp;&nbsp;
                    置顶
                    <select name="s_istop" class="input" onchange="changesearch()"  style="width:60px; line-height:17px;display:inline-block">
                        <option value="">选择</option>
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </li>
                <if condition="$iscid eq 1">
                    <li>
                        <select name="cid" class="input" style="width:200px; line-height:17px;" onchange="changesearch()">
                            <option value="">请选择分类</option>
                            <option value="">产品分类</option>
                            <option value="">产品分类</option>
                            <option value="">产品分类</option>
                            <option value="">产品分类</option>
                        </select>
                    </li>
                </if>
                <li>
                    <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
                    <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li>
            </ul>
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th width="100" style="text-align:left; padding-left:20px;">ID</th>
                <th>角色编号</th>
                <th>角色名称</th>
                <th width="310">操作</th>
            </tr>

            <c:forEach items="${list}" var="list" varStatus="i">
                <tr>
                    <td>${i.index}</td>
                    <td>${list.roleId}</td>
                    <td>${list.roleName}</td>
                    <td>
                        <div class="button-group">
                            <a class="button border-main" href="roleServlet?type=get&roleId=${list.roleId}"><span class="icon-edit"></span> 修改</a>
                            <a class="button border-red" href="roleServlet?type=del&roleId=${list.roleId}"><span class="icon-trash-o"></span> 删除</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>
    <div class="pagelist">
        <c:choose>
            <c:when  test="${page.hasPrePage}"><a href="roleServlet?type=list&currentPage=1">首页</a>
                <a href="roleServlet?type=list&currentPage=${page.currentPage-1}">上一页</a>
            </c:when>
            <c:otherwise>首页 | 上一页</c:otherwise>
        </c:choose>
        <c:forEach var="i" begin="1" end="${page.totalPage}" step="1">
            <a href="roleServlet?type=list&currentPage=${i}">${i}</a>
        </c:forEach>
        <c:choose>
            <c:when test="${page.hasNextPage}">
                <a href="roleServlet?type=list&currentPage=${page.currentPage+1}">下一页</a>|
                <a href="roleServlet?type=list&currentPage=${page.totalPage}">尾页</a>
            </c:when>
            <c:otherwise>下一页 | 尾页</c:otherwise>
        </c:choose>
        <span style="margin-left: 10px">当前为第${page.currentPage}页|一共${page.totalPage}页</span>
    </div>
</form>
</body>

</html>