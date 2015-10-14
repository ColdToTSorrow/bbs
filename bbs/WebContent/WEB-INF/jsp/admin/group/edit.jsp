<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="UTF-8">
<link
	href="${pageContext.request.contextPath}/media/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/media/css/style.css"
	rel="stylesheet" />

<style type="text/css">
body {
	padding: 30px;
}
</style>

</head>
<body>
	<h3 class="page-title">
		用户组管理 <small>用户组权限管理</small>
	</h3>
	<ul class="breadcrumb">
		<li><i class="icon-home"></i> <a href="javascript:;">后台管理</a> <i
			class="icon-angle-right"></i></li>
		<li><a href="${pageContext.request.contextPath}/admin/group/list">用户组管理</a></li>
	</ul>
	<!-- END PAGE TITLE & BREADCRUMB-->
	</div>
	</div>
	
<form action="${pageContext.request.contextPath}/admin/group/update" method="post" class="definewidth m20">

<input type="hidden" name="id" value="${id }" />
<table class="table table-bordered table-hover definewidth m10">
	<thead>
	<tr><th colspan="2">基本权限</th></tr>
	</thead>
    
    <tr>
        <td  width="20%" class="tableleft" >允许查看会员列表:</td>
        <td>
               <input type="checkbox" name="permissions" value="A" <c:if test="${fn:contains(permissionStr,'A')}">checked</c:if>/> 启用
        </td>
    </tr>
    <tr>
        <td  width="20%" class="tableleft" >允许查看用户信息:</td>
        <td>
               <input type="checkbox" name="permissions" value="B" <c:if test="${fn:contains(permissionStr,'B')}">checked</c:if>/> 启用
        </td>
    </tr>
    <tr>
        <td  width="20%" class="tableleft" >查看统计数据:</td>
        <td>
               <input type="checkbox" name="permissions" value="C" <c:if test="${fn:contains(permissionStr,'C')}">checked</c:if>/> 启用
        </td>
    </tr>
    <tr>
        <td  width="20%" class="tableleft" >允许上传头像:</td>
        <td>
               <input type="checkbox" name="permissions" value="D" <c:if test="${fn:contains(permissionStr,'D')}">checked</c:if>/> 启用
        </td>
    </tr>
    </table>
    
    
    <table class="table table-bordered table-hover definewidth m10">
	<thead>
	<tr><th colspan="2">主题相关</th></tr>
	</thead>
	
	<tr>
        <td  width="20%" class="tableleft" >允许浏览主题:</td>
        <td>
               <input type="checkbox" name="permissions" value="E" <c:if test="${fn:contains(permissionStr,'E')}">checked</c:if>/> 启用
        </td>
    </tr>
    
    <tr>
        <td  width="20%" class="tableleft" >允许发新主题:</td>
        <td>
               <input type="checkbox" name="permissions" value="F" <c:if test="${fn:contains(permissionStr,'F')}">checked</c:if>/> 启用
        </td>
    </tr>
       <tr>
        <td  width="20%" class="tableleft" >允许回复主题:</td>
        <td>
               <input type="checkbox" name="permissions" value="G" <c:if test="${fn:contains(permissionStr,'G')}">checked</c:if>/> 启用
        </td>
    </tr>
    
    <tr>
        <td  width="20%" class="tableleft" >允许举报帖子:</td>
        <td>
               <input type="checkbox" name="permissions" value="H" <c:if test="${fn:contains(permissionStr,'H')}">checked</c:if>/> 启用
        </td>
    </tr>
    
     
     <tr>
        <td  width="20%" class="tableleft" >允许下载/查看附件:</td>
        <td>
               <input type="checkbox" name="permissions" value="I" <c:if test="${fn:contains(permissionStr,'I')}">checked</c:if>/> 启用
        </td>
    </tr>
     <tr>
        <td  width="20%" class="tableleft" >允许上传附件:</td>
        <td>
               <input type="checkbox" name="permissions" value="J" <c:if test="${fn:contains(permissionStr,'J')}">checked</c:if>/> 启用
        </td>
    </tr>
    
 
    </table>
    
    
     <table class="table table-bordered table-hover definewidth m10">
	<thead>
	<tr><th colspan="2">管理相关</th></tr>
	</thead>
	<tr>
        <td  width="20%" class="tableleft" >置顶帖子:</td>
        <td>
               <input type="checkbox" name="permissions" value="K" <c:if test="${fn:contains(permissionStr,'K')}">checked</c:if>/> 启用
        </td>
    </tr>
    
    <tr>
        <td  width="20%" class="tableleft" >允许编辑帖子:</td>
        <td>
               <input type="checkbox" name="permissions" value="L" <c:if test="${fn:contains(permissionStr,'L')}">checked</c:if>/> 启用
        </td>
    </tr>
       <tr>
        <td  width="20%" class="tableleft" >允许删除帖子:</td>
        <td>
               <input type="checkbox" name="permissions" value="M" <c:if test="${fn:contains(permissionStr,'M')}">checked</c:if>/> 启用
        </td>
    </tr>
    
    <tr>
        <td  width="20%" class="tableleft" >公告管理:</td>
        <td>
               <input type="checkbox" name="permissions" value="N" <c:if test="${fn:contains(permissionStr,'N')}">checked</c:if>/> 启用
        </td>
    </tr>
    
    <tr>
        <td  width="20%" class="tableleft" >编辑用户资料:</td>
        <td>
               <input type="checkbox" name="permissions" value="O" <c:if test="${fn:contains(permissionStr,'O')}">checked</c:if>/> 启用
        </td>
    </tr>  
      

    
     <tr>
        <td  width="20%" class="tableleft" >允许禁止用户:</td>
        <td>
               <input type="checkbox" name="permissions" value="P" <c:if test="${fn:contains(permissionStr,'P')}">checked</c:if>/> 启用
        </td>
    </tr>
    
     <tr>
        <td  width="20%" class="tableleft" >允许禁止IP:</td>
        <td>
               <input type="checkbox" name="permissions" value="Q" <c:if test="${fn:contains(permissionStr,'Q')}">checked</c:if>/> 启用
        </td>
    </tr>
    
    
    </table>
    
    
    
    
 
     <table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid" >返回列表</button>
        </td>
    </tr>
</table>

</form>





</body>

<script
	src="${pageContext.request.contextPath}/media/js/jquery-2.1.4.min.js"></script>
<script
	src="${pageContext.request.contextPath}/media/js/bootstrap.min.js"></script>
<script>
$(function () {       
	$('#backid').click(function(){
			window.location.href="${pageContext.request.contextPath}/admin/group/list";
	 });

});
</script>
</html>
