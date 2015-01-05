<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:if test="${!empty missatge}">
	<c:choose>
		<c:when test="${!missatge.error}">
			<c:set var="estilCss" value="alert notice" />
		</c:when>
		<c:otherwise>
			<c:set var="estilCss" value="alert" />
		</c:otherwise>
	</c:choose>

	<p class="<c:out value="${estilCss}"/>">
		<fmt:message key="${missatge.key}" />
	</p>

</c:if>