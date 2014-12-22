<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
