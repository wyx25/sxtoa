<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>


    <%
       Object  obj= session.getAttribute("employee");

       if(obj==null){

           response.sendRedirect("/sxtoa/login.jsp");
           return;
       }


    %>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">人事管理</a></li>
    <li><a href="#">修改部门信息</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>

    <form action="DeptController?method=changeDept" method="post">
    <ul class="forminfo">
    <li><label>部门编号</label><input name="deptno" type="text" class="dfinput" readonly value="${dept.deptno}"/>${msg} </li>
    <li><label>部门名称</label><input name="deptname" type="text" class="dfinput"  value="${dept.deptname}"/></li>
    <li><label>办公地点</label><input name="location" type="text" class="dfinput" value="${dept.location}"/></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    
    </div>


</body>

</html>
