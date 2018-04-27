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
        <title>登录到图书管理系统</title>
        <link rel="stylesheet" href="css/layui.css">
      </head>
  
  <body>
   <br/><br/><br/>
    <div  style="margin: 0 auto; width: 500px;height: 700px;box-shadow:4px 4px 10px 0px #009688;" >
    </br></br></br></br>
        <div style="text-align: center">
            <div class="layui-logo"  style="font-size: 24px;color: #009688"><i class="layui-icon"  style="font-size: 30px;">&#xe705;</i> 图书管理系统</div>
        </div></br></br></br>
        <form class="layui-form" action="Login.do" method="post">
            <div class="layui-form-item">
                <label class="layui-form-label">用户名</label>
                    <div class="layui-input-block">
                        <input type="text" name="UserName" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input" style="width: 250px;">
                    </div>
            </div></br>
            
            <div class="layui-form-item">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-inline">
                    <input type="password" name="UserPwd" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" style="width: 250px;">
                </div>
                <div class="layui-form-mid layui-word-aux">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注意大小写</div>
            </div></br>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo" style="width: 250px;">登录</button>
                </div>
            </div>
        </form>
    </br></br></br>
        <div style="text-align: right">
        <a href="Register.jsp" style="font-size: 12px">没有账号？立即注册&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
        </div>
    </div>
<script src="layui.js"></script>
</body>
</html>