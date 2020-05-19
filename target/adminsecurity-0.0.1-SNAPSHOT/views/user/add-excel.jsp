<%@include file="header.jsp"%>
<div class="container">
    <div class="py-5 text-center">
        <h2>Upload Excel File to MySQL</h2>
        <form method="POST"  action="${contextPath}/user/student/nn?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
            <div class="form-group">
                <label class="control-label">Upload File:</label>
                <input type="file" class="form-control" placeholder="Upload File" name="uploadfile" />
            </div>
            <button type="submit" class="btn btn-primary" id="btnSubmit">Upload</button>
            <button type="button" class="btn btn-secondary"
                    name="back"
                    onclick="window.history.back()">Back</button>
        </form>
        <div>
            <h3>${message}</h3>

        </div>
    </div>

    <h1>${message}</h1>
</div>
<%@include file="footer.jsp"%>
