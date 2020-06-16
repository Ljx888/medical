<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
    <!-- 引入第三方日期JS组件 -->
    <script type="text/javascript" src="third/laydate/laydate.js"></script>
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
        <strong><span class="icon-pencil-square-o"></span>增加慢性病信息</strong>
    </div>
    <div class="body-content">
        <form id="form-add" method="post" class="form-x"
              action="page/chronicinfo/add">
            <div class="form-group">
                <div class="label">
                    <label>农合证号</label>
                </div>
                <div class="field">
                    <input type="text" id="" name="persCode" value="" class="input w50"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>疾病编码：</label>
                </div>
                <div class="field">
                    <select id="illCode" name="illCode" class="input w50">
                        <c:forEach items="${chro}" var="chro">
                            <option value="${chro.illCode}">${chro.illName}</option>
                        </c:forEach>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>慢病起始时间：</label>
                </div>
                <div class="field">
                    <input type="text" id="birthday" name="startTime" value="2020-10-01" class="input w50"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>慢病治愈时间：</label>
                </div>
                <div class="field">
                    <input type="text" id="birthday2" name="endTime" value="2020-10-01" class="input w50"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>状态：</label>
                </div>
                <div class="field">
                    <select  class="input w50" name="status">
                        <option value="1" selected="selected" >正常</option>
                        <option value="0">注销</option>
                    </select>
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
<!--渲染JS日期组件 -->
<script type="text/javascript">
    laydate.render({
        elem: '#birthday'
    });
    laydate.render({
        elem: '#birthday2'
    })
</script>
</body>
</html>
