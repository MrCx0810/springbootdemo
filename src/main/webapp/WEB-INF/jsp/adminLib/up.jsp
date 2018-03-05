<%@ page contentType="text/html; charset=UTF-8"%>
<div class="header navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">
			<!-- BEGIN LOGO -->
				<a class="brand" href="index.html">

				<img src="${pageContext.request.contextPath}/static/media/image/logo.png" alt="logo"/>

				</a>
				<!-- END LOGO -->

				<!-- BEGIN RESPONSIVE MENU TOGGLER -->

				<a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">

				<img src="${pageContext.request.contextPath}/static/media/image/menu-toggler.png" alt="" />
				
				</a>

			<ul class="nav pull-right">
			<!-- BEGIN USER LOGIN DROPDOWN -->
				<li class="dropdown user">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<img alt="" src="${pageContext.request.contextPath}/static/media/image/avatar1_small.jpg" />
						<span class="username">${namr}</span>
						<i class="icon-angle-down"></i>
					</a>
					<ul class="dropdown-menu">
						<li><a href="extra_profile.html"><i class="icon-user"></i> 个人中心</a></li>
						<%--<li class="divider"></li>--%>
						<li><a href="../layout"><i class="icon-key"></i> 退出登录</a></li>

					</ul>
				</li>
			</ul>
		</div>
	</div>
</div>