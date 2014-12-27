<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<table class="productes">
	<tr>
		<td>Name</td>
		<td>Email</td>
		<td>Offer</td>
	</tr>

	<c:forEach var="producte" items="${productes}">
		<tr>

			<td><c:out value="${producte.user.name}"></c:out></td>

			<td><c:out value="${producte.user.email}"></c:out></td>

			<td><c:out value="${producte.text}"></c:out></td>

		</tr>
	</c:forEach>
</table>

<p/>

<a href="${pageContext.request.contextPath}/editar-productes">Editar Productes</a>



<table class="formtable">
<tr><td>Username</td><td>Email</td><td>Role</td><td>Enabled</td></tr>

<c:forEach var="user" items="${users}">

<tr><td><c:out value="${user.username}"></c:out></td>
<td><c:out value="${user.email}"></c:out></td>
<td><c:out value="${user.authority}"></c:out></td>
<td><c:out value="${user.enabled}"></c:out></td>

</tr>

</c:forEach>

</table>
    