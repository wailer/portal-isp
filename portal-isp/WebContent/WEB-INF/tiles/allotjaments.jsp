<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<div class="plans">
	<ul class="plans">

		<c:forEach var="allotjament" items="${allotjaments}">


			<c:set var="estilPla" value="plan" />

			<c:if test="${allotjament.destacat == true }">
				<c:set var="estilPla" value="plan plan-highlight" />
			</c:if>

			<li class="plan">
				<div class="${estilPla}">
					<c:if test="${allotjament.destacat == true }">
						<p class="plan-recommended">Recomanat!</p>
					</c:if>
					<h3 class="plan-title">
						<c:out value="${allotjament.nom}" />
					</h3>
					<p class="plan-price">
						<c:out value="${allotjament.preu}" />
						€ <span class="plan-unit">any</span>
					</p>
					<ul class="plan-features">
						<li class="plan-feature"><c:out
								value="${allotjament.dominis}" /> <span
							class="plan-feature-name">dominis</span></li>
						<li class="plan-feature"><c:out value="${allotjament.espai}" /><span
							class="plan-feature-unit">GB</span> <span
							class="plan-feature-name">espai</span></li>
						<li class="plan-feature"><c:out
								value="${allotjament.busties}" /><span
							class="plan-feature-name"> bústies</span></li>
					</ul>
					<sec:authorize access="isAuthenticated()">
					<a href="<c:url value='/afegir-cistella?codi=${allotjament.codi}'/>" class="plan-button">Comprar</a>
					</sec:authorize>
					<sec:authorize access="!isAuthenticated()">
					<a href="<c:url value='/afegir-cistella?codi=${allotjament.codi}'/>" class="plan-button-nologin">Inicia sessió per comprar aquest producte</a>
					</sec:authorize>
				</div>
			</li>

		</c:forEach>
	</ul>
</div>

