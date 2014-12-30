<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="header-row">

		<a class="header-logo" tabindex="-1" href="<c:url value='/'/>">ACME Hosting</a>
	<div class="header-right">
		<div id="loginmenu" class="button-group">			
			<sec:authorize access="!isAuthenticated()">
				<a class="button button-green"
					href="<c:url value='/login'/>">Login</a>
			</sec:authorize>
			<sec:authorize access="!isAuthenticated()">
				<a class="button button-blue"
					href="<c:url value='/nouusuari'/>">Registre</a>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<a class="button button-red"
					href="<c:url value='/j_spring_security_logout'/>">Sortir</a>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_USER')">
				<a class="button button-purple " href="/client">Àrea
					Client</a>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<a class="button button-purple" href="/admin">Administració</a>
			</sec:authorize>			
		</div>
	
	</div>

</div>