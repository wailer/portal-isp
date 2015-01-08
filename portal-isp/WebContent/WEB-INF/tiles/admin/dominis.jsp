<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<ul style="text-align: left">
	<li><a class="button button-green button-round"
		href="<c:url value="/admin-domini"/>"><img class="icon12"
			src="<c:url value="/static/icons/new8.png"/>" /> Crear Domini</a></li>
</ul>

<table class="table">
	<thead class="table-head">
		<tr>
			<th>Codi</th>
			<th>Nom</th>
			<th>Extensio</th>
			<th>Descripció</th>			
			<th>Preu</th>
			<th>Estat</th>
		</tr>
	</thead>
	<tbody class="table-body">

		<c:forEach var="domini" items="${dominis}">
			<tr>
				<td><c:out value="${domini.codi}"></c:out></td>
				<td><c:out value="${domini.nom}"></c:out></td>
				<td><c:out value="${domini.extensio}"></c:out></td>
				<td><c:out value="${domini.descripcio}"></c:out></td>
				<td><c:out value="${domini.preu}"></c:out></td>
				<td><c:out value="${domini.actiu}"></c:out></td>
				<td><a
					href="<c:url value='/admin-domini?codi=${domini.codi}'/>"><img class="icon24" src="<c:url value='/static/icons/edit4.png'/>" alt="Editar"></a>
				<a class="link-eliminar" id="<c:out value="eliminar${domini.codi}"/>" href="<c:url value='/admin-domini?codi=${domini.codi}&action=delete'/>"><img class="icon24" src="<c:url value='/static/icons/trash3.png'/>" alt="Eliminar"></a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<p />
