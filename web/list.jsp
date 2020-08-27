<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品信息管理系统</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.4.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>

    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>

    <script>
        function deleteProduct(id) {
            //用户提示
            if (confirm("您确定要删除吗？")) {
                location.href = "${pageContext.request.contextPath}/deleteServlet?goodsId=" + id;
            }

        }

        window.onload = function () {
            //给删除选中按钮添加单击事件
            document.getElementById("delSelected").onclick = function () {

                if (confirm("您确定要删除选中条目吗？")) {
                    var flag = false;
                    //判断是否有选中条目
                    var cbs = document.getElementsByName("sid");
                    for (var i = 0; i < cbs.length; i++) {
                        if (cbs[i].checked) {
                            //有一个条目被选中
                            flag = true;
                            break;
                        }
                    }
                    //有条目被选中
                    if (flag) {
                        //表单提交
                        document.getElementById("form").submit();
                    }

                }

            }
                document.getElementById("checkbox1").onclick = function () {
                    //获取所有checkbox
                    var cbs = document.getElementsByName("sid");
                    //遍历
                    for (var i = 0; i < cbs.length; i++) {
                        //设置这些cbs[i]的checked状态 = checkbox1.checked
                        cbs[i].checked = this.checked;
                    }
                }

            }

    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">商品信息列表</h3>
    <div style="float: left">
        <form class="form-inline" action="${pageContext.request.contextPath}/findProductByPageServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName2">商品名称</label>
                <input type="text" name="goodsName" value="${condition.goodsName[0]}" class="form-control" id="exampleInputName1" >
            </div>
            <div class="form-group">
                <label for="exampleInputName2">销售价</label>
                <input type="text" name="sellPrice" value="${condition.sellPrice[0]}" class="form-control" id="exampleInputName2" >
            </div>

            <button style="background-color: #337AB7" type="submit" class="btn btn-default" >查询</button>
        </form>
    </div>

    <div style="float: right;margin: 5px">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加商品</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除商品</a>
    </div>

    <form id="form" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="checkbox1"></th>
                <th>编号</th>
                <th>商品名称</th>
                <th>成本价</th>
                <th>销售价</th>
                <th>厂商</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${pb.list}" var="product" varStatus="s">
                <tr>
                    <th><input type="checkbox" name="sid" value="${product.goodsId}"></th>
                    <td>${s.count}</td>
                    <td>${product.goodsName}</td>
                    <td>${product.costPrice}</td>
                    <td>${product.sellPrice}</td>
                    <td>${product.manufacturer}</td>
                    <td><a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/findProductServlet?goodsId=${product.goodsId}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:deleteProduct(${product.goodsId});">删除</a>
                    </td>
                </tr>

            </c:forEach>


        </table>
    </form>


    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li class="disabled">
                    <a href="${pageContext.request.contextPath}/findProductByPageServlet?currentPage=${pb.currentPage - 1}&rows=5"
                       aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>

                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <%--激活分页状态  active--%>
                    <c:if test="${pb.currentPage == i}">
                        <li class="active">
                            <a href="${pageContext.request.contextPath}/findProductByPageServlet?currentPage=${i}&rows=5">${i}</a>
                        </li>
                    </c:if>

                    <c:if test="${pb.currentPage != i}">
                        <li>
                            <a href="${pageContext.request.contextPath}/findProductByPageServlet?currentPage=${i}&rows=5">${i}</a>
                        </li>
                    </c:if>

                </c:forEach>

                <li class="disabled">
                    <a href="${pageContext.request.contextPath}/findProductByPageServlet?currentPage=${pb.currentPage + 1}&rows=5"
                       aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px; margin-left: 15px">
                共${pb.totalCount}条记录，共${pb.totalPage}页
            </span>
            </ul>
        </nav>
    </div>
    <div style="float: right"><a class="btn btn-primary" href="${pageContext.request.contextPath}/findProfitServlet" id="exit">退出</a></div>

</div>
</body>
</html>
