<%@page import="ent.User"%>
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
  <link rel="stylesheet" href="css/layui.css">
  <style type="text/css">
  .btl{
  box-shadow:4px 4px 10px 0px #FF5722;width: 150px;height: 150px;
  }
  }
  </style>
</head>
<body>
	<div style="margin: 0 auto; font-size: 30px;font-family: Microsoft YaHei UI; text-align: center">
        欢迎使用图书管理系统-Online
    </div></br></br></br>
<%List<User> users=(ArrayList)request.getAttribute("userslist");%>
	<div style="margin: 0 auto; width: 1000px;">
	<div class="layui-btn-container" style="width: 1200px;">
  <%for(int i = 0; i < users.size(); i++){%>
  		<button class="layui-btn btl layui-btn-radius" onclick="location.href='DeleteU.do?dltu=<%=users.get(i).getUserName() %>'" type="button">
  		
        <%out.println("账:"+users.get(i).getUserName()+"</br>");%>
        
        <%out.println("密:"+users.get(i).getUserPwd()+"</br>");%>
        <i class="layui-icon" style="font-size: 36px; color: red;">&#xe640;</i> 
        </button>
  <%}
 %>
 </div>
 </div>
<script src="layui.js"></script>
</body>
</html>
