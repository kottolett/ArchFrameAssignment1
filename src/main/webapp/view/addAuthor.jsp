<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kotto
  Date: 29.01.19
  Time: 09:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header.jsp"></jsp:include>
<body>
<div class="container">
    <div class="row my-5">
        <div class="col-sm-6 mx-auto">
            <h2 class="text-info text-center font-weight-bold">Add Author</h2>
            <form:form method="post" action="/saveAuthor" modelAttribute="author">
                <div class="form-group">
                    <form:input type="text" class="form-control" placeholder="First Name" name="firstName" path="firstName"/>
                </div>
                <div class="form-group">
                    <form:input type="text" class="form-control" placeholder="Last Name" name="lastName" path="lastName"/>
                </div>
                <div class="form-group">
                    <form:input type="text" class="form-control" placeholder="Nationality" name="nationality" path="nationality"/>
                </div>
                <form:button type="submit" class="btn btn-outline-info">Save</form:button>
                <a href="/" type="button" class="btn btn-outline-danger float-right">Cancel</a>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
