﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>


</head>

<body style="background:url(images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="main.html" target="_parent"><img src="images/logo.png" title="系统首页" /></a>
    </div>
        
    <ul class="nav">
    <li><a href="deptAdd.html" target="rightFrame" class="selected"><img src="images/icon01.png" title="添加部门" /><h2>添加部门</h2></a></li>
    <li><a href="empAdd.html" target="rightFrame"><img src="images/icon02.png" title="添加员工" /><h2>添加员工</h2></a></li>
    <li><a href="empList.html"  target="rightFrame"><img src="images/icon03.png" title="员工管理" /><h2>员工管理</h2></a></li>
    <li><a href="expenseAdd.html"  target="rightFrame"><img src="images/icon04.png" title="添加报销" /><h2>添加报销</h2></a></li>
    <li><a href="dutyAdd.html" target="rightFrame"><img src="images/icon05.png" title="签到签退" /><h2>签到签退</h2></a></li>
    <li><a href="myInfo.html"  target="rightFrame"><img src="images/icon06.png" title="我的信息" /><h2>我的信息</h2></a></li>
    </ul>
            
    <div class="topright">    
    <ul>
    <li><span><img src="images/help.png" title="帮助"  class="helpimg"/></span><a href="tech.html" target="rightFrame">帮助</a></li>
    <li><a href="EmployeeController?method=loginOutEmp" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    	<span><a href="myInfo.html" target="rightFrame">${sessionScope.employee.realName}</a></span>

        <span><a href="myInfo.html" target="rightFrame">在线人数:${online}</a></span>

    </div>
    
    </div>

</body>
</html>
