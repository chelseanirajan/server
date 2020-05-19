<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="url" value="${pageContext.request.serverName}:${pageContext.request.serverPort}"/>
<div class="container">
    <button type="button" id="add-entry" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
        Add New Advertisement
    </button>
    <div class="row text-center">
        <div class="col-md-12">
            <table id="example" class="table table-striped table-bordered" style="width:100%">
                <tr>
                    <th>Advertisement Id</th>
                    <th>Post</th>
                    <th>Level</th>
                    <th>Service</th>
                    <th>Deadline</th>
                    <th>Double Payment Date</th>
                    <td>Operation</td>
                </tr>
            </table>
        </div>
    </div>
</div>
<script>
    var datatablesOptions = {};
    $(document).ready(function () {
        $('#example').DataTable(datatablesOptions);
    });
</script>