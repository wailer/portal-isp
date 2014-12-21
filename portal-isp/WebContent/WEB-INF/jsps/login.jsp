<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login Page</title>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body onload='document.f.j_username.focus();'>

	<c:if test="${param.error != null }">
		<span class="errorLogin">Login incorrecte</span>
	</c:if>

	<form name='f'
		action='${pageContext.request.contextPath}/j_spring_security_check'
		method='POST'>
		<table class="TaulaLogin">
			<tr>
				<td>Usuari:</td>
				<td><input type='text' name='j_username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='j_password' /></td>
			</tr>
				<tr>
				<td>Remember me:</td>
				<td><input type='checkbox' name='_spring_security_remember_me' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
			</tr>
		</table>
	</form>
	<p>
		<a href="<c:url value="/nouusuari"/>">Crear nou usuari</a>
</body>
</html>