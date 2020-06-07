<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
        <form method="post" class="form-x" action="page/role/add">
            <input id="fid" name="fid" value="" type="hidden"/>
            <div class="form-group">
                <div class="label">
                    <label>角色编号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="roleId" data-validate="required:请输入标题" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>角色名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="roleName" data-validate="required:请输入标题" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>权限菜单：</label>
                </div>
                <div class="field">
                    <ul id="zTree"  class="ztree" style="border: 1px solid #ddd;"></ul>
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
    <script type="text/javascript">
        var setting = {
                check: {
                    enable: true,
                    chkStyle: "checkbox",
                    chkboxType: { "Y": "ps", "N": "ps" }
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
                type: 'post',
                enable: true,    //是否加载异步
                url: "<%=path%>/menu/roleAdd",
                otherParam: ["treeId", "0"]
            }

        };

        $(document).ready(function(){
            //初始化ztree
            $.fn.zTree.init($("#zTree"), setting);
            //重新绑定表单提交
            $("#addRole_btn").bind("click",function(){
                var tree = $.fn.zTree.getZTreeObj("zTree");
                var nodes = tree.getCheckedNodes(true);
                var fid="";
                if(nodes.length==0){
                    alert("没有选择任何的功能!");
                    return false;
                }
                for (var i = 0; i < nodes.length; i++) {
                    if(i==0){
                        fid=nodes[i].id;
                    }else{
                        fid+=","+nodes[i].id;
                    }
                }
                $("#fid").val(fid);
                $('form').submit();
            });

        });
    </script>
</div>

</body>
</html>