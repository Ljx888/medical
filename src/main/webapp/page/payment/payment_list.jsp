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
    <link rel="shortcut icon" href="images/logo.jpg">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script type="text/javascript">
        function chooseGroup() {
            var hehe = $("#village").val();
            $.ajax({
                url:'page/area/group',
                type:'POST',
                data:{"areaCode":hehe},
                cache:false,
                dataType:'json',
                success:function(data){
                    var str = null;
                    for(var i=0; i<data.length; i++){
                        str += "<option value='"+data[i].areaCode+
                            "'>" + data[i].areaName+"</option>"
                    }
                    $("#group").html(str);
                },
                error : function(){
                    alert("可能没有充钱");
                }
            });
        }
    </script>
</head>

<body>
<form method="get" action="page/payment/input" id="listform">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">
                <li>搜索：</li>
                    <li>
                        <select id="village" name="villages" class="input" style="width:200px; line-height:17px;" onchange="chooseGroup()">
                            <c:forEach items="${area}" var="area">
                                <option value="${area.areaCode}">${area.areaName}</option>
                            </c:forEach>
                        </select>
                    </li>
                <li>
                    <select id="group" name="groupNo" class="input" style="width:200px; line-height:17px;">
                        <option value="">请选择所在组</option>
                    </select>
                </li>
                <li>
                    <input type="text" placeholder="请输入搜索参合农民姓名" name="persName" class="input" style="width:250px; line-height:17px;display:inline-block" />
                    <button class="button border-main icon-search" type="submit"> 搜索</button></li>
            </ul>
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th width="100" style="text-align:left; padding-left:20px;">ID</th>
                <th>乡镇/村/组</th>
                <th>家庭编号</th>
                <th>农合证号</th>
                <th>个人姓名</th>
                <th>身份证号</th>
                <th width="310">操作</th>
            </tr>

            <c:forEach items="${list}" var="item" varStatus="i">
                <tr>
                    <td>${i.index}</td>
                    <td>${item.famiCode}</td>
                    <td>${item.persCode}</td>
                    <td>${item.persName }</td>
                    <td>${item.cardId}</td>
                    <td>
                        <div class="button-group">
                            <c:if test="${user.role.roleId != 'R203'}">
                                <a class="button border-main" href="page/payment/members?famiCode=${item.famiCode}"><span class="icon-edit"></span> 缴费</a>
                            </c:if>
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
