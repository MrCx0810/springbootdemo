<%@ page language="java" contentType="text/html; charset=UTF-8"
				pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户信息</title>
	<%@include file="../adminLib/header.jsp"%>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/jquery.page.css"/>
</head>
<body>
<%@include file="../adminLib/up.jsp"%>
<div class="page-container">
	<%@include file="../adminLib/nav.jsp"%>
	<div class="page-content">
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">
					<h3>
						用户信息列表
					</h3>
					<ul class="breadcrumb">
						<li>
							<i class="icon-home"></i>
							<a href="${pageContext.request.contextPath}/index">首页</a>
							<i class="icon-angle-right"></i>
						</li>
						<li>
							<a href="#">信息管理</a>
							<i class="icon-angle-right"></i>
						</li>
						<li><a href="#">用户信息</a></li>
					</ul>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span12">
					<div class="portlet box green">
						<div class="portlet-title">
							<div class="caption"><i class="icon-user"></i>用户列表</div>
							<div class="tools">
								<a href="javascript:;" class="collapse"></a>
								<a href="javascript:;" class="remove"></a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="clearfix">
								<div class="btn-group pull-left">
									<select id="select" class="small m-wrap" >
										<option value="0">状态筛选</option>
										<option value="1">禁用</option>
										<option value="2">禁言</option>
									</select>
								</div>
								<div class="btn-group pull-right">
									<div class="dataTables_filter">
										<label class="control-label">搜索： &nbsp;
											<input type="text" placeholder="输入昵称" name="nice_name" class="m-wrap medium" />
											<button id="serach_niceName" class="btn green"><i class="icon-search m-icon-white"></i></button>
										</label>
									</div>
								</div>
							</div>
							<div id="_html">
								<table class="table table-striped table-bordered table-hover" id="sample_1">
									<thead id="head1">

									</thead>
									<tbody id="body1">

									</tbody>
									<div >
										<div class="btn-group">
											<div class="dataTables_filter">
												<button id="sendMsg2" type="button" class="btn blue"><i class=" icon-envelope m-icon-white"></i>发送全站消息</button>
											</div>
										</div>
									</div>
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
	</div>
	<%@include file="../adminLib/footer.jsp"%>
</div>
<%@include file="../adminLib/down.jsp"%>
<jsp:include page="../admindata/playersData.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.page.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/datajs/player.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/myjs/players.js"></script>
<script type="text/javascript">
</script>
</body>
</html>
