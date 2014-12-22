<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<title>Nou Usuari</title>

</head>
<body>

<sf:form method="post" action="${pageContext.request.contextPath}/crearusuari" commandName="user">
<table class="taula">

<tr><td>Name: </td><td><sf:input name="name" path="username" type="text" /><br/><div class="error"><sf:errors path="username"></sf:errors></div></td></tr>
<tr><td>Email: </td><td><sf:input name="email" path="email" type="text" /><br/><div class="error"><sf:errors path="email"></sf:errors></div></td></tr>
<tr><td>Password: </td><td><sf:input id="password" name="password" path="password" type="password" /><br/><div class="error"><sf:errors path="password"></sf:errors></div></td></tr>
<tr><td>Confirmar Password: </td><td><input id="confirmpassword" class="control" name="confirmpassword"  type="password" /><div id="passwordMatch"></div></td></tr>
<tr><td></td><td><input value="Crear producte" type="submit" /></td></tr>


</table>

</sf:form>




</body>
</html>