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
        <title>图书信息修改查询</title>
        <link rel="stylesheet" href="css/layui.css">
      </head>
  
  <body>
  <% Books b=(Books)request.getAttribute("booksinfo"); 
  
  %>
  	<div style="margin: 0 auto; font-size: 30px;font-family: Microsoft YaHei UI; text-align: center">
        欢迎使用图书管理系统-Online
    </div></br></br></br>
    <div style="margin: 0 auto; width: 500px;height: 700px;box-shadow:4px 4px 10px 0px #009688;">
    <table width="500"  border="0">
        <tr height="100" style="text-align:center">
            <td colspan="5" style="font-size: 28px;font-weight: bold">书籍详情</td>
          </tr>
          <tr height="70" style="text-align:center">
              <td colspan="5" style="font-size: 22px;font-weight: bold"><%out.print(b.getBookName()); %></td>
          </tr>
          <tr height="70" style="text-align:center">
              <td colspan="5"><%out.print(b.getAuthor()); %>&nbsp;著</td>
          </tr>
      <tr height="80">
        <td width="30"></td>
        <td style="text-align:right" width="100">类型</td>
        <td width="30"></td>
        <td style="text-align:left"><%out.print(b.getBookType()); %></td>
        <td width="30"></td>
      </tr>
      <tr height="160">
        <td width="30"></td>
        <td style="text-align:right" width="100">备注</td>
        <td width="30"></td>
        <td style="text-align:left"><%out.print(b.getRemark()); %></td>
        <td width="30"></td>
      </tr>
      <tr height="80" style="text-align:right">
        <td colspan="4">价格：<%out.print(b.getPrice()); %>元</td>
      </tr>
      <tr height="120" style="text-align:center">
          <td colspan="5">
              <button class="layui-btn" onclick="location.href='showborrowedbook.da?borrower=<%=request.getAttribute("borrower")%>'"><i class="layui-icon">&#xe65c;</i>&nbsp;返回</button>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <button class="layui-btn"><i class="layui-icon">&#xe705;</i>&nbsp;阅读</button>
          </td>
        </tr>
    </table>
    </div>
    <script src="layui.js"></script>
  </body>
</html>

