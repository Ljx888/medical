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

<div class="panel admin-panel">
    <div class="panel-head" id="add">
        <strong><span class="icon-pencil-square-o"></span>增加疾病信息</strong>
    </div>
    <div class="body-content">
        <form id="form-add" method="post"
              action="page/family/add">
            <input type="hidden" name="town"/>
            <div class="form-x">
                <div class="form-group">
                    <div class="label">
                        <label>所在村：</label>
                    </div>
                    <div class="field">
                        <select id="village" name="villages" class="input w50"
                                onchange="chooseGroup()">
                            <c:forEach items="${list}" var="list">
                                <option value="${list.areaCode}-${list.parent}">${list.areaName}</option>
                            </c:forEach>
                        </select>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>所在组：</label>
                    </div>
                    <div class="field">
                        <select id="group" name="groupNo" class="input w50" >
                            <option value="">请选择所在组</option>
                        </select>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>户属性：</label>
                    </div>
                    <div class="field">
                        <select id="housePro" name="housePro" class="input w50">
                            <option value="1">一般户</option>
                            <option value="2">五保户</option>
                            <option value="3">军烈属</option>
                            <option value="9">其他</option>
                        </select>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>户主姓名：</label>
                    </div>
                    <div class="field">
                        <input type="text" onblur="cascade();" id="persname" name="persName" value="钟海清" data-validate="chinese:姓名必须为中文" class="input w50"/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>身份证号：</label>
                    </div>
                    <div class="field">
                        <input type="text" id="cardID" name="cardId" value="450421195
108247000" class="input w50"/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>出生年月：</label>
                    </div>
                    <div class="field">
                        <input type="text" id="birthday" name="birthday" value="1969-10-01" class="input w50"/>
                        <div class="tips"></div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="label">
                        <label>性别：</label>
                    </div>
                    <div class="field">
                        <select id="sex" name="sex" class="input w50">
                            <option value="1">男</option>
                            <option value="2">女</option>
                        </select>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>人员属性：</label>
                    </div>
                    <div class="field">
                        <select id="persPro" name="persPro" class="input w50">
                            <option value="1">一般户</option>
                            <option value="2">民政救助对象</option>
                        </select>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>是否农村户口：</label>
                    </div>
                    <div class="field">
                        <select id="isRural" name="isRurals" class="input w50">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>职业：</label>
                    </div>
                    <div class="field">
                        <select id="occupation" name="occupation" class="input w50">
                            <option value="1">农民</option>
                            <option value="2">工人</option>
                            <option value="3">学生</option>
                            <option value="9">其他</option>
                        </select>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>工作单位：</label>
                    </div>
                    <div class="field">
                        <input type="text" id="workUnit" name="workUnit" data-validate="required:工作单位不能为空" class="input w50">
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>常住地址：</label>
                    </div>
                    <div class="field">
                        <input type="text" id="liveAddress" name="liveAddress" data-validate="required:常住地址不能为空" class="input w50">
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>联系电话：</label>
                    </div>
                    <div class="field">
                        <input type="text" id="telephone" name="telephone" value="13471402595" data-validate="mobile:电话号码格式错误" class="input w50">
                        <div class="tips"></div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="label">
                        <label></label>
                    </div>
                    <div class="field">
                        <button id="add_btn" class="button bg-main icon-check-square-o"
                                type="submit">提交</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <script type="javascript">
    </script>
</div>
<!--渲染JS日期组件 -->
<script type="text/javascript">
    laydate.render({
        elem: '#birthday'
    });
</script>
</body>
</html>
