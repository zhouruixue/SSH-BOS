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
    <title>Title</title>
</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
    $(function () {
        //alert方法--提示框
        //$.messager.alert("标题","内容","error");

        //confirm方法-- 确认框
        /**$.messager.confirm("提示信息","你确定要删除当前记录吗？",function (r) {
            alert(r);
        })**/

        $.messager.show({
            title:'欢迎信息',
            msg:'欢迎【admin】登录系统',
            timeout:5000,
            showType:'slide'
        });

    });
</script>



<body>

</body>
</html>
