<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!-- Variables dinàmiques en funció del rol de l'usuari -->

<sec:authorize access="hasRole('ROLE_ADMIN')">
	<c:set var="formAction"
		value="${pageContext.request.contextPath}/admin-modificar-password"
		scope="page" />	
</sec:authorize>

<sec:authorize access="hasRole('ROLE_USER')">
	<c:set var="formAction"
		value="${pageContext.request.contextPath}/client-modificar-password"
		scope="page" />	
</sec:authorize>

<!--  Formulari  -->

<div class="formulari">
	<sf:form method="post"
		action="${formAction}"
		commandName="user">

		<sf:hidden path="id"/>
		
				<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">Password</a> <a id="password"><sf:input
						id="password" name="password" path="password" type="password" /></a>
			</div>
			<div class="entrada-pista">
				<sf:errors path="password"></sf:errors>
			</div>
		</div>

		<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">Confirmar Password</a><a
					id="confirmpassword"><input id="confirmpassword"
					name="confirmpassword" class="control" type="password" /></a>
			</div>
			<div class="entrada-pista">
				<div id="passwordMatch"></div>
			</div>
		</div>

		<div class="entrada-formulari">
			<div class="entrada-nom">
				<input id="enviar" class="tag tag-teal" value="Enviar" type="submit" />
			</div>
			<div class="entrada-pista"></div>
		</div>

	</sf:form>
</div>
