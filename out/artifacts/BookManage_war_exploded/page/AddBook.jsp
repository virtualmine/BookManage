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
<body>
    <div style="height: 150px; margin: 0 auto; font-size: 30px;font-family: Microsoft YaHei UI; text-align: center">
        欢迎使用图书管理系统-Online
    </div>
    <div  style="margin: 0 auto; width: 400px;height: 700px;" >
    <form class="layui-form" action="AddBook.da" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">图书ID</label>
            <div class="layui-input-block">
                <input type="text" name="BookID" required  lay-verify="required" placeholder="请输入图书ID" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">书名</label>
            <div class="layui-input-block">
                <input type="text" name="BookName" required  lay-verify="required" placeholder="请输入图书名" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
                <label class="layui-form-label">图书类型</label>
                <div class="layui-input-block">
                        <select name="BookType" lay-verify="required">
                            <option value=""></option>
                            <option value="计算机">计算机</option>
                            <option value="外语">外语</option>
                            <option value="文学">文学</option>
                            <option value="艺术">艺术</option>
                            <option value="经管">经管</option>
                            <option value="人文社科">人文社科</option>
                            <option value="少儿">少儿</option>
                            <option value="生活">生活</option>
                            <option value="科技">科技</option>
                            <option value="考试">考试</option>
                            <option value="其他">其他</option>
                        </select>
                    </div>
            </div>

        <div class="layui-form-item">
            <label class="layui-form-label">作者</label>
            <div class="layui-input-block">
                <input type="text" name="Author" required  lay-verify="required" placeholder="请输入图书作者" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">价格</label>
            <div class="layui-input-block">
                <input type="text" name="Price" required  lay-verify="required" placeholder="请输入价格" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <textarea name="Remark" placeholder="请输入备注字段" class="layui-textarea"></textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">添加</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
      </form>

       </div>
      <script src="../layui.all.js"></script>
      
</body>
</html>
</html>
