<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" >
<script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery-1.11.2.min.js"></script>
<script type="text/javascript">

function onLoad() {
	$("#password").keyup(checkPasswordsMatch);
	$("#confirmpassword").keyup(checkPasswordsMatch);
	
	$("#details").submit(canSubmit);
}

function canSubmit() {
	var password = $("#password").val();
	var confirmpassword = $("#confirmpass").val();
	
	if(password != confirmpassword) {
		alert("<fmt:message key='UnmatchedPasswords.user.password' />")
		return false;
	}
	else {
		return true;
	}
}

function checkPasswordsMatch() {
	var password = $("#password").val();
	var confirmpassword = $("#confirmpassword").val();	
	
	if(password.length < 5 || confirmpassword.length < 5){
		return;
	}
	
	if(password == confirmpassword) {
		$("#passwordMatch").text("<fmt:message key='MatchedPasswords.user.password'/>");
		$("#passwordMatch").addClass("valid");
		$("#passwordMatch").removeClass("error");		
	} else {
		$("#passwordMatch").text("<fmt:message key='UnmatchedPasswords.user.password'/>");
		$("#passwordMatch").addClass("error");
		$("#passwordMatch").removeClass("valid");
		
	}
}

$(document).ready(onLoad);
</script>

<title>Nou Usuari</title>

</head>
<body>

<sf:form method="post" action="${pageContext.request.contextPath}/crearusuari" commandName="user">
<table class="taula">

<tr><td>Name: </td><td><sf:input name="name" path="username" type="text" /><br/><div class="error"><sf:errors path="username"></sf:errors></div></td></tr>
<tr><td>Email: </td><td><sf:input name="email" path="email" type="text" /><br/><div class="error"><sf:errors path="email"></sf:errors></div></td></tr>
<tr><td>Password: </td><td><sf:input id="password" name="password" path="password" type="password" /><br/><div class="error"><sf:errors path="password"></sf:errors></div></td></tr>
<tr><td>Confirmar Password: </td><td><input id="confirmpassword" class="control" name="confirmpassword"  type="password" /><div id="passwordMatch"></div></td></tr>
<tr><td></td><td><input value="Crear producte" type="submit" /></td></tr>


</table>

</sf:form>




</body>
</html>