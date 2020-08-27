<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="utf-8">
    <title>login UI</title>
    <link type="text/css" rel="stylesheet" href="css/Login.css">
    <script src="js/jquery-3.4.1.min.js"></script>
    <style>
        body{
            margin:0;
            padding: 0;
            font-family: sans-serif;
            background-image: url("img/login1.png");
            background-size: cover;
        }

    </style>
</head>
<body>
<div class="box">
    <h2>商品系统登录</h2>
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <div class="inputBox">
            <input type="text" name="username" required="">
            <label>用户名</label>
        </div>
        <div class="inputBox">
            <input type="password" name="password" required="">
            <label>密码</label>
        </div>
        <input type="submit" name="" value="登录">
    </form>


    <!-- 出错显示的信息框 -->
    <div class="alert alert-warning alert-dismissible" role="alert">
            <span style="color: white">&times;</span>
        <strong style="color: white">${login_msg}</strong>
    </div>
</div>
</body>
</html>