<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<script type="text/javascript">
	$(document).ready(function() {
		document.f.j_username.focus();
	})
</script>

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
			<td colspan='2'><input name="submit" type="submit" value="Login" /></td>
		</tr>
	</table>
</form>
<p>

