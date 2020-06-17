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
                <th>报销编号</th>
                <th>身份证号</th>
                <th>参合农民名称</th>
                <th>疾病名称</th>
                <th>报销时间</th>
                <th>医疗总费用</th>
                <th>医疗发票号</th>
                <th>就诊时间</th>
                <th>报销比例</th>
                <th>报销金额</th>
                <th>农合参合人员</th>
                <th>审核</th>
                <th>是否汇款</th>
            </tr>

            <c:forEach items="${list}" var="list" varStatus="i">
                <tr>
                    <td>${i.index}</td>
                    <td>${list.reimbursementNumber}</td>
                    <td>${list.cardId}</td>
                    <td>${list.persName}</td>
                    <td>${list.illName}</td>
                    <td>${list.creatTime}</td>
                    <td>${list.medicalSum}</td>
                    <td>${list.medicalCode}</td>
                    <td>${list.visitTime}</td>
                    <td>${list.proprotion}</td>
                    <td>${list.money}</td>
                    <td>${list.creatOr}</td>
                    <c:if test="${list.status == 0}">
                        <td>未审核</td>
                    </c:if>
                    <c:if test="${list.status == 1}">
                        <td>审核通过</td>
                    </c:if>
                    <c:if test="${list.status == 2}">
                        <td>审核不通过</td>
                    </c:if>
                    <c:if test="${list.isRemittance == 0}">
                        <td>未汇款</td>
                    </c:if>
                    <c:if test="${list.isRemittance == 1}">
                        <td>已汇款</td>
                    </c:if>
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
