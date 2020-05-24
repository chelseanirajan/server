<%@include file="header.jsp"%>
<div class="container">
    <div class="d-inline-block bg-warning" style="width:170px; height: 80px;">
        <h3>10 <span class="glyphicon glyphicon-user" style="float:right; padding-right: 20px"></span> </h3>
        Parent
    </div>
    <div class="d-inline-block bg-info" style="margin-left: 100px; width:170px; height: 80px;">
        <h3>15 <span class="glyphicon glyphicon-book" style="float:right; padding-right: 20px"></span> </h3>
        Student
    </div>
    <div class="d-inline-block bg-success" style="margin-left: 100px; width:170px; height: 80px;">
        <h3>20 <span class="glyphicon glyphicon-education" style="float:right; padding-right: 20px"></span> </h3>
        Teacher
    </div>
    <div class="d-inline-block bg-secondary" style="margin-left: 100px; width:170px; height: 80px;">
        <h3>20 <span class="glyphicon glyphicon-tasks" style="float:right; padding-right: 20px"></span> </h3>
        Teacher
    </div>
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