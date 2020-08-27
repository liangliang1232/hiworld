<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改商品</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.4.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改商品信息</h3>
    <form action="${pageContext.request.contextPath}/updateProductServlet" method="post">
        <%--隐藏域提交id--%>
        <input type="hidden" name="goodsId" value="${product.goodsId}">

        <div class="form-group">
            <label for="goodsName">商品名称：</label>
            <input type="text" class="form-control" id="goodsName" name="goodsName" value="${product.goodsName}"  placeholder="请输入商品名称"/>
        </div>
        <div class="form-group">
            <label for="costPrice">成本价：</label>
            <input type="text" class="form-control" id="costPrice" name="costPrice" value="${product.costPrice}"  placeholder="请输入成本价"/>
        </div>
        <div class="form-group">
            <label for="sellPrice">销售价：</label>
            <input type="text" class="form-control" id="sellPrice" name="sellPrice" value="${product.sellPrice}"  placeholder="请输入销售价"/>
        </div>
        <div class="form-group">
            <label for="manufacturer">生产商：</label>
            <input type="text" class="form-control" id="manufacturer" name="manufacturer" value="${product.manufacturer}"  placeholder="请输入生产商"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>