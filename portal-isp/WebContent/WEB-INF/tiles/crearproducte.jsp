<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	function onDeleteClick(event) {

		var doDelete = confirm("Estas segur d'eliminar aquest producte?");

		if (doDelete == false) {
			event.preventDefault();
		}

	}

	function onReady() {
		$("#delete").click(onDeleteClick);
	}

	$(document).ready(onReady);
</script>


<sf:form method="post"
	action="${pageContext.request.contextPath}/docrearproducte"
	commandName="producte">
	<sf:input type="hidden" name="id" path="id" />
	<table class="taula">


		<tr>
			<td>Your offer:</td>
			<td><sf:textarea name="text" path="text" rows="10" cols="10"></sf:textarea><br />
				<sf:errors path="text" cssClass="error"></sf:errors></td>
		</tr>
		<tr>
			<td></td>
			<td><input value="Guardar producte" type="submit" /></td>
			<c:if test="${producte.id != 0}">
				<td>&nbsp;</td>
				<td><input class="delete" value="Eliminar aquest producte"
					name="delete" type="submit" id="delete" /></td>
			</c:if>
		</tr>


	</table>

</sf:form>


