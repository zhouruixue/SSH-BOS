<%--
  Created by IntelliJ IDEA.
  User: lee leeshuhua@163.com
  Date: 2018/3/18
  Time: 11:59
  Description:
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tabs</title>
    <%--引入easyui--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>

</head>
<body class="easyui-layout">
    <%--使用div元素描述每个区域--%>
    <div title="XXX管理系统" style="height:100px;" data-options="region:'north'">北部区域</div>
    <div title="系统菜单" style="width:200px;" data-options="region:'west'">
        <!-- 製作accordion折疊面板
        fit:true   自適應（填充父容器）
         -->
        <div class="easyui-accordion" data-options="fit:true">
            <%--利用div表示每个折叠面板--%>
                <div data-options="iconCls:'icon-cut'" title="面板一">
                    <a id="but1" class="easyui-linkbutton">添加一個選項卡</a>
                    <script type="text/javascript">
                        $(function () {
                            //頁面加載完成后，為我們上面的按鈕綁定事件
                            $("#but1").click(function(){
                                //判断“系统管理”选项卡是否存在
                                var e = $("#mytabs").tabs("exists","系统管理");
                                if(e){
                                    //已经存在
                                    $("#mytabs").tabs("select","系统管理");
                                }else{
                                    //調用tabs對象的add方法動態添加一個選項卡
                                    $("#mytabs").tabs("add", {
                                            title:'系统管理',
                                            iconCls:'icon-edit',
                                            closeable:true,
                                            content:' <iframe frameborder="0" height="100%" width="100%" src="https://www.baidu.com"></iframe>'
                                        });
                                }
                            });
                        });
                    </script>
                </div>

                <div title="面板二">112</div>
                <div title="面板三">333</div>
        </div>
    </div>
    <div data-options="region:'center'">
        <%--製作一個tabs選項卡面板--%>
            <div id="mytabs" class="easyui-tabs" data-options="fit:true">
                <%--利用div表示每个折叠面板--%>
                <div data-options="iconCls:'icon-cut'" title="面板一">111</div>
                <div data-options="closable:true" title="面板二">112</div>
                <div title="面板三">333</div>
            </div>
    </div>
    <div style="width:100px;" data-options="region:'east'">东部区域</div>
    <div style="height:50px;" data-options="region:'south'">南部区域</div>
</body>
</html>
