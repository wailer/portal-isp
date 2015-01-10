<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="home">
	<div class="cerca-domini">

		<p class="search">
			<input id="domini" type="search"></input><a id="comprovar" class="button button-blue" href="#">Comprovar</a>
		</p>

	</div>
	<div class="llista-extensions">

		<ul class="extensions">
			<c:forEach var="extensio" items="${extensions}">
				<li class="extensions">.<c:out
								value="${extensio}" /><label class="option"> <input
						type="checkbox" id="<c:out
								value="${extensio}" />"
						value="<c:out
								value="${extensio}" />"></input> <a
						class="checkbox blue"></a>

				</label></li>

			</c:forEach>
		</ul>
	</div>

</div>