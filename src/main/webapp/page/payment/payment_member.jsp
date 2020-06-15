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

    <title>列表</title>

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
    <script type="text/javascript">
        //页面计算缴费总额
        function caculate(){
            var amount=$("#amount").val();
            var size=$('input:checkbox[name=persCode]:checked').length;
            var sum=size*amount;
            $("#payCost").html("本次缴费："+sum+"元");
        }
    </script>
</head>

<body>
<form method="post" action="page/payment/add" >
    <div class="panel admin-panel">
        <div class="panel-head">
            <strong class="icon-reorder">未缴费家庭成员信息列表</strong>
        </div>
        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">
                <li>当年缴费标准：￥：${amount}元<input type="hidden" name="amount" id="amount" value="${amount}"/></li>
                <li id="payCost"></li>
            </ul>
            <table class="table table-hover text-center">
                <tr>
                    <th>序号</th>
                    <th>农合证号</th>
                    <th>成员姓名</th>
                    <th>与户主关系</th>
                    <th>性别</th>
                    <th>出生年月</th>
                    <th>身份证号</th>
                </tr>
                <c:forEach var="item" items="${list}" varStatus="i">
                    <tr>
                        <td><input type="checkbox" name="persCode" value="${item.persCode}-${item.famiCode}" onclick="caculate();"/></td>
                        <td>${item.persCode}</td>
                        <td>${item.persName}</td>
                        <td>
                            <c:if test="${item.relation=='1'}">户主</c:if>
                            <c:if test="${item.relation=='2'}">配偶</c:if>
                            <c:if test="${item.relation=='3'}">子女</c:if>
                            <c:if test="${item.relation=='4'}">父母</c:if>
                        </td>
                        <td>
                            <c:if test="${item.sex=='1'}">男</c:if>
                            <c:if test="${item.sex=='2'}">女</c:if></td>
                        <td>${item.birthday}</td>
                        <td>${item.cardId}</td>
                    </tr>
                </c:forEach>
            </table>
            <div align="center">
                <button id="pay_btn" class="button bg-main icon-check-square-o"
                        type="submit">确定缴费</button>
                <button id="print_btn" class="button bg-main icon-print"
                        type="button">打印凭证</button>
            </div>
        </div>
    </div>
</form>
</body>

</html>
