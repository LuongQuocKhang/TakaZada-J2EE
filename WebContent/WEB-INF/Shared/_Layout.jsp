<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<!-- for-mobile-apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Women's Fashion Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script src="<c:url value="/Resources/Scripts/jquery-3.3.1.min.js"/>"></script>
    <script type="application/x-javascript">
        addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
               function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- //for-mobile-apps -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
    <link href="${pageContext.request.contextPath}/Resources/Content/css/style.css" rel="stylesheet" />
    <link href="<c:url value="/Resources/Content/css/bootstrap.css"/>" rel="stylesheet" />
    <link href="<c:url value="/Resources/Content/css/fasthover.css"/>" rel="stylesheet" />
    <!-- js -->
    <!-- //js -->
    <!-- countdown -->
    <script src="<c:url value="/Resources/Scripts/js/jquery.countdown.js"/>"></script>
    <!-- //countdown -->
    <!-- cart -->
    <script src="<c:url value="/Resources/Scripts/js/simpleCart.min.js"/>"></script>
    <!-- cart -->
    <!-- for bootstrap working -->
    <script src="<c:url value="/Resources/Scripts/bootstrap.min.js"/>"></script>
    <!-- //for bootstrap working -->
    <link href='//fonts.googleapis.com/css?family=Glegoo:400,700' rel='stylesheet' type='text/css'>
    <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
    <!-- start-smooth-scrolling -->
    <style>
        select {
            outline: none;
            background: none;
            display: inline-block;
            color: #fff;
            font-size: 14px;
            border: 1px solid #999;
            width: 100%;
        }
        option {
            color: black;
        }
        .itemImage {
        width: 200px;height:215px;mix-blend-mode: multiply;}
    </style>
</head>
<body>
	<tiles:insertAttribute name="login" />
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="navigation" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
</body>
</html>