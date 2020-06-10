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
    <link rel="stylesheet" href="css/ztree.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>

    <link rel="stylesheet" href="third/zTree_v3/css/zTreeStyle/zTreeStyle.css">
    <script type="text/javascript" src="third/zTree_v3/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="third/zTree_v3/js/jquery.ztree.excheck.js"></script>
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
        <strong><span class="icon-pencil-square-o"></span>增加经办机构信息</strong>
    </div>
    <div class="body-content">
        <form id="form-add" method="post" class="form-x"
              action="<%=path%>/page/init/add">
            <div class="form-group">
                <div class="label">
                    <label>所属地区：</label>
                </div>
                <div class="field">
                        <li class="title"><input id="areaCode" type="hidden" readonly value="" name="areaCode" style="width:120px;"/>
                        <ul id="treeDemo" class="ztree" style="margin-top:0; width:160px;"></ul>
                    <div class="tips"></div>
                </div>

            </div>
            <div class="form-group">
                <div class="label">
                    <label>经办机构编号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="agenCode" data-validate="required:请输入标题" />
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>经办机构名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="agenName" data-validate="required:请输入标题" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>
        </form>
    </div>
    <script type="text/javascript">
        <!--
        var setting = {
            view: {
                dblClickExpand: false
            },
            data: {
                simpleData: {
                    enable: true,
                    idKey: "id",
                    pIdKey: "pid",
                    rootPId: 0
                }
            },

            async:{    //异步加载数据
                type: 'get',
                enable: true,    //是否加载异步
                url: "<%=path%>/page/area/ztree",
                otherParam: ["treeId", "0"]
            },
            callback: {
                beforeClick: beforeClick,
                onClick: onClick
            }
        };

        function beforeClick(treeId, treeNode) {
            var check = (treeNode);
            return check;
        }

        function onClick(e, treeId, treeNode) {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
                nodes = zTree.getSelectedNodes(),
                v = "";
            nodes.sort(function compare(a,b){return a.id-b.id;});
            for (var i=0, l=nodes.length; i<l; i++) {
                v += nodes[i].id + ",";
            }
            if (v.length > 0 ) v = v.substring(0, v.length-1);
            var cityObj = $("#areaCode");
            cityObj.attr("value", v);
        }

        $(document).ready(function(){
            $.fn.zTree.init($("#treeDemo"), setting);
        });
        //-->
    </script>
</div>
</body>
</html>