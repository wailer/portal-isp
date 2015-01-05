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
	
	<div class="formulari">		
		

		<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">Usuari</a> <a id="username">
				<input type='text' name='j_username' value=''>
				</a>
			</div>
			<div class="entrada-pista">
				
			</div>
		</div>
			<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">Password</a> <a id="username">
				<input type='password' name='j_password' value=''>
				</a>
			</div>
			<div class="entrada-pista">				
			</div>
		</div>
		
		<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">Recordar-me</a> <a class="switch switch-square" id="username">
				<input id="recordar"  type='checkbox' name='_spring_security_remember_me' />
				<label data-off="No" data-on="Si" for="recordar"></label>
				</a>
			</div>
			<div class="entrada-pista">				
			</div>
		</div>
		
			<div class="entrada-formulari">
			<div class="entrada-nom">				
				<input class="tag tag-teal" name="submit" type="submit" value="Login" />				
			</div>
			<div class="entrada-pista">				
			</div>
		</div>
		
</div>
</form>
<p>

