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
							后台用户角色管理
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
							<li><a href="#">角色管理</a></li>
						</ul>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12">
						<div class="portlet box red">
							<div class="portlet-title">
								<div class="caption"><i class="icon-user"></i>角色列表</div>
								<div class="tools">
									<a href="javascript:;" class="collapse"></a>
									<a href="javascript:;" class="remove"></a>
								</div>
							</div>
							<div class="portlet-body">
								<div class="clearfix">
									<div class="btn-group pull-right">
										<button id="addRole" class="btn blue">
											添加角色 <i class="icon-plus"></i>
										</button>
									</div>
								</div>
								<table class="table table-striped table-bordered table-hover" id="sample_1">
									<thead id="adminhead">
										<tr>
											<th width="25%">序号</th>
											<th width="25%">角色</th>
											<th width="50%">操作</th>
										</tr>
									</thead>
									<tbody id="adminbody">
									<% int ID=1; %>
										<c:forEach items="${roles}" var="role">
											<tr>
												<td><%=ID++ %></td>
												<td>${role.roleName}</td>
												<td>
													<button  id="${role.id}" onclick="editRole(this.id)" class="btn mini yellow"><i class="icon-pencil"></i>编辑</button>
													&nbsp;
													<button  id="${role.id}" onclick="delRole(this.id)" class="btn mini red"><i class="icon-trash"></i>删除</button>
													&nbsp;
													<button  id="${role.id}" onclick="getPower(this.id)"class="btn mini blue"><i class="icon-edit"></i>分配权限</button>
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
		});
		$("#addRole").click(function(){
			layer.open({
				  type: 2,
				  title: '添加角色',
				  fixed: true,
	              shadeClose: true,
	              maxmin: true,
	              area: ['500px', '200px'],
				  content: ["../layer/addRole","no"]
			});
		})

		function delRole(id){
			layer.confirm('确认删除该角色？', {icon:3,title:'提示'},function(index){
				$.post("delRole",{id:id},function(e){
					if(e.code==100){
						layer.alert("删除成功",{icon:6});
						location.reload();
					}else{
						layer.alert(e.msg,{icon:5});
					}
				});
				
				layer.close(index);
			})
		}
		function editRole(id){
			layer.open({
				  type: 2,
				  title: '修改角色',
				  fixed: true,
	              shadeClose: true,
	              maxmin: true,
	              area: ['500px', '200px'],
				  content: ["../layer/editRole?id="+id,"no"]
			});
		}
		function getPower(id){
			layer.open({
				  type: 2,
				  title: '分配权限',
				  fixed: true,
	              shadeClose: true,
	              maxmin: true,
	              area: ['500px', '400px'],
				  content: "../layer/powerRole?id="+id
			});
		}
	</script>
</body>
</html>