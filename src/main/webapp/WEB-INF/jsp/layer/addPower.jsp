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
					<form id="powerform"action="#" class="form-horizontal">
						<div class="control-group">
							<label class="control-label" for="inputWarning">标题</label>
							<div class="controls">
								<input name="title" type="text" class="span6 m-wrap" id="inputWarning">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="inputWarning">地址</label>
							<div class="controls">
								<input  name="url" type="text" class="span6 m-wrap" id="inputWarning">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="inputWarning">父级</label>
							<div class="controls">
								<select class="span6 m_wrap" name="pid" style="width: 80%;">
									<option value="0">无</option>
									<c:forEach items="${pws}" var="pw">
										<c:if test="${pw.pid==0}">
											<option value="${pw.id}">${pw.title}</option>
										</c:if>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="inputWarning">图标</label>
							<div class="controls">
								<input  name="icon" type="text" class="span6 m-wrap" id="inputWarning">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="inputWarning">描述</label>
							<div class="controls">
								<input  name="description" type="text" class="span6 m-wrap" id="inputWarning">
							</div>
						</div>
						<div class="control-group">
							<button id="addpowerBtn" type="button" style="margin-left:178px;width: 55%;"class="btn red"><i class="icon-plus"></i> 添加</button>
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
		$("#addpowerBtn").click(function(){
			$.post("../admin/addPower",$("#powerform").serialize(),function(e){
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