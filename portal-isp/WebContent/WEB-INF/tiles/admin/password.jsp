<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<c:set var="estil-error" value="entrada-error" scope="page" />

<div class="formulari">
	<sf:form method="post"
		action="${pageContext.request.contextPath}/modificar-password"
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
				<input class="tag tag-teal" value="Enviar" type="submit" />
			</div>
			<div class="entrada-pista"></div>
		</div>

	</sf:form>
</div>
