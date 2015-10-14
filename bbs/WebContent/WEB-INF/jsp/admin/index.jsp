<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>demo</title>
<link href="${pageContext.request.contextPath}/media/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="${pageContext.request.contextPath}/media/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/media/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$(".div2").click(
						function() {
							$(this).next("div").slideToggle("slow").siblings(
									".div3:visible").slideUp("slow");
						});
			});
</script>
<style>
body {
	margin: 0;
	font-family: 微软雅黑;
}

.left {
	width: 180px;
	height: 100%;
	border-right: 1px solid #ccc;
	color: #000000;
	font-size: 14px;
	text-align: center;
	margin-top: -20px;
	float: left;
}

.sidebar-title {
	text-align: center;
	border-bottom: #ccc 1px solid;
	padding-top: 10px;
}

.sidebar-title h2 {
	font-weight: normal;
	text-align: center;
}

.div1 {
	text-align: center;
	width: 180px;
}

.div2 {
	height: 40px;
	line-height: 40px;
	cursor: pointer;
	font-size: 16px;
	position: relative;
	border-bottom: #ccc 1px solid;
}

.div2:hover {
	background: #fff;
	color: #1963AA;
	border-right: #ccc 1px solid;
}

.div3 {
	display: none;
	cursor: pointer;
	font-size: 13px;
}

.div3 ul {
	margin: 0;
	padding: 0;
}

.div3 li {
	height: 30px;
	line-height: 30px;
	list-style: none;
	border-bottom: #ccc 1px solid;
	border-right: #ccc 1px solid;
	padding-left: 21px;
	background: #f2f2f2;
	color: #333;
}

.div3 li:hover {
	background: #fff;
	color: #1963AA;
	border-right: #ccc 1px solid;
}

.div3 li a {
	text-decoration: none;
	color: #333;
}

.div3 li a:hover {
	background: #fff;
	color: #1963AA;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse " role="navigation"
		style="padding: 0px 20px">
		<div class="navbar-header">
			<a class="navbar-brand" href="#" style="font-size: 20px">XX管理后台</a>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown"><a href="#" class="dropdown-toggle "
				data-toggle="dropdown"> <span class="glyphicon glyphicon-user"></span>
					管理员 <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a href="#"><span class="glyphicon glyphicon-cog"></span>
							修改密码</a></li>
					<li class="divider"></li>
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
							个人中心</a></li>
					<li class="divider"></li>
					<li><a href="#"> <span class="glyphicon glyphicon-log-out"
							aria-hidden="true"></span> 注销
					</a></li>
					<li class="divider"></li>
					<li><a href="#">另一个分离的链接</a></li>
				</ul></li>
		</ul>
	</nav>
	<table id="frametable" cellpadding="0" cellspacing="0" width="100%"
		height="100%" style="width: 100%;">
		<tbody>
			<tr>
				<td valign="top" width="180px" height="100%">
					<!--这个高度很重要-->
					<div class="left">
						<div class="sidebar-title">
							<h2>菜单</h2>
						</div>
						<div class="div1">
							<div class="div2">
							用户管理
							</div>
							<div class="div3">
								<ul>
									<li><a href="${pageContext.request.contextPath}/admin/user/list"
										target="content">用户管理</a></li>
									<li><a href="${pageContext.request.contextPath}/admin/group/list"
										target="content">用户组管理</a></li>
								</ul>
							</div>
							<div class="div2">
								<div class="xwzx"></div>
								新闻中心
							</div>
							<div class="div3">
								<ul>
									<li>管理文章</li>
									<li>文章分类</li>
									<li>添加文章</li>
								</ul>
							</div>
							<div class="div2">
								<div class="zxcp"></div>
								最新产品
							</div>
							<div class="div3">
								<ul>
									<li>图片管理</li>
									<li>图片分类</li>
									<li>添加图片</li>
								</ul>
							</div>
							<div class="div2">
								<div class="lmtj"></div>
								栏目添加
							</div>
							<div class="div3">
								<ul>
									<li>文章系统</li>
									<li>图片系统</li>
									<li>添加表单</li>
									<li>招聘系统</li>
								</ul>
							</div>
						</div>
					</div>
				</td>
				<td valign="top" width="100%" height="100%">
					<!--这个高度很重要--> <iframe id="iframe" name="content" src=""
						width="100%" allowtransparency="true" height="100%"
						frameborder="0" scrolling="yes"></iframe>
				</td>
			</tr>
		</tbody>
	</table>

</body>
</html>