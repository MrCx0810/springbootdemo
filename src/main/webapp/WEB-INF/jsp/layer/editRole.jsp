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
						<input name="id" value="${id}" type="hidden"/>
						<div class="control-group">
							<label class="control-label" for="inputWarning">角色名</label>
							<div class="controls">
								<input id="login" name="roleName" type="text" class="span6 m-wrap" id="inputWarning">
							</div>
						</div>
						<div class="control-group">
							<button id="editRoleBtn" type="button" style="margin-left:179px; "class="btn yellow"><i class="icon-wrench"></i> 修改</button>
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
		$("#editRoleBtn").click(function(){
			$.post("../admin/editRole",$("#roleform").serialize(),function(e){
				if(e.code==100){
					layer.alert("编辑成功", {icon:6});
					window.parent.location.reload();
				}else{
					layer.alert(e.msg, {icon:5});
				}
			});
		})
	</script>
</body>
</html>