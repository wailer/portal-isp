<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>



<div class="heading">
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	<h2>Area d'administració</h2>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_USER')">
	<h2>Àrea client</h2>
	</sec:authorize>
	
	<ul class="heading-links">
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li class="nav"><a class="button"
				href="<c:url value='/admin-dominis'/>" title="Dominis">Dominis</a></li>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li class="nav"><a class="button"
				href="<c:url value='/admin-allotjaments'/>" title="Allojtaments">Allotjaments</a></li>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li class="nav"><a class="button"
				href="<c:url value='/admin-usuaris'/>" title="Usuaris"><img class="icon12" src="<c:url value="/static/icons/user15.png"/>"/> Usuaris</a></li>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li class="nav"><a class="button"
				href="<c:url value='/admin-config'/>" title="Configuració"><img class="icon12" src="<c:url value="/static/icons/gear.png"/>"/> Configuració</a></li>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<li class="nav"><a class="button"
				href="<c:url value='/client-perfil'/>" title="perfil"><img class="icon12" src="<c:url value="/static/icons/user14.png"/>"/> Les meves dades</a></li>
		</sec:authorize>
	</ul>
</div>
