<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="heading">
	<ul class="nav">	
		<li class="nav"><a class="button" href="<c:url value='/dominis'/>" title="Dominis">Dominis</a></li>
		<li class="nav"><a class="button" href="<c:url value='/allotjaments'/>" title="Allojtaments">Allotjaments</a></li>		
	</ul>
<div id="cistella">
	<a href="<c:url value='/cistella'/>"><img id="cistella" src="<c:url value='/static/icons/cistella.png'/>" ></img></a>
	<a id="cistella">
	
	<c:if test="${empty productesCistella}">
      0	
	</c:if>	
	
	<c:if test="${!empty productesCistella}">
      <c:out value="${productesCistella.size()}"/>
	</c:if>	
	productes
	</a>
</div>
	
</div>
