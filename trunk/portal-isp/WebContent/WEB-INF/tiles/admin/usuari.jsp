<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<c:set var="estil-error" value="entrada-error" scope="page" />

<div class="formulari">
	<sf:form method="post"
		action="${pageContext.request.contextPath}/modificar-usuari"
		commandName="user">

		<sf:hidden path="id" />

		<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">Habilitat?</a> <a
					class="switch switch-square" id="enabled"> <sf:checkbox
						path="enabled" label="enabled" data-on="SI" data-off="NO" />
						
				</a>
			</div>
			<div class="entrada-pista">
				<sf:errors path="enabled"></sf:errors>
			</div>
		</div>

		<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">Usuari</a> <a id="username"><sf:input
						name="username" path="username" type="text" /></a>
			</div>
			<div class="entrada-pista">
				<sf:errors path="username"></sf:errors>
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
				<a class="tag tag-blue">Cognoms</a> <a id="cognoms"><sf:input
						name="cognoms" path="cognoms" type="text" /></a>
			</div>
			<div class="entrada-pista">
				<sf:errors path="cognoms"></sf:errors>
			</div>
		</div>

		<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">Correu Electrònic</a> <a id="email"><sf:input
						name="email" path="email" type="text" /></a>
			</div>
			<div class="entrada-pista">
				<sf:errors path="email"></sf:errors>
			</div>
		</div>

		<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">DNI</a> <a id="dni"><sf:input name="dni"
						path="dni" type="text" /></a>
			</div>
			<div class="entrada-pista">
				<sf:errors path="dni"></sf:errors>
			</div>
		</div>

		<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">Telèfon</a> <a id="telefon"><sf:input
						name="telefon" path="telefon" type="text" /></a>
			</div>
			<div class="entrada-pista">
				<sf:errors path="telefon"></sf:errors>
			</div>
		</div>

		<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">Adreça</a> <a id="direccio"><sf:input
						name="direccio" path="direccio" type="text" /></a>
			</div>
			<div class="entrada-pista">
				<sf:errors path="direccio"></sf:errors>
			</div>
		</div>

		<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">Codi Postal</a> <a id="codiPostal"><sf:input
						name="codiPostal" path="codiPostal" type="text" /></a>
			</div>
			<div class="entrada-pista">
				<sf:errors path="codiPostal"></sf:errors>
			</div>
		</div>

		<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">Població</a> <a id="poblacio"><sf:input
						name="poblacio" path="poblacio" type="text" /></a>
			</div>
			<div class="entrada-pista">
				<sf:errors path="poblacio"></sf:errors>
			</div>
		</div>

		<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">Empresa</a> <a id="empresa"><sf:input
						name="empresa" path="empresa" type="text" /></a>
			</div>
			<div class="entrada-pista">
				<sf:errors path="empresa"></sf:errors>
			</div>
		</div>

		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<div class="entrada-formulari">
				<div class="entrada-nom">
					<a class="tag tag-blue">Rol</a> <a id="rol"> <sf:select
							class="select" path="authority">
							<sf:option value="ROLE_USER" label="Usuari" />
							<sf:option value="ROLE_ADMIN" label="Administrador" />
						</sf:select>
					</a>
				</div>
				<div class="entrada-pista">
					<sf:errors path="empresa"></sf:errors>
				</div>
			</div>
		</sec:authorize>

		<div class="entrada-formulari">
			<div class="entrada-nom">
				<input class="tag tag-teal" value="Enviar" type="submit" /> <a
					class="tag tag-blue"
					href="<c:url value='/admin-password?username=${user.username}'/>">Modificar
					Password</a>
			</div>
			<div class="entrada-pista"></div>
		</div>

	</sf:form>
</div>
