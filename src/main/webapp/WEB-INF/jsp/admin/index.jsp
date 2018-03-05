<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<%@include file="../adminLib/header.jsp" %>
</head>
<body>
	<%@include file="../adminLib/up.jsp" %>
	<div class="page-container">
		<%@include file="../adminLib/nav.jsp" %>
		<div class="page-content">
			
		</div>
		<%@include file="../adminLib/footer.jsp" %>
	</div>
	
	<%@include file="../adminLib/down.jsp" %>
	<script>
		jQuery(document).ready(function() {    
		   App.init(); // initlayout and core plugins
		   Index.init();
		});
	</script>
</body>
</html>