<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<script type="text/javascript">
	function onLoad() {
		$("a#comprovar")
				.on(
						"click",
						function(e) {

							var extensio = $("input[name='extensio']:checked")
									.val();
							if (extensio == "undefined") {
								e.preventDefault();
								alert("No has seleccionat cap extensió.");
							} else if ($("input#domini").val().length == 0
									|| (/^[a-zA-Z-]*$/.test($("input#domini")
											.val()) == false)) {
								e.preventDefault();
								alert("El domini no és vàlid.");
							} else {

								var domini = $("input#domini").val();

								$(iniciaCerca());
								$(consultarDomini(domini, extensio));
							}

						});
	}

	function consultarDomini(domini, extensio) {
		var url = "<c:url value="/rest"/>" + "/consultar-domini" + "/" + domini
				+ "/" + extensio;

		$.getJSON(url, function(data) {

			$("div#consultant").hide();
			$("div#resultat").show();
			$("span#resultat").show();

			if (data.status == "error") {				
				$("span#resultat").removeClass("domini-ok");
				$("span#resultat").addClass("domini-error");
				$("span#resultat").text(
						"Ups! Sembla que el servidor no respon. Prova-ho d'aqui a uns minuts.");
				
			} else if (data.status == "success") {			
				
				if (data.available == true) {
					$("span#resultat").removeClass("domini-error");
					$("span#resultat").addClass("domini-ok");
					$("span#resultat").text(
							"Fantàstic! El domini " + domini + "." + extensio
									+ " està disponible.");

				} else if (data.available == false) {
					$("span#resultat").removeClass("domini-ok");
					$("span#resultat").addClass("domini-error");
					$("span#resultat").text(
							"Llàstima! El domini " + domini + "." + extensio
									+ " no està disponible.");

				}
			}
		});

	}

	function iniciaCerca() {
		$("div#resultat").hide();	
		$("span#resultat").hide();
		$("div#consultant").show();
		
	}

	$(document).ready(onLoad);
</script>