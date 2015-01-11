<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<ul style="text-align: left">
	<li><a class="button button-green button-round"
		href="<c:url value="#"/>"><img class="icon12"
			src="<c:url value="/static/icons/new8.png"/>" />Confirmar comanda</a></li>
</ul>

<table id="cistella" class="table">
	<thead class="table-head">
		<tr>
			<th>#</th>
			<th>Producte</th>
			<th>Preu</th>
			
		</tr>
	</thead>
	<tbody class="table-body">

		<c:forEach var="servei" items="${productesCistella}">
			<tr>
				<td><c:out value="${servei.id}"></c:out></td>				
				<td><c:out value="${servei.producte.nom}"></c:out></td>
				<td><c:out value="${servei.producte.preu}"></c:out></td>
				<td>
				<a class="link-eliminar" id="<c:out value="eliminar${servei.id}"/>" href="<c:url value='/cistella?id=${servei.id}&accio=eliminar'/>"><img class="icon24" src="<c:url value='/static/icons/trash3.png'/>" alt="Eliminar"></a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<p />
