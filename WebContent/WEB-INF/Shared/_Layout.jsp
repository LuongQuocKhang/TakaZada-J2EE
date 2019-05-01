<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
	<tiles:insertAttribute name="libary" />
</head>
<body>
	<tiles:insertAttribute name="login" />
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="navigation" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
</body>
</html>