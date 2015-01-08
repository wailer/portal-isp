<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="plans">
	<c:forEach var="domini" items="${dominis}">

		<div class="plan">
			<h3 class="plan-title">${domini.nom}</h3>
			<p class="plan-price">${domini.preu}€<span class="plan-unit">anual</span>
			</p>
			<p class="plan-features">
			${domini.descripcio}
			</p>
			<a href="#" class="plan-button">Comprar</a>
		</div>

	</c:forEach>

</div>
