<%--
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/> --%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student Manager</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/common/nav.css"/>
    <script type="text/javascript" src="${contextPath}/resources/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="" href="${contextPath}/resources/css/font-awesome.min.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>
<c:set var="tab" value="${pageContext.request.getAttribute('url')}"/>
<c:set var="userProfile" value="${pageContext.request.session.getAttribute('userProfile')}"/>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<header class="header" style="margin-top:10px;">
    <article class="container">
        <div style="float:left;">
            <div>
                <img class="mb-4" src="${contextPath}/resources/images/4jugal.png" alt="" width="95" height="80">
                <div class="float-right">
                    <h2 >Jugal Rural Municipality</h2>
                    <h4>Recruitment Management System</h4>
                </div>
            </div>
            <p style="font-size: 22px;font-variant: small-caps;font-weight: 500;">
                <a href="">Welcome ${userProfile.username}</a>
            </p>
        </div>
        <div style="float: right;text-align: right;">
            <ul style="list-style: none; padding: 0;">
                <%--  <li><i class="fa fa-phone"></i> ${userProfile.rollNo}</li>
                                       <sec:authorize access="hasRole('ROLE_ADMIN')">--%>
                <%--                              <a href="#">Go to User</a>--%>
                <%--                              <a href="#">Go to Admin</a>
                <%--                       </sec:authorize>--%>
                    <%-- <li><i class="fa fa-envelope"></i> <a href="#">${userProfile.schoolName}</a></li>--%>
                <li style="margin-left: 10px;display: inline-block;list-style: none;">
                    <i class="fa fa-phone" style="margin-right: 5px;"></i> <a href="#" onclick="document.forms['logoutForm'].submit()">Logout</a></li>
            </ul>
        </div>
    </article>
</header>
<form id="logoutForm" method="POST" action="${contextPath}/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<header class="navbar navbar-inverse bs-docs-nav" role="banner">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="./" class="navbar-brand">${userProfile.username} Menu</a>
        </div>
        <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
            <ul class="nav navbar-right">
                <li class="nav-item" >
                    <a href="${contextPath}/user">Home</a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">About <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Mission</a></li>
                        <li><a href="#">Vision</a></li>
                        <li><a href="#">Careers</a></li>
                    </ul>
                </li>
                <li class=" nav-item">
                    <a href="#">Service</a>
                </li>
                <li class=" nav-item">
                    <a href="/user/student">Add Student</a>
                </li>
                <li class=" nav-item">
                    <a href="/user/student/excel">Download Excel</a>
                </li>
                <li>
                    <a href="/file">Upload File</a>
                </li>
                <li>
                    <a href="#">Contact</a>
                </li>
            </ul>
        </nav>
    </div>
</header>