<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-sidebar nav-collapse collapse">
	<ul class="page-sidebar-menu">
		<li>
			<div class="sidebar-toggler hidden-phone"></div>
		</li>
        <li>
			<form class="sidebar-search">
				<div class="input-box">
					<a href="javascript:;" class="remove"></a>
					<input type="text" placeholder="Search..." />
					<input type="button" class="submit" value=" " />
				</div>
			</form>
		</li>
		${pageContext.request.contextPath }
		<c:forEach items="${powers}" var="power">
				<li class="${power.active}">
					<a href="${empty power.powers?pageContext.request.contextPath:''}${empty power.powers?power.url:'javascript:;' }">
						<i class="${power.icon}"></i> 
						<span class="title">${power.title}</span>
						<c:if test="${!empty power.active}">
							<span class="selected"></span>
						</c:if>
						<span class="${empty power.powers?'selected':'arrow'} ${empty power.content?'':power.content}"></span>
				    </a>
				    <c:if test="${!empty power.powers}">
				    	<ul class="sub-menu">
				    		<c:forEach items="${power.powers}" var="pw">
				    			<li class="${pw.active}">
									<a href="${pw.url}">${pw.title}</a>
								</li>
				    		</c:forEach>
						</ul>
				    </c:if>
			    </li>
		</c:forEach>
	</ul>
</div>