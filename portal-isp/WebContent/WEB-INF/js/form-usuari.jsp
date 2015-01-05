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
		$("#user").submit(canSubmit);
		$(mostraErrors());
	}

	/**
	 * El formulari d'Spring crea un element span per cada camp amb problemes, i aquest conté la llista d'errors de validació
	 * Per tant , l'únic que hem de fer és aplicar-hi un estil per destacar l'error.
	 */
	function mostraErrors() {

		if ($("#username\\.errors").length > 0) {
			$("#username\\.errors").addClass("entrada-error");
			$("a#username").addClass("invalid");
		}

		if ($("#nom\\.errors").length > 0) {
			$("#nom\\.errors").addClass("entrada-error");
			$("a#nom").addClass("invalid");
		}

		if ($("#cognoms\\.errors").length > 0) {
			$("#cognoms\\.errors").addClass("entrada-error");
			$("a#cognoms").addClass("invalid");
		}

		if ($("#email\\.errors").length > 0) {
			$("#email\\.errors").addClass("entrada-error");
			$("a#email").addClass("invalid");
		}

		if ($("#dni\\.errors").length > 0) {
			$("#dni\\.errors").addClass("entrada-error");
			$("a#dni").addClass("invalid");
		}

		if ($("#telefon\\.errors").length > 0) {
			$("#telefon\\.errors").addClass("entrada-error");
			$("a#telefon").addClass("invalid");
		}

		if ($("#direccio\\.errors").length > 0) {
			$("#direccio\\.errors").addClass("entrada-error");
			$("a#direccio").addClass("invalid");
		}

		if ($("#codiPostal\\.errors").length > 0) {
			$("#codiPostal\\.errors").addClass("entrada-error");
			$("a#codiPostal").addClass("invalid");
		}

		if ($("#poblacio\\.errors").length > 0) {
			$("#poblacio\\.errors").addClass("entrada-error");
			$("a#poblacio").addClass("invalid");
		}

		if ($("#empresa\\.errors").length > 0) {
			$("#empresa\\.errors").addClass("entrada-error");
			$("a#empresa").addClass("invalid");
		}
		
		if ($("#password\\.errors").length > 0) {
			$("#password\\.errors").addClass("entrada-error");
			$("a#password").addClass("invalid");
		}

	}

	function canSubmit() {
		var password = $("input#password").val();
		var confirmpassword = $("input#confirmpassword").val();

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
