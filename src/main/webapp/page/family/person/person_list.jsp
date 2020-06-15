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

    <title>疾病列表</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>

<body>
<form method="post" action="page/chronicdis/list" id="listform">
    <div class="panel admin-panel">
        <div class="padding border-bottom">
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th width="100" style="text-align:left; padding-left:20px;">ID</th>
                <th>家庭编号</th>
                <th>户口编号</th>
                <th>户主姓名</th>
                <th>出生日期</th>
                <th>性别</th>
                <th>岁数</th>
                <th>电话号码</th>
                <th>家庭地址</th>
                <th>职业</th>
                <th width="310">操作</th>
            </tr>

            <c:forEach items="${list}" var="list" varStatus="i">
                <tr>
                    <td>${i.index}</td>
                    <td>${list.famiCode}</td>
                    <td>${list.persCode}</td>
                    <td>${list.persName}</td>
                    <td>${list.birthday}</td>
                    <td>${list.sex}</td>
                    <td>${list.age}</td>
                    <td>${list.telephone}</td>
                    <td>${list.liveAddress}</td>
                    <td>${list.workUnit}</td>
                    <td>
                        <div class="button-group">
                            <a class="button border-red" href="page/family/delPerson?persCode=${list.persCode}&famiCode=${list.famiCode}"><span class="icon-trash-o"></span> 删除</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>
    <div class="pagelist">
        <c:choose>
            <c:when  test="${page.hasPrePage}"><a href="instServlet?type=list&currentPage=1">首页</a>
                <a href="instServlet?type=list&currentPage=${page.currentPage-1}">上一页</a>
            </c:when>
            <c:otherwise>首页 | 上一页</c:otherwise>
        </c:choose>
        <c:forEach var="i" begin="1" end="${page.totalPage}" step="1">
            <a href="instServlet?type=list&currentPage=${i}">${i}</a>
        </c:forEach>
        <c:choose>
            <c:when test="${page.hasNextPage}">
                <a href="instServlet?type=list&currentPage=${page.currentPage+1}">下一页</a>|
                <a href="instServlet?type=list&currentPage=${page.totalPage}">尾页</a>
            </c:when>
            <c:otherwise>下一页 | 尾页</c:otherwise>
        </c:choose>
        <span style="margin-left: 10px">当前为第${page.currentPage}页|一共${page.totalPage}页</span>
    </div>
</form>
</body>

</html>
