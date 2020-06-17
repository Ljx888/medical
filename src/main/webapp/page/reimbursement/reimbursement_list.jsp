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

    <title>慢性病政策列表</title>

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
<form action="" id="listform">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">查询报销信息</a></div>
        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">
                <li> <a class="button border-main icon-plus-square-o" href="page/reimbursement/listAll"> 查看慢性报销功能</a> </li>
                <li>搜索：</li>
                <li>
                    <input id="cardId" type="text" placeholder="请输入搜索身份证号" name="cardId" class="input" style="width:250px; line-height:17px;display:inline-block" />
                    <button class="button border-main icon-search" onclick="chooseGroup()"> 添加报销信息</button></li>
            </ul>
        </div>
    </div>
    <div class="pagelist">
    </div>
    <script type="text/javascript">
        function chooseGroup() {
            var hehe = $("#cardId").val();
            $.ajax({
                url:'page/reimbursement/input',
                type:'GET',
                data:{"cardId":hehe},
                cache:false,
                dataType:'json',
                success:function(data){
                    if(data == null){
                        alert("该用户没有参与参合登记");
                    }else {
                        location.href = "page/reimbursement/info?persCode="+data.persCode+""
                    }
                },
                error : function(){
                    alert("可能没有充钱");
                }
            });
        }
    </script>
</form>
</body>

</html>