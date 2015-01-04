<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<c:set var="estil-error" value="entrada-error" scope="page" />

<div class="formulari">
	<sf:form method="post"
		action="${pageContext.request.contextPath}/crearusuari"
		commandName="user">

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
				<a class="tag tag-blue">Rol</a> <a id="rol">
				 <sf:select class="select" path="authority">
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
				<a class="tag tag-blue">Password</a> <a id="password"><sf:input
						id="password" name="password" path="password" type="password" /></a>
			</div>
			<div class="entrada-pista">
				<sf:errors path="password"></sf:errors>
			</div>
		</div>

		<div class="entrada-formulari">
			<div class="entrada-nom">
				<a class="tag tag-blue">Confirmar Password</a><a
					id="confirmpassword"><input id="confirmpassword"
					name="confirmpassword" class="control" type="password" /></a>
			</div>
			<div class="entrada-pista">
				<div id="passwordMatch"></div>
			</div>
		</div>

		<div class="entrada-formulari">
			<div class="entrada-nom">
				<input class="tag tag-teal" value="Enviar" type="submit" />
			</div>
			<div class="entrada-pista"></div>
		</div>

	</sf:form>
</div>
