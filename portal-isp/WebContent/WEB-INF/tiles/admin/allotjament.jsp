<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!-- Variables dinàmiques en funció del rol de l'usuari -->

<sec:authorize access="hasRole('ROLE_ADMIN')">
	<c:set var="formAction"
		value="${pageContext.request.contextPath}/admin-form-allotjament"
		scope="page" />
</sec:authorize>


<!--  Formulari  -->

<div class="formulari">
	<sf:form method="post" action="${formAction}" commandName="allotjament">

		<sf:hidden path="id" />

		<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">Habilitat?</a> <a
					class="switch switch-square" id="actiu"> <sf:checkbox
						path="actiu" label="actiu" data-on="SI" data-off="NO" />

				</a>
			</div>
			
			<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">Destacat?</a> <a
					class="switch switch-square" id="destacat"> <sf:checkbox
						path="destacat" label="destacat" data-on="SI" data-off="NO" />

				</a>
			</div>
			
			<div class="entrada-pista">
				<sf:errors path="actiu"></sf:errors>
			</div>
		</div>

		<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">Codi</a> <a id="codi"><sf:input
						name="codi" path="codi" type="text" /></a>
			</div>
			<div class="entrada-pista">
				<sf:errors path="codi"></sf:errors>
			</div>
		</div>

		<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">Nom</a> <a id="nom"><sf:input name="nom"
						path="nom" type="text" /></a>
			</div>
			<div class="entrada-pista">
				<sf:errors path="nom"></sf:errors>
			</div>
		</div>

		<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">Descripció</a> <a id="descripcio"><sf:input
						name="descripcio" path="descripcio" type="text" /></a>
			</div>
			<div class="entrada-pista">
				<sf:errors path="descripcio"></sf:errors>
			</div>
		</div>

		<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">Preu</a> <a id="preu"><sf:input
						name="preu" path="preu" type="text" /></a>
			</div>
			<div class="entrada-pista">
				<sf:errors path="preu"></sf:errors>
			</div>
		</div>
		
		<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">Espai</a> <a id="espai"><sf:input
						name="espai" path="espai" type="text" /></a>
			</div>
			<div class="entrada-pista">
				<sf:errors path="espai"></sf:errors>
			</div>
		</div>
		
		<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">Dominis</a> <a id="dominis"><sf:input
						name="dominis" path="dominis" type="text" /></a>
			</div>
			<div class="entrada-pista">
				<sf:errors path="dominis"></sf:errors>
			</div>
		</div>

		<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">Bústies</a> <a id="bústies"><sf:input
						name="busties" path="busties" type="text" /></a>
			</div>
			<div class="entrada-pista">
				<sf:errors path="busties"></sf:errors>
			</div>
		</div>


		<div class="entrada-formulari">
			<div class="entrada-nom">
				<input id="enviar" class="tag tag-teal" value="Enviar" type="submit" />
			</div>
			<div class="entrada-pista"></div>
		</div>

	</sf:form>
</div>
