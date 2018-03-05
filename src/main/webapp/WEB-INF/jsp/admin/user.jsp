<%@ page contentType="text/html; charset=UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员管理</title>
<%@include file="../adminLib/header.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/jquery.page.css"/>
</head>
<body>
	<%@include file="../adminLib/up.jsp" %>
	<div class="page-container">
		<%@include file="../adminLib/nav.jsp" %>
		<div class="page-content">
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12">
						<h3>
							管理员信息列表
						</h3>
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="${pageContext.request.contextPath}/index">首页</a>
								<i class="icon-angle-right"></i>
							</li>
							<li>
								<a href="#">权限管理</a>
								<i class="icon-angle-right"></i>
							</li>
							<li><a href="#">管理员管理</a></li>
						</ul>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12">
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption"><i class="icon-user"></i>管理员列表</div>
								<div class="tools">
									<a href="javascript:;" class="collapse"></a>
									<a href="javascript:;" class="remove"></a>
								</div>
							</div>
							<div class="portlet-body">
								<div class="clearfix">
									<div class="btn-group pull-right">
										<button id="addAdmin" class="btn green">
											添加管理员 <i class="icon-plus"></i>
										</button>
									</div>
								</div>
								<table class="table table-striped table-bordered table-hover" id="sample_1">
									<thead id="head1">

									</thead>
									<tbody id="body1">

									</tbody>
								</table>
								<%--分页--%>
								<div class="myPage pull-right">
									<div class="page"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%@include file="../adminLib/footer.jsp" %>
	</div>
	<%@include file="../adminLib/down.jsp" %>
	<jsp:include page="../admindata/adminsData.jsp"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.page.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/datajs/admindata.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/myjs/admindata.js"></script>
</body>
</html>