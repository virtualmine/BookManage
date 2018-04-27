
<%@page import="ent.Books"%>
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
  box-shadow:4px 4px 10px 0px #009688;width: 150px;height: 200px;
  }
  .title_type{
  	background:yellow;width:150px;height:100px;position: relative;left: -18px; color:black;
  }
  </style>
</head>
<body>
<div style="margin: 0 auto; font-size: 30px;font-family: Microsoft YaHei UI; text-align: center">
        欢迎使用图书管理系统-Online
    </div></br></br></br>
<%List<Books> books=(ArrayList)request.getAttribute("bookslist");%>
	<div style="margin: 0 auto; width: 1000px;">
	<div class="layui-btn-container" style="width: 1200px;">
  <%for(int i = 0; i < books.size(); i++){%>
  		<button class="layui-btn btl"  onclick="location.href='Detail.da?DetailBookName=<%=books.get(i).getBookName() %>'" type="button">
  		<div class="title_type">
        <%out.println(books.get(i).getBookName());%>
        </div>
        <%out.println(books.get(i).getAuthor()+" 著"+"</br>");%>
        
        <%out.print("价格："+books.get(i).getPrice()+"元"); %> 
        </button>
  <%}
 %>
 </div>
 </div>
<script src="layui.js"></script>
</body>
</html>