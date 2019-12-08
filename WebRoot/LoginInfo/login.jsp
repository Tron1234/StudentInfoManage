<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="LoginInfo/css/Login.css" />
<link href="LoginInfo/css/zzsc.css" type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/LoginInfo/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	window.onload = function() {
		var tx = document.getElementById("tx");
		var pwd = document.getElementById("pwd");

		tx.onfocus = function() {
			if (this.value != "密码")
				return;
			this.style.display = "none";
			pwd.style.display = "block";
			pwd.value = "";
			pwd.focus();
		};

		pwd.onblur = function() {
			if (this.value != "") {
				return;
			}
			this.style.display = "none";
			tx.style.display = "";
			tx.value = "密码";
		};
	};	//密码的输入动画

	$(function() {
		$(".nav p").click(function() {
			var ul = $(".new");
			if (ul.css("display") == "none") {
				ul.slideDown();
			} else {
				ul.slideUp();
			}
		});
		$(".set").click(function() {
			var _name = $(this).attr("name");
			if ($("[name=" + _name + "]").length > 1) {
				$("[name=" + _name + "]").removeClass("select");
				$(this).addClass("select");
			} else {
				if ($(this).hasClass("select")) {
					$(this).removeClass("select");
				} else {
					$(this).addClass("select");
				}
			}
		});
		$(".nav li").click(function() {
			var li = $(this).text();
			$(".nav p").html(li);
			$(".new").hide();
			/*$(".set").css({background:'none'});*/
			$("p").removeClass("select");
		});
	});
</script>
</head>


<body>
	<div id="login">
		<div id="T">
			<h1 id="h1">学生信息管理系统</h1>
		</div>
		<form method="post" action="loginmain" class="input">
			<input name="number" style="color: #737e73" type="text" value="学号"
				onblur="if(this.value==''){this.value='学号';}"
				onfocus="if(this.value='学号'){this.value='';this.style.color='#737e73';}"
				class="input"></input> <input type="text" id="tx"
				style="color: #737e73" class="input" value="密码"></input> <input
				name="password" type="password" id="pwd"
				style="color: #737e73;display: none" class="input"></input>
			<div class="nav" id="nav">
				<p class="set">----------请选择----------</p>
				<ul class="new" id="test">
					<li>学生</li>

					<li>教师</li>
				</ul>
			</div>
			<script type="text/javascript">
              $(document).ready(function () {
                     $('#test li').click(function () {
                        var zs = $(this).text();
                      $.ajax({
               	type:"POST",
               	url:"<%=request.getContextPath()%>/loginmian",
							data : {
								type : zs
							},
							success : function() {
							}

						});
						
					});
				});//选择人员的类别选择是用ul无序列表做的，所以只能使用Ajax语法来获得点击的人员类别
			</script>
			<input type="submit" name="submit" value="登录" id="but" />
		</form>
	</div>
</body>
</html>
