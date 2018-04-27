<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title></title>
  <link rel="stylesheet" href="../css/layui.css">
</head>
<body style="align-content: center">
    <div style="margin: 0 auto; font-size: 30px;font-family: Microsoft YaHei UI; text-align: center">
        欢迎使用图书管理系统-Online
    </div>
    </br></br></br></br></br></br></br>
    <div style="margin: 0 auto;width:400px;height:400px;text-align:center;font-size:22px;font-weight:bold;">
    	未找到！
    	<a href="AlterBook.jsp">返回</a>
    </div>
<script src="../layui.js"></script>

</body>
</html>
