<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="header-row">

	<a class="header-logo" tabindex="-1" href="<c:url value='/'/>">ACME
		Hosting</a>
	<div class="header-right">
		<sec:authorize access="isAuthenticated()">
			<a class="salutacio">Hola <sec:authentication
					property="principal.username" />,
			</a>
		</sec:authorize>
		<div id="loginmenu" class="button-group">
			<sec:authorize access="!isAuthenticated()">
				<a class="button button-green" href="<c:url value='/login'/>"><img class="icon12" src="<c:url value="/static/icons/open15.png"/>"/> Login</a>
			</sec:authorize>
			<sec:authorize access="!isAuthenticated()">
				<a class="button button-blue" href="<c:url value='/usuari'/>"><img class="icon12" src="<c:url value="/static/icons/text2.png"/>"/> Registre</a>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<a class="button button-red"
					href="<c:url value='/j_spring_security_logout'/>"><img class="icon12" src="<c:url value="/static/icons/lock5.png"/>"/> Sortir</a>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_USER')">
				<a class="button button-purple " href="<c:url value='/client'/>">Àrea
					Client</a>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<a class="button button-purple" href="<c:url value='/admin'/>">Administració</a>
			</sec:authorize>
		</div>

	</div>

</div>