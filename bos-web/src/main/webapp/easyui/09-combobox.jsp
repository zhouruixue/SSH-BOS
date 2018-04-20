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
    <title>ocupload</title>
</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.ocupload-1.1.2.js"></script>


<body>
    <input data-options="url:'${pageContext.request.contextPath }/json/combobox_data.json',
    valueField:'id',
    textFiled:'name'"
           class="easyui-combobox">
</body>
</html>
