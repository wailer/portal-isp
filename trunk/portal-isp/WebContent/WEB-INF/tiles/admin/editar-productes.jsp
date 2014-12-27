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

<a href="${pageContext.request.contextPath}/crearproducte">Edit or delete your current offer.</a>
