<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../adminLib/header.jsp" %>
</head>
<body style="background:#FFF">
	<div class="page-container" >
		<div class="page-content" >
			<div class="container-fluid">
				<div class="row-fluid">
				<br></br>
					<form id="editform"action="#" class="form-horizontal">
						<input name="id" value="${admin.id}" type="hidden">
						<div class="control-group">
							<label class="control-label" for="inputWarning">账号</label>
							<div class="controls">
								<input  value="${admin.loginName}"id="login" name="loginName" type="text" class="span6 m-wrap" id="inputWarning">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="inputWarning">密码</label>
							<div class="controls">
								<input  id="psw" name="loginPassword" type="password" class="span6 m-wrap"  value="">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="inputWarning">姓名</label>
							<div class="controls">
								<input value="${admin.name}"   name="name" type="text" class="span6 m-wrap"   placeholder="姓名">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="inputWarning">电话</label>
							<div class="controls">
								<input value="${admin.phoneNumber}"   name="phoneNumber" type="text" class="span6 m-wrap"  placeholder="电话">
							</div>
						</div>
						<div class="control-group">
						<label class="control-label" for="inputWarning">角色</label>
							<select id="role" class="m-wrap span6" name="roleId">
							<option  value="${admin.roleId}">${admin.roleName}</option>
								<c:forEach items="${roles}" var="role">
									<c:if test="${admin.roleId!=role.id}">
										<option  value="${role.id}">${role.roleName}</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
						<div class="control-group">
							<button id="editAdminBtn" type="button" style="margin-left:175px; "class="btn green"><i class="icon-wrench"></i> 修改</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="../adminLib/down.jsp" %>
	<script>
		jQuery(document).ready(function() {    
		   App.init(); 
		});
		$("#editAdminBtn").click(function(){
			$.post("../admin/editAdmin",$("#editform").serialize(),function(e){
				if(e.code==100){
					layer.alert("编辑成功", {icon:6, cancel:function(){window.parent.location.reload();}}, function(){
						window.parent.location.reload();
					});
				}else{
					layer.alert(e.msg, {icon:5});
				}
			});
		})
	</script>
</body>
</html>