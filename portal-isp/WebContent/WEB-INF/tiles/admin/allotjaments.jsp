<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<ul style="text-align: left">
	<li><a class="button button-green button-round"
		href="<c:url value="/admin-allotjament"/>"><img class="icon12"
			src="<c:url value="/static/icons/new8.png"/>" /> Crear Allotjament</a></li>
</ul>

<table class="table">
	<thead class="table-head">
		<tr>
			<th>Codi</th>
			<th>Nom</th>
			<th>Descripcio</th>			
			<th>Dominis</th>
			<th>Espai</th>			
			<th>Bústies</th>
			<th>Estat</th>
			<th>Destacat</th>
			<th>Preu</th>
		</tr>
	</thead>
	<tbody class="table-body">

		<c:forEach var="allotjament" items="${allotjaments}">
			<tr>
				<td><c:out value="${allotjament.codi}"></c:out></td>
				<td><c:out value="${allotjament.nom}"></c:out></td>
				<td><c:out value="${allotjament.descripcio}"></c:out></td>
				<td><c:out value="${allotjament.dominis}"></c:out></td>
				<td><c:out value="${allotjament.espai}"></c:out></td>
				<td><c:out value="${allotjament.busties}"></c:out></td>
				<td><c:out value="${allotjament.actiu}"></c:out></td>
				<td><c:out value="${allotjament.destacat}"></c:out></td>
				<td><c:out value="${allotjament.preu}"></c:out></td>
				<td><a
					href="<c:url value='/admin-allotjament?codi=${allotjament.codi}'/>"><img class="icon24" src="<c:url value='/static/icons/edit4.png'/>" alt="Editar"></a>
				<a class="link-eliminar" id="<c:out value="eliminar${allotjament.codi}"/>" href="<c:url value='/admin-allotjament?codi=${allotjament.codi}&action=delete'/>"><img class="icon24" src="<c:url value='/static/icons/trash3.png'/>" alt="Eliminar"></a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<p />
