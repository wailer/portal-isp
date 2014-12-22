<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


	<sf:form method="post"
		action="${pageContext.request.contextPath}/docrearproducte"
		commandName="producte">
		<table class="taula">

			<tr>
				<td>Name:</td>
				<td><sf:input name="name" path="name" type="text" /><br /> <sf:errors
						path="name" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><sf:input name="email" path="email" type="text" /><br />
					<sf:errors path="email" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td>Your offer:</td>
				<td><sf:textarea name="text" path="text" rows="10" cols="10"></sf:textarea><br />
					<sf:errors path="text" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td></td>
				<td><input value="Crear producte" type="submit" /></td>
			</tr>


		</table>

	</sf:form>


