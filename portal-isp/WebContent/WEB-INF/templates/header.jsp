<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="header-row">

		<a class="header-logo" tabindex="-1" href="/">ACME Hosting</a>


	<div class="header-right">
		<nav class="header-nav">
			<a class="header-link header-nav-link active"
				href="<c:url value='/'/>">Inici</a>
			<sec:authorize access="!isAuthenticated()">
				<a class="header-link header-nav-link"
					href="<c:url value='/login'/>">Login</a>
			</sec:authorize>
			<sec:authorize access="!isAuthenticated()">
				<a class="header-link header-nav-link"
					href="<c:url value='/nouusurai'/>">Registre</a>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<a class="header-link header-nav-link"
					href="<c:url value='/j_spring_security_logout'/>">Sortir</a>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_USER')">
				<a class="header-link header-nav-link" href="/client">Àrea
					Client</a>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<a class="header-link header-nav-link" href="/admin">Administració</a>
			</sec:authorize>			
		</nav>
	
	</div>

</div>