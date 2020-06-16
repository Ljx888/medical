<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>慢性病报销系统V1.0</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
        <h1><img src="/images/logo.jpg" class="radius-circle rotate-hover" height="50" alt="" />慢性病报销系统</h1>
    </div>
    <div class="head-l" ><a href="" target="_blank" style="color:#FFF" ><span class="icon-user"></span> 欢迎 admin</a>&nbsp;&nbsp;<a class="button button-little bg-green" href="" target="_blank" ><span class="icon-home"></span> 首页</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="../login.html"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
    <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>


    <h2><span class="icon-user"></span>基本设置</h2>
    <ul style="display:block">
        <li><a href="page/user/list" target="right"><span class="icon-caret-right"></span>用户管理</a></li>
        <li><a href="page/role/list" target="right"><span class="icon-caret-right"></span>角色管理</a></li>
        <li><a href="page/menu/list" target="right"><span class="icon-caret-right"></span>菜单管理</a></li>
        <li><a href="page/area/list" target="right"><span class="icon-caret-right"></span>行政管理</a></li>
        <li><a href="page/init/list" target="right"><span class="icon-caret-right"></span>经办管理</a></li>
        <li><a href="page/chronicdis/list" target="right"><span class="icon-caret-right"></span>慢性病分类管理</a></li>
        <li><a href="page/medical/list" target="right"><span class="icon-caret-right"></span>医疗机构管理</a></li>
        <li><a href="page/policy/list" target="right"><span class="icon-caret-right"></span>慢性病政策管理</a></li>
        <li><a href="page/family/list" target="right"><span class="icon-caret-right"></span>家庭档案管理</a></li>
        <li><a href="page/payment/input" target="right"><span class="icon-caret-right"></span>参合报销登记管理</a></li>
        <li><a href="page/chronicinfo/list" target="right"><span class="icon-caret-right"></span>慢性证管理</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>栏目管理</h2>
    <ul>
        <li><a href="../list.html" target="right"><span class="icon-caret-right"></span>内容管理</a></li>
        <li><a href="../add.html" target="right"><span class="icon-caret-right"></span>添加内容</a></li>
        <li><a href="../cate.html" target="right"><span class="icon-caret-right"></span>分类管理</a></li>
    </ul>
    <h2><span class="icon-user"></span>测试动态导航</h2>
    <ul>
        <c:forEach items="${list}" var="list" varStatus="i">
            <c:if test="${list.level == 2}">
                <li><a href="${list.url}/list" target="right"><span class="icon-caret-right"></span>${list.menuName}</a></li>
            </c:if>
        </c:forEach>
    </ul>
    <h2><span class="icon-user"></span>个人信息</h2>
    <ul>
        <li><a href="../list.html" target="right"><span class="icon-caret-right"></span>个人信息管理</a></li>
        <li><a href="../add.html" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
    </ul>
    <h2><span class="icon-user"></span>学生管理</h2>
    <ul>
        <li><a href="../admin/addstudent.html" target="right"><span class="icon-caret-right"></span>添加学生</a></li>
        <li><a href="../add.html" target="right"><span class="icon-caret-right"></span>查询学生</a></li>
    </ul>
    <h2><span class="icon-user"></span>老师管理</h2>
    <ul>
        <li><a href="../list.html" target="right"><span class="icon-caret-right"></span>添加老师</a></li>
        <li><a href="../add.html" target="right"><span class="icon-caret-right"></span>查询老师</a></li>
    </ul>
    <h2><span class="icon-wrench"></span>班级管理</h2>
    <ul>
        <li><a href="../list.html" target="right"><span class="icon-caret-right"></span>录入班级</a></li>
        <li><a href="../add.html" target="right"><span class="icon-caret-right"></span>查询班级</a></li>
    </ul>
    <h2><span class="icon-wrench"></span>课程管理</h2>
    <ul>
        <li><a href="../list.html" target="right"><span class="icon-caret-right"></span>录入课程</a></li>
        <li><a href="../add.html" target="right"><span class="icon-caret-right"></span>查询课程</a></li>
    </ul>

</div>
<script type="text/javascript">
    $(function(){
        $(".leftnav h2").click(function(){
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function(){
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });
</script>
<ul class="bread">
    <li><a href="{:U('Index/info')}" target="right" class="icon-home"> 首页</a></li>
    <li><a href="##" id="a_leader_txt">欢迎界面</a></li>
    <li><b>当前语言：</b><span style="color:red;">中文</span>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a href="##">英文</a> </li>
</ul>
<div class="admin">
    <iframe scrolling="auto" rameborder="0" src="welcome.html" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
    <p>来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
</div>
</body>
</html>