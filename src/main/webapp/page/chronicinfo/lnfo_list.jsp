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

    <title>慢病证信息列表</title>

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
<form method="get" action="page/chronicinfo/list" id="listform">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">
                <c:if test="${user.role.roleId != 'R203'}">
                    <li> <a class="button border-main icon-plus-square-o" href="page/chronicinfo/input"> 添加内容</a> </li>
                </c:if>
                <li>搜索：</li>
                <li>
                    <input type="text" placeholder="请输入搜索农合编号" name="persCode" class="input" style="width:250px; line-height:17px;display:inline-block" />
                    <button class="button border-main icon-search"  type="submit"> 搜索</button></li>
                <li>
                    <c:if test="${user.role.roleId != 'R203'}">
                        <button class="button border-main icon-file-excel-o" onclick="tableToExcel('item','慢病登记记录')">导出</button>
                    </c:if>
                </li>
            </ul>
        </div>
        <table class="table table-hover text-center" id="item">
            <tr>
                <th width="100" style="text-align:left; padding-left:20px;">ID</th>
                <th>农合编号</th>
                <th>疾病名称</th>
                <th>慢病起始时间</th>
                <th>慢病治愈时间</th>
                <th>状态</th>
                <th>建档时间</th>
                <th>参合人</th>
                <th width="310">操作</th>
            </tr>

            <c:forEach items="${list}" var="list" varStatus="i">
                <tr>
                    <td>${i.index}</td>
                    <td>${list.persCode}</td>
                    <td>${list.chronicdis.illName}</td>
                    <td>${list.startTime}</td>
                    <td>${list.endTime}</td>
                    <c:if test="${list.status == 0}">
                        <td>注销</td>
                    </c:if>
                    <c:if test="${list.status == 1}">
                        <td>正常</td>
                    </c:if>
                    <td>${list.creatTime}</td>
                    <td>${list.creatOr}</td>
                    <td>
                        <div class="button-group">
                            <c:if test="${user.role.roleId != 'R203'}">
                                <a class="button border-main" href="page/chronicinfo/get?id=${list.id}"><span class="icon-edit"></span> 修改</a>
                                <a class="button border-red" href="page/chronicinfo/del?id=${list.id}"><span class="icon-trash-o"></span> 删除</a>
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
    <script type="text/javascript">
        function base64 (content) {
            return window.btoa(unescape(encodeURIComponent(content)));
        }
        /*
        *@tableId: table的Id
        *@fileName: 要生成excel文件的名字（不包括后缀，可随意填写）
        */
        function tableToExcel(tableID,fileName){
            var table = document.getElementById(tableID);
            var excelContent = table.innerHTML;
            var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' xmlns='http://www.w3.org/TR/REC-html40'>";
            excelFile += "<head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head>";
            excelFile += "<body><table>";
            excelFile += excelContent;
            excelFile += "</table></body>";
            excelFile += "</html>";
            var link = "data:application/vnd.ms-excel;base64," + base64(excelFile);
            var a = document.createElement("a");
            a.download = fileName+".xls";
            a.href = link;
            a.click();
        }
    </script>
</form>
</body>

</html>