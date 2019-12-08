<%@page import="department.DepartmentPO"%>
<%@page import="student.StudentPO"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>学生信息管理系统</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="AdminInfo/assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="AdminInfo/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="AdminInfo/assets/css/amazeui.min.css" />
<link rel="stylesheet" href="AdminInfo/assets/css/admin.css">
<script
	src="<%=request.getContextPath()%>/AdminInfo/assets/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/AdminInfo/assets/js/app.js"></script>
</head>
<body>
	<!--[if lte IE 9]><p class="browsehappy">升级你的浏览器吧！ <a href="http://se.360.cn/" target="_blank">升级浏览器</a>以获得更好的体验！</p><![endif]-->
</head>

<body>
	<header class="am-topbar admin-header">
		<div class="am-topbar-brand">
			<img src="<%=request.getContextPath()%>/AdminInfo/assets/i/logo.png">
		</div>

		<div class="am-collapse am-topbar-collapse" id="topbar-collapse">
			<ul class="am-nav am-nav-pills am-topbar-nav admin-header-list">

				<li class="am-dropdown tognzhi" data-am-dropdown></li>
				<li class="am-hide-sm-only" style="float: right;"><a
					href="javascript:;" id="admin-fullscreen"><span
						class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span>
				</a>
				</li>
			</ul>
		</div>
	</header>

	<div class="am-cf admin-main">

		<div class="nav-navicon admin-main admin-sidebar">


			<div class="sideMenu am-icon-dashboard"
				style="color:#aeb2b7; margin: 10px 0 0 0;">
				欢迎<%=application.getAttribute("type")%>：<%=application.getAttribute("name")%></div>
			<div class="sideMenu">
				<h3 class="am-icon-flag">
					<em></em>学生信息管理
				</h3>
				<ul>
					<li><a href="studentcheck">学生信息查询</a></li>
					<li><a href="studentadd_jump">学生信息添加</a></li>
					<li><a href="studentchoose1">学生信息修改</a></li>
					<li><a href="studentchoose2">学生信息删除</a></li>
				</ul>
				<h3 class="am-icon-users">
					<em></em>部门信息管理
				</h3>
				<ul>
					<li><a href="departmentcheck">部门信息查询</a></li>
					<li><a href="departmentadd_jump">部门信息添加</a></li>
					<li><a href="departmentchoose1">部门信息修改</a></li>
					<li><a href="departmentchoose2">部门信息删除</a></li>
				</ul>
				<h3 class="am-icon-gears">
					<em></em>系统设置
				</h3>
				<ul>
					<li><a href="adminupdatecheck">教师信息修改</a></li>
					<li><a href="adminadd_jump">教师信息添加</a></li>
					<li><a href="exitsystem">退出系统</a></li>
				</ul>
			</div>
			<!-- sideMenu End -->

			<script type="text/javascript">
				jQuery(".sideMenu").slide({
					titCell : "h3", //鼠标触发对象
					targetCell : "ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
					effect : "slideDown", //targetCell下拉效果
					delayTime : 300, //效果时间
					triggerTime : 150, //鼠标延迟触发时间（默认150）
					defaultPlay : true,//默认是否执行效果（默认true）
					returnDefault : true
				//鼠标从.sideMen移走后返回默认状态（默认false）
				});
			</script>
		</div>



		<div class="admin">

			<div class="admin-biaoge">
				<div class="xinxitj">学生信息修改</div>
				<form action="studentupdate" method="post">
				<table class="am-table">
				<% List list=(List)session.getAttribute("allinfo");
					StudentPO student=(StudentPO)list.get(0);
				%>
						<tr>
							<th>学生姓名:</th>
							<td><input type="text" name="name" style="width: 400px;float: left;" value="<%=student.getName()%>"></td>
						</tr>
						<tr>
							<th>学生密码:</th>
							<td><input type="text" name="password" style="width: 400px;float: left;" value="<%=student.getPassword()%>"></td>
						</tr>
						<tr>
							<th>学生年龄:</th>
							<td><input type="number" name="age" style="width: 400px;float: left;" value="<%=student.getAge()%>"></td>
						</tr>
						<tr>
							<th>学生性别:</th>
							<td><input type="text" name="sex" style="width: 400px;float: left;" value="<%=student.getSex()%>"></td>
						</tr>
						<tr>
							<th>学生电话:</th>
							<td><input type="text" name="phone" style="width: 400px;float: left;" value="<%=student.getPhone()%>"></td>
						</tr>
						<tr>
							<th>学生部门:</th>
							<td><select name="department" style="width: 400px;margin-bottom: 10px;float: left">
				<%
    		List list1=(List)session.getAttribute("allinfo1");
    		if(list1==null){
    	 %>
    	 	<option value="">无部门信息</option>
    	 <%}else{
    		for(int i=0;i<list1.size();i++){
    			DepartmentPO department=(DepartmentPO)list1.get(i);
    	 %>
				<option value="<%=department.getName()%>" ><%=department.getName()%></option>
				<%}
    	} %>	
				</select></td>
						</tr>
						<tr>
						<td><input type="submit" value="提交" style="width: 80px"></td>
						<td><input type="reset" value="取消" style="width: 80px"></td>
						</tr>
				</table>
				</form>
			</div>
		</div>
	</div>

	<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/polyfill/rem.min.js"></script>
<script src="assets/js/polyfill/respond.min.js"></script>
<script src="assets/js/amazeui.legacy.js"></script>
<![endif]-->

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script
		src="<%=request.getContextPath()%>/AdminInfo/assets/js/amazeui.min.js"></script>
	<!--<![endif]-->



</body>
</html>