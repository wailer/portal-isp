<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
	function onLoad() {
		$("input#password").keyup(checkPasswordsMatch);
		$("input#confirmpassword").keyup(checkPasswordsMatch);
		$("#enviar").submit(canSubmit);
		$(mostraErrors());
	}

	/**
	 * El formulari d'Spring crea un element span per cada camp amb problemes, i aquest conté la llista d'errors de validació
	 * Per tant , l'únic que hem de fer és aplicar-hi un estil per destacar l'error.
	 */
	function mostraErrors() {
		
		if ($("#password\\.errors").length > 0) {
			$("#password\\.errors").addClass("entrada-error");
			$("a#password").addClass("invalid");
		}

	}

	function canSubmit() {
		var password = $("input#password").val();
		var confirmpassword = $("input#confirmpass").val();

		if (password != confirmpassword) {
			alert("<fmt:message key='UnmatchedPasswords.user.password' />")
			return false;
		} else {
			return true;
		}
	}

	function checkPasswordsMatch() {
		var password = $("input#password").val();
		var confirmpassword = $("input#confirmpassword").val();

		if (password.length < 5 || confirmpassword.length < 5) {
			return;
		}

		if (password == confirmpassword) {
			$("#passwordMatch").text(
					"<fmt:message key='MatchedPasswords.user.password'/>");
			$("#passwordMatch").removeClass("entrada-error");
			$("#passwordMatch").addClass("entrada-ok");
			$("a#password").removeClass("invalid");
			$("a#password").addClass("valid");
			$("a#confirmPassword").removeClass("invalid");
			$("a#confirmpassword").addClass("valid");
		} else {
			$("#passwordMatch").text(
					"<fmt:message key='UnmatchedPasswords.user.password'/>");
			$("#passwordMatch").removeClass("entrada-ok");
			$("#passwordMatch").addClass("entrada-error");
			$("a#password").removeClass("valid");
			$("a#password").addClass("invalid");
			$("a#confirmPassword").removeClass("valid");
			$("a#confirmpassword").addClass("invalid");
		}
	}

	$(document).ready(onLoad);
</script>
