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
		<span id="resultat"> </span>
		<div id="consultant"></div>
		<div id="error"></div><br>
		<div id="comprar">
			<sec:authorize access="isAuthenticated()">
				<a  id="comprar-domini" href="#"
					class="plan-button">Comprar</a>
			</sec:authorize>
			<sec:authorize access="!isAuthenticated()">
				<a id="comprar-domini" href="#"
					class="plan-button-nologin">Inicia sessió per comprar aquest
					producte</a>
			</sec:authorize>
		</div>
	</div>

	<div class="llista-extensions">
		<ul class="extensions">
			<p>Selecciona una de les extensions disponibles:</p>
			<c:forEach var="domini" items="${dominis}">
				<li class="extensions">.<c:out value="${domini.extensio}" /><label
					class="option" > <input data-codi="<c:out value='${domini.codi}'/>" type="radio"
						id="<c:out
								value="${domini.extensio}" />"
						value="<c:out
								value="${domini.extensio}" />" name="extensio"></input>
						<a class="radio blue"></a>
				</label></li>
			</c:forEach>
		</ul>
	</div>
</div>


<div class="plans">
	<c:forEach var="domini" items="${dominis}">

		<div class="plan">
			<h3 class="plan-title">${domini.nom}</h3>
			<p class="plan-price">${domini.preu}€<span class="plan-unit">any</span>
			</p>
			<p class="plan-features">${domini.descripcio}</p>

		</div>

	</c:forEach>

</div>
