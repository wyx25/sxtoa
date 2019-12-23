<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>审核报销单</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript">
			function submitForm(){
				window.close();
				
			}

			$(function () {

			    $("#but").click(function () {

			        //发送ajax请求提交单表

					//【1】获得表单数据
					var   val=$("form").serialize();

					alert(val);
					$.post("AuditingController?method=saveAuditing",val,function (data1) {

					    //关闭当前的窗口
					    window.close();

					    //刷新加载父页面
					    window.opener.location.reload();


						
                    })


                })

            })
			
		</script>
	</head>

	<body>

		<div class="formtitle"><span>审核报销单</span></div>
		<form action="#" >
			<ul class="forminfo">

				<li>
					<label>报销单ID</label>
					<%--http://localhost:8888/sxtoa/audit.jsp?a=123--%>
					<%--<input name="" type="text" class="dfinput" value="<%=request.getParameter("a")%>" />
--%>
					<input name="expId" type="text" class="dfinput" value="${param.a}" />
					<%--${a}
					<%=request.getAttribute("a") %>--%>

					<input type="text" name="totalAmount" value="${param.b}">

				</li>
				<li>
					<label>审核结果</label>
					<input name="result" type="radio" value="2" />通过
					<input name="result" type="radio" value="3" />拒绝
					<input name="result" type="radio" value="4"/>打回
				</li>
				<li>
					<label>审核意见</label>
					<input name="auditDesc" type="text" class="dfinput" />
				</li>
				<li>
					<label>&nbsp;</label>
					<input name="" type="button" id="but" class="btn" value="确认保存" />
				</li>
			</ul>
		</form>
	</body>

</html>