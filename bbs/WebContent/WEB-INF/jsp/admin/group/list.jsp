<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/media/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/media/css/style.css" rel="stylesheet" />

<style type="text/css">
body {
	padding: 30px;
}
</style>

</head>
<body>
	<h3 class="page-title">
		用户组管理 <small>用户组列表</small>
	</h3>
	<ul class="breadcrumb">
		<li><i class="icon-home"></i> <a href="javascript:;">后台管理</a> <i
			class="icon-angle-right"></i></li>
		<li><a href="${pageContext.request.contextPath}/admin/group/list">用户组管理</a></li>
	</ul>
	<!-- END PAGE TITLE & BREADCRUMB-->
	</div>
	</div>

	<table class="table table-bordered table-hover definewidth m10"
		id="sample_1" >
		<thead style="text-align:center;">
			<tr>
				<th>用户组名</th>	
				<th class="hidden-480">操作</th>
			</tr>
		</thead>
		<tbody>
		

         <c:forEach items="${page.content}" var="group">  
	
			<tr class="odd gradeX" >
				<td class="hidden-480">${group.name}</td>
			
				<td><a href="update?id=${group.id }" class="btn mini purple"><i
						class="icon-edit"></i> 权限管理</a></td>
			</tr>
			</c:forEach> 
			<tr>
				<td colspan="5">
				<%@ include file="/WEB-INF/jsp/common/pageView.jspf"%>
				</td>
			</tr>
		</tbody>
	</table>
</body>
<script src="${pageContext.request.contextPath}/media/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/media/js/bootstrap.min.js"></script>
</html>
