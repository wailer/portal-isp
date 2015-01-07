<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
	function onLoad() {
		$(mostraErrors());
	}

	/**
	 * El formulari d'Spring crea un element span per cada camp amb problemes, i aquest conté la llista d'errors de validació
	 * Per tant , l'únic que hem de fer és aplicar-hi un estil per destacar l'error.
	 */
	function mostraErrors() {

		if ($("#codi\\.errors").length > 0) {
			$("#codi\\.errors").addClass("entrada-error");
			$("a#codi").addClass("invalid");
		}

		if ($("#nom\\.errors").length > 0) {
			$("#nom\\.errors").addClass("entrada-error");
			$("a#nom").addClass("invalid");
		}

		if ($("#extensio\\.errors").length > 0) {
			$("#extensio\\.errors").addClass("entrada-error");
			$("a#extensio").addClass("invalid");
		}

		if ($("#descripcio\\.errors").length > 0) {
			$("#descripcio\\.errors").addClass("entrada-error");
			$("a#descripcio").addClass("invalid");
		}

		if ($("#preu\\.errors").length > 0) {
			$("#preu\\.errors").addClass("entrada-error");
			$("a#preu").addClass("invalid");
		}
	
	}

	$(document).ready(onLoad);
</script>
