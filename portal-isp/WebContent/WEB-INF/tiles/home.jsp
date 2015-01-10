<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="home">
	<div class="cerca-domini">

		<p class="search">
			<input id="domini" type="search" value="El teu domini..."></input><a
				id="comprovar" class="button button-blue" href="#">Comprovar</a>
		</p>

	</div>

	<div id="wrapperResultat">
		<div id="resultat"></div>
		<span id="resultat">
			</span>
		<div id="consultant"></div>
		<div id="error"></div>
	</div>

	<div class="llista-extensions">

		<ul class="extensions">
			<p>Selecciona una de les extensions disponibles:</p>
			<c:forEach var="extensio" items="${extensions}">
				<li class="extensions">.<c:out value="${extensio}" /><label
					class="option"> <input type="radio"
						id="<c:out
								value="${extensio}" />"
						value="<c:out
								value="${extensio}" />" name="extensio"></input>
						<a class="radio blue"></a>
				</label></li>
			</c:forEach>
		</ul>
	</div>



</div>