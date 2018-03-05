<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员管理</title>
<%@include file="../adminLib/header.jsp" %>
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
							权限控制
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
							<li><a href="#">权限控制</a></li>
						</ul>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12">
						<div class="portlet box green">
							<div class="portlet-title">
								<div class="caption"><i class="icon-cog"></i>权限列表</div>
								<div class="tools">
									<a href="javascript:;" class="collapse"></a>
									<a href="javascript:;" class="remove"></a>
								</div>
							</div>
							<div class="portlet-body">
								<div class="clearfix">
									<div class="btn-group pull-right">
										<button id="addPower" class="btn yellow">
											添加权限 <i class="icon-plus"></i>
										</button>
									</div>
								</div>
								<table class="table table-striped table-bordered table-hover" id="sample_1">
									<thead id="adminhead">
										<tr>
											<th>序号</th>
											<th>标题</th>
											<th>类型</th>
											<th>图标</th>
											<th>路径</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody id="adminbody">
										<%int ID=1; %>
										<c:forEach items="${allpower}" var="power">
											<tr>
												<td><%=ID++ %></td>
												<td>${power.title}</td>
												<c:if test="${power.type==0}">
													<td>${power.pid==0?'主菜单':'子菜单'}</td>
												</c:if>
												<c:if test="${power.type==1}">
													<td>功能菜单</td>
												</c:if>
												
												<td>${power.icon}</td>
												<td>${power.url}</td>
												<td>
													<button  id="${power.id}" onclick="editRole(this.id)" class="btn mini yellow"><i class="icon-pencil"></i>编辑</button>
													&nbsp;
													<button  id="${power.id}" onclick="delRole(this.id)" class="btn mini red"><i class="icon-trash"></i>删除</button>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%@include file="../adminLib/footer.jsp" %>
	</div>
	
	<%@include file="../adminLib/down.jsp" %>
	<script>
		jQuery(document).ready(function() {    
		   App.init(); 
		   TableManaged.init();
		});
		$("#addPower").click(function(){
			layer.open({
				  type: 2,
				  title: '添加权限',
				  fixed: true,
	              shadeClose: true,
	              maxmin: true,
	              area: ['600px', '400px'],
				  content: "../layer/addPower"
			});
		})
	</script>
</body>
</html>