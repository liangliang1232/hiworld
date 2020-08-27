<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.4.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <!-- 4. 引入 ECharts 文件 -->
    <script src="js/echarts.js"></script>
</head>
<script type="text/javascript">

    function getBar() {

        var url = "${pageContext.request.contextPath}/reportServlet";
        var mydiv = echarts.init(document.getElementById("main"));

        // 指定图表的配置项和数据
        $.ajax({
            url:url,
            dataType:"json",
            type:"post",
            success:function (json) {
                var pName = json.pName;
                var pProfit = json.pProfit;
                console.log(pName);
                console.log(pProfit);


                var option = {
                    title: {
                        text: "利润图表",
                        x:"center"
                    },
                    tooltip: {
                        show:true
                    },
                    xAxis: {
                        data:pName
                    },
                    yAxis: {},
                    series: [{
                        name: "金额",
                        type: "bar",
                        data:pProfit
                    }]
                }

                // 使用刚指定的配置项和数据显示图表。
                mydiv.setOption(option);
            }
        });
    }


</script>
<body>
<div class="text-right">
    <h3>
        <a href="${pageContext.request.contextPath}/loginOutServlet">注销</a>
    </h3>
</div>

    <div>
        <div id="main" class="col-md-4" style="width: 600px;height:400px;">
    </div>

<div class="col-md-12">
    <h3 style="text-align: center; ">商品报表</h3>
        <table border="1" class="table table-bordered table-hover" align="center">
            <tr class="success">
                <th>商品ID</th>
                <th>商品名称</th>
                <th>交易数量</th>
                <th>交易次数</th>
                <th>商品利润</th>

            </tr>
            <c:forEach items="${profits}" var="profit" >
                <tr>

                    <td><c:out value="${profit.goodsId}"></c:out></td>
                    <td><c:out value="${profit.goodsName}"></c:out></td>
                    <td><c:out value="${profit.tradingNumber}"></c:out></td>
                    <td><c:out value="${profit.times}"></c:out></td>
                    <td><c:out value="${profit.profit}"></c:out></td>
                </tr>

            </c:forEach>
        </table>

    <br>
        <div style="float: bottom;margin: 5px">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/findProductByPageServlet">商品管理</a>
            <a class="btn btn-primary" href="javascript:getBar();">柱状图</a>

        </div>

</div>

</body>
</html>