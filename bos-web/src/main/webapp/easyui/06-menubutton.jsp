<%--
  Created by IntelliJ IDEA.
  User: lee leeshuhua@163.com
  Date: 2018/3/29
  Time: 23:08
  Description:
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>menubutton</title>
</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<body>
    <%--制作菜单--%>
    <a data-options="iconCls:'icon-help',menu:'#mm'" class="easyui-menubutton">控制面板</a>

    <%--使用div元素制作下拉菜单--%>
    <div id="mm">
        <div onclick="alert(111)" data-options="iconCls:'icon-edit'">修改密码</div>
        <div>联系管理员</div>
        <div class="menu-sep"></div>
        <div>退出系统</div>
    </div>
</body>
</html>
