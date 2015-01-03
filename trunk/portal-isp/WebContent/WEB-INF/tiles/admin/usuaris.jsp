<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<table class="table">
	<thead class="table-head">
		<td>Usuari</td>
		<td>Nom</td>
		<td>ROL</td>
	</thead>
	<tbody class="table-body">

	<c:forEach var="usuari" items="${usuaris}">
		<tr>

			<td><c:out value="${usuari.nom}"></c:out></td>

			<td><c:out value="${usuari.email}"></c:out></td>

			<td><c:out value="${usuari.authority}"></c:out></td>

		</tr>
	</c:forEach>
	</tbody>
</table>

<p/>


