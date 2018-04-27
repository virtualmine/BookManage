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
  <title>图书管理系统-Online</title>
  <link rel="stylesheet" href="css/layui.css">
</head>
<body class="layui-layout-body">



<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo"  style="font-size: 24px;"><i class="layui-icon"  style="font-size: 30px;">&#xe705;</i> 图书管理系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          <%=request.getAttribute("uname") %>
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="">注销</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">图书管理</a>
          <dl class="layui-nav-child">
            <dd><div class="P_1"><a href="bookshow.da" target="showList">查看库存图书</a></div></dd>
            <dd><div class="a_1"><a href="./page/AddBook.jsp" target="showList">增加图书库存</a></div></dd>
            <dd><div class="a_2"><a href="bookalterbefore.da" target="showList">修改图书信息</a></div></dd>
            <dd><div class="a_3"><a href="bookdeletebefore.da" target="showList">删除库存图书</a></div></dd>
            <dd><div class="u_1"><a href="borrowbook.da?borrower=<%=request.getAttribute("uname")%>" target="showList">书籍借阅</a></div></dd>
            <dd><div class="u_2"><a href="showborrowedbook.da?borrower=<%=request.getAttribute("uname")%>" target="showList">已借书籍</a></div></dd>
            <dd><div class="u_3"><a href="deleteborrowedbook.da?borrower=<%=request.getAttribute("uname")%>" target="showList">书籍归还</a></div></dd>
          </dl>
        </li>
        <!-- 仅登录用户为管理员时可用-->
        <li class="layui-nav-item">
          <a href="javascript:;">用户管理</a>
          <dl class="layui-nav-child">
            <dd><div class="a_a"><a href="DeleteUsers.do" target="showList">删除用户</a></div></dd>
            <dd><a href="javascript:;" target="showList">待增加功能</a></dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <iframe src="page/Welcome.html" frameborder="0" width="100%" height="100%" name="showList" scrolling="yes" ></iframe>

  </div>
  
  <div class="layui-footer" style="text-align: center">
    <!-- 底部固定区域 -->
    <P>©designed by mine,2018-04</P>
  </div>
</div>
<script src="layui.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>

<script>
	var uname="<%=request.getAttribute("uname")%>";
	if(uname=="钟远东"){
		$(".u_1").hide();
		$(".u_2").hide();
		$(".u_3").hide();
	}
	else if(uname==null){}
	else{
		$(".a_1").hide();
		$(".a_2").hide();
		$(".a_3").hide();
		$(".a_a").hide();
	}
	
</script>
</body>
</html>
