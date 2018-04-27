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
  <title>注册用户</title>
  <link rel="stylesheet" href="css/layui.css">
</head>
<body>
    </br></br></br>
    <div  style="margin: 0 auto; width: 500px;height: 700px;box-shadow:4px 4px 10px 0px #009688;" >
    </br></br></br></br>
        <div style="text-align: center">
            <div class="layui-logo"  style="font-size: 24px;color: #009688"><i class="layui-icon"  style="font-size: 30px;">&#xe705;</i> 图书管理系统</div>
        </div></br></br></br>
        <form class="layui-form" action="Register.do" method="post">
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
                <label class="layui-form-label">身份</label>
                <div class="layui-input-block">
                    <input type="radio" name="Identity" value="管理员" title="管理员">
                    <input type="radio" name="Identity" value="用户" title="用户" checked>
                    <label style="font-size: 10px;color: grey;">暂不可用</label>
                </div>
            </div></br>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo" style="width: 250px;">注册</button>
                </div>
            </div>
        </form>
    </br></br></br>
        <div style="text-align: right">
        <a href="Login.jsp" style="font-size: 12px">已有账号？立即登录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
        </div>
    </div>
<script src="layui.all.js"></script>
</body>
</html>