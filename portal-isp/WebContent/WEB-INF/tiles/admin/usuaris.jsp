<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<table class="table">
	<thead class="table-head">
	<tr>
		<th>Usuari</th>
		<th>Nom</th>
		<th>Cognoms</th>
		<th>Email</th>
		<th>Rol</th>
		</tr>
	</thead>
	<tbody class="table-body">

	<c:forEach var="usuari" items="${usuaris}">
		<tr>
			<td><c:out value="${usuari.username}"></c:out></td>
			<td><c:out value="${usuari.nom}"></c:out></td>
			<td><c:out value="${usuari.cognoms}"></c:out></td>
			<td><c:out value="${usuari.email}"></c:out></td>
			<td><c:out value="${usuari.authority}"></c:out></td>
			<td>Editar</td>

		</tr>
	</c:forEach>
	</tbody>
</table>

<p/>


