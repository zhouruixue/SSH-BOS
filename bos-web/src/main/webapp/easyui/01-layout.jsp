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
    <title>layout</title>
    <%--引入easyui--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>

</head>
<body class="easyui-layout">
    <%--使用div元素描述每个区域--%>
    <div title="XXX管理系统" style="height:100px;" data-options="region:'north'">北部区域</div>
    <div title="系统菜单" style="width:200px;" data-options="region:'west'">西部区域</div>
    <div data-options="region:'center'">中心区域</div>
    <div style="width:100px;" data-options="region:'east'">东部区域</div>
    <div style="height:50px;" data-options="region:'south'">南部区域</div>
</body>
</html>