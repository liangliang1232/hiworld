<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.4.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>


</head>
<body>
<div class="container">
    <center><h3>添加商品界面</h3></center>
    <form action="${pageContext.request.contextPath}/addServlet" method="post">
        <div class="form-group">
            <label for="goodsName">商品名称：</label>
            <input type="text" class="form-control" id="goodsName" name="goodsName" placeholder="">
        </div>

        <div class="form-group">
            <label for="costPrice">成本价：</label>
            <input type="text" class="form-control" id="costPrice" name="costPrice" placeholder="">
        </div>

        <div class="form-group">
            <label for="sellPrice">销售价：</label>
            <input type="text" class="form-control" id="sellPrice" name="sellPrice" placeholder="">
        </div>

        <div class="form-group">
            <label for="manufacturer">生产商：</label>
            <input type="text" class="form-control" id="manufacturer" name="manufacturer" placeholder="">
        </div>



        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="添加" />
            <input class="btn btn-default" type="button" value="返回" />
        </div>
    </form>
</div>
</body>
</html>