    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
            <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
        <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
        <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
        <html lang="zh-cn">
        <head>
        <base href="<%=basePath%>">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta name="renderer" content="webkit">
        <title></title>
        <link rel="stylesheet" href="css/pintuer.css">
        <link rel="stylesheet" href="css/admin.css">
        <link rel="stylesheet" href="css/ztree.css">
        <script src="js/jquery.js"></script>
        <script src="js/pintuer.js"></script>
        <script src="js/mabinji.js"></script>

        <link rel="stylesheet" href="third/zTree_v3/css/zTreeStyle/zTreeStyle.css">
        <script type="text/javascript" src="third/zTree_v3/js/jquery.ztree.core.js"></script>
        <script type="text/javascript" src="third/zTree_v3/js/jquery.ztree.excheck.js"></script>
        </head>
        <body>
        <div class="panel admin-panel">
        <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
        <div class="body-content">
        <form method="post" class="form-x" action="page/menu//add">
        <input id="fid" name="fid" value="" type="hidden"/>
        <div class="form-group">
        <div class="label">
        <label>菜单编号：</label>
        </div>
        <div class="field">
        <input type="text" class="input w50" value="" name="menuId" data-validate="required:请输入标题" />
        <div class="tips"></div>
        </div>
        </div>
        <div class="form-group">
        <div class="label">
        <label>菜单名称：</label>
        </div>
        <div class="field">
        <input type="text" class="input w50" value="" name="menuName" data-validate="required:请输入标题" />
        <div class="tips"></div>
        </div>
        </div>
        <div class="form-group">
        <div class="label">
        <label>父级菜单：</label>
        </div>
        <div class="field">
        <select name="cid" class="input w50">
        <option value="0">主菜单</option>
        <c:forEach items="${menu}" var="menu" varStatus="i">
            <c:if test="${menu.level == 1}">
                <option value="${menu.menuId}-${menu.level}">${menu.menuName} |- ${menu.url}</option>
            </c:if>
            <c:if test="${menu.level == 2}">
                <option value="${menu.menuId}-${menu.level}">${menu.menuName}  -- ${menu.url}</option>
            </c:if>
        </c:forEach>
        </select>
        <div class="tips"></div>
        </div>
        </div>
        <div class="form-group">
        <div class="label">
        <label>路径：</label>
        </div>
        <div class="field">
        <input type="text" class="input w50" value="" name="url" data-validate="required:请输入标题" />
        <div class="tips"></div>
        </div>
        </div>

        <div class="clear"></div>
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

        </body>
        </html>