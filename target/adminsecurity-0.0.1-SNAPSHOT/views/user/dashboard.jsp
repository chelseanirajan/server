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
                    <button class="button btn-primary"><a href="/user/student/edit?id=${student.id}">
                    Edit</a></button>
                    <button class="button btn-secondary"><a href="/user/student/details?id=${student.id}">
                        Details</a></button>
                    <button class="button btn-danger"><a href="/user/student/delete?id=${student.id}"
                                                         class="button btn-danger"
                                                         onclick="return confirm('Do you want to delete?')">
                        Delete</a></button>
                </td>
                <td><input type="checkbox" name="checkIds" value="${student.id}">  </td>
            </tr>
        </c:forEach>
    </table>
</form:form>
</div>
<h1>${message}</h1>
<%@include file="footer.jsp"%>