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
					<form id="roleform"action="#" class="form-horizontal">
						<div class="control-group">
							<label class="control-label" for="inputWarning">角色名</label>
							<div class="controls">
								<input id="login" name="roleName" type="text" class="span6 m-wrap" id="inputWarning">
							</div>
						</div>
						<div class="control-group">
							<button id="addRoleBtn" type="button" style="margin-left:178px; "class="btn red"><i class="icon-plus"></i> 添加</button>
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
		$("#addRoleBtn").click(function(){
			$.post("../admin/addRole",$("#roleform").serialize(),function(e){
				if(e.code==100){
					layer.alert("添加成功", {icon:6});
					window.parent.location.reload();
				}else{
					layer.alert(e.msg, {icon:5});
				}
			});
		})
	</script>
</body>
</html>