<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h2 class="text-info text-center font-weight-bold">Add Book</h2>
            <form:form method="post" action="/saveBook" modelAttribute="book">
                <div class="form-group">
                    <form:input type="text" class="form-control" placeholder="ISBN" name="ISBN" path="ISBN"/>
                </div>
                <div class="form-group">
                    <form:input type="text" class="form-control" placeholder="Title" name="title" path="title"/>
                </div>
                <div class="form-group">
                    <form:input type="text" class="form-control" placeholder="Release Year" name="releaseYear" path="releaseYear"/>
                </div>
                <div class="form-group">
                    <form:select class="form-control" name="author" path="author">
                        <form:option value="NONE" label="Select Author:" />
                        <form:options items="${authors}" itemValue="id" label="${author}" />
                    </form:select>
                </div>
                <form:button type="submit" value="submit" class="btn btn-outline-info">Save</form:button>
                <a href="/" type="button" class="btn btn-outline-danger float-right">Cancel</a>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
