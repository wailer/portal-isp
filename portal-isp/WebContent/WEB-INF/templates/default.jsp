<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="cat"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="cat"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="cat"> <![endif]-->
<!--[if gt IE 8]><!-->
<html lang="cat">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/static/css/header.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery-1.11.2.min.js"></script>
<!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->

<title><tiles:insertAttribute name="title">
	</tiles:insertAttribute></title>

<tiles:insertAttribute name="includes"></tiles:insertAttribute>
</head>
<body>
	<div class="header"> 
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</div>
	<div class="nav">
		<tiles:insertAttribute name="nav"></tiles:insertAttribute>
	</div>
	<div class="content">
		<tiles:insertAttribute name="content"></tiles:insertAttribute>
	</div>
	<div class="footer">
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>
</body>
</html>