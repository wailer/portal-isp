<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<script type="text/javascript">

function onLoad() {
	$("a#comprovar").on("click", function(e) {
		e.preventDefault();
		$(consultarDomini());
	});
}


	function consultarDomini() {	
		alert("<c:out value="${jsonUrl}"/>" + $("input#domini").val());
	   $.getJSON("<c:out value="${jsonUrl}"/>" + $("input#domini").val() , function(data) {		  
		   alert("Resultat: " + data.status + "Domini: " + data.domain + "Estat: " + data.availabley);		 
	   });
	  
	}

	$(document).ready(onLoad);
</script>