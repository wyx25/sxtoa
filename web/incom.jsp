<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/8/12
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>


    <script type="text/javascript" src="js/echarts.min.js"></script>

    <script type="text/javascript" src="js/jquery.js"></script>


</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 1000px;height:800px;"></div>
<script type="text/javascript">
    
    
    $.post("InComeController","method=inComeEa",function (data1) {

        //[["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"],[5, 20, 36, 10, 10, 20]]

        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: 'ECharts 入门示例'
            },
            tooltip: {},
            legend: {
                data:['销量']
            },
            xAxis: {
                data: data1[0]
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: data1[1]
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        
    },"json")
    
    

</script>

</body>
</html>
