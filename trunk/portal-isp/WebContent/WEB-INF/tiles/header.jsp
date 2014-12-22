
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="header-left">
	<div class="title">Acme Hosting</div>
</div>
<div class="header-right">
	<div class="menu-superior">
		<ul class="menu-superior">
			<li class="menu-superior"><p>
					<a href="<c:url value='/'/>">Inici</a>
				</p></li>
			<li class="menu-superior"><sec:authorize
					access="isAuthenticated()">
					<p>
						<a href="<c:url value='/j_spring_security_logout'/>">Tancar
							Sessió</a>
					</p>
				</sec:authorize></li>
			<li class="menu-superior"><sec:authorize
					access="!isAuthenticated()">
					<p>
						<a href="<c:url value='/login'/>">Login</a>
					</p>
				</sec:authorize></li>
			<li class="menu-superior"><sec:authorize
					access="hasRole('ROLE_ADMIN')">
					<p>
						<a href="<c:url value='/admin'/>">Admin</a>
					</p>
				</sec:authorize></li>
		</ul>
	</div>
</div>