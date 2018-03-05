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
					<form id="adminform"action="#" class="form-horizontal">
						<div class="control-group">
							<label class="control-label" for="inputWarning">账号</label>
							<div class="controls">
								<input id="login" name="loginName" type="text" class="span6 m-wrap" id="inputWarning" placeholder="账号">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="inputWarning">密码</label>
							<div class="controls">
								<input  id="psw" name="loginPassword" type="password" class="span6 m-wrap"  value="" placeholder="密码">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="inputWarning">姓名</label>
							<div class="controls">
								<input   name="name" type="text" class="span6 m-wrap"  value="" placeholder="姓名">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="inputWarning">电话</label>
							<div class="controls">
								<input   name="phoneNumber" type="tel" class="span6 m-wrap"  value="" placeholder="电话">
							</div>
						</div>
						<div class="control-group">
						<label class="control-label" for="inputWarning">角色</label>
							<select id="role" class="m-wrap span6" name="roleId">
								<c:forEach items="${roles}" var="role">
									<option  value="${role.id}">${role.roleName}</option>
								</c:forEach>
							</select>
						</div>
						<div class="control-group">
							<button id="addAdminBtn" type="button" style="margin-left:175px; "class="btn blue"><i class="icon-save"></i> 保存</button>
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
		$("#addAdminBtn").click(function(){
			console.log($("#adminform").serialize());
			$.post("../admin/addUser",$("#adminform").serialize(),function(e){
				if(e.code==100){
					layer.alert("添加成功", {icon:6}, function(){
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