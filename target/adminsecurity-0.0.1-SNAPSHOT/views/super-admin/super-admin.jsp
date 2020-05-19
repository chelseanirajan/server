<%@include file="header.jsp"%>
<div class="container">
    <br/><br/>
    <center>
        <form:form action="${applicationContext}/user/student/search">
            <input type="text" name="searchName" placeholder="Search user" />
            <i class="fa fa-search"></i><input type="submit" value="Search" />
        </form:form></center>
    <br>
        <form:form method="POST" action="/user/student/checked" >
        <table class="table table-bordered table-hover table-striped">
            <tr>
                <th>id</th>
                <th>Name</th>
                <th>Symbol No</th>
                <th>School Name</th>
                <th>Roll No</th>
                <th>Date of Birth</th>
                <th>Actions</th>
                <th><input type = "submit" value = "Get Result of Selected Item" formtarget="_blank"/>
                </th>
            </tr>
            <c:forEach var="student" items="${student}" varStatus="loop">

                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.symbolNo}</td>
                    <td>${student.schoolName}</td>
                    <td>${student.rollNo}</td>
                    <td>${student.doB}</td>
                    <td>
                        <a href="/user/student/edit?id=${student.id}" class="btn btn-primary btn-sm">
                            <span class="glyphicon glyphicon-pencil"></span> Edit
                        </a>
                        <a href="/user/student/details?id=${student.id}" class="btn btn-info btn-sm">
                            <span class="glyphicon glyphicon-list-alt"></span> Details
                        </a>
                        <a href="/user/student/delete?id=${student.id}" class="btn btn-danger btn-sm" onclick="return confirm('Do you want to delete?')">
                            <span class="glyphicon glyphicon-trash"></span> Delete
                        </a>
                    </td>

                    <td><input type="checkbox" name="checkIds" value="${student.id}">  </td>

                </tr>
            </c:forEach>
        </table>
        </form:form>
</div>
<h1>${message}</h1>
<%@include file="footer.jsp"%>


<%--
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="url" value="${pageContext.request.serverName}:${pageContext.request.serverPort}"/>
<!DOCTYPE html>
<html lang="en">

<body>

<div class="container">
    <a href="/super-admin/">Go to SuperAdmin</a>
    <a href="/admin/">Go to Admin</a>
    <button type="button" id="add-entry" class="btn btn-primary text-left" data-toggle="modal"
            data-target="#exampleModalCenter">
        Add New Admin
    </button>
    <div class="row text-center">
        <div class="col-md-12">
            <table id="example" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>Username</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${admins}" var="user" varStatus="loop">
                    <tr>
                        <td>${user.username}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-12">
                            <form:form method="POST" id="adminForm" modelAttribute="userForm" class="form-signup">
                                <h2 class="form-signin-heading">Create Admin</h2>
                                <input type="hidden" id='id' name="id" value="${userForm.id}">
                                <spring:bind path="username">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <form:input type="text" path="username" class="form-control"
                                                    placeholder="Username"
                                                    autofocus="true"></form:input>
                                        <form:errors path="username"></form:errors>
                                    </div>
                                </spring:bind>


                                <spring:bind path="password">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <form:input type="password" path="password" class="form-control"
                                                    placeholder="Password"></form:input>
                                        <form:errors path="password"></form:errors>
                                    </div>
                                </spring:bind>

                                <spring:bind path="passwordConfirm">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <form:input type="password" path="passwordConfirm" class="form-control"
                                                    placeholder="Confirm your password"></form:input>
                                        <form:errors path="passwordConfirm"></form:errors>
                                    </div>
                                </spring:bind>
                            </form:form>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" data-dismiss="modal" type="submit">Close</button>
                    <button id='submitform' type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>

</div>
<%@ include file="header.jsp"%>
</body>
</html>
<%@include file="footer.jsp"%>

    $('#submitform').on('click', function () {
        $('#adminForm').submit();
    });
    $(window).on('load', function () {
        if ('${id}') {
            $('#add-entry').click();
        }
    });
</script>
<script>
    var datatablesOptions = {};
    $(document).ready(function () {
        $('#example').DataTable(datatablesOptions);
    });
</script>
--%>
