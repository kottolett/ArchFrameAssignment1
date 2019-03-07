<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kotto
  Date: 29.01.19
  Time: 09:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header.jsp"></jsp:include>
<body>
<div class="container">
    <div class="row my-5">
        <div class="col-sm-10 mx-auto">
            <h2 class="text-info text-center font-weight-bold">Authors</h2>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Nationality</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="author" items="${authors}">
                    <tr>
                        <td>${author.id}</td>
                        <td>${author.firstName}</td>
                        <td>${author.lastName}</td>
                        <td>${author.nationality}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="/addAuthor" class="btn btn-outline-info" role="button">Add author</a>
        </div>
    </div>
    <div class="row my-5">
        <div class="col-sm-10 mx-auto">
            <h2 class="text-info text-center font-weight-bold">Registered Books</h2>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">ISBN</th>
                    <th scope="col">Title</th>
                    <th scope="col">Release Year</th>
                    <th scope="col">Author</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td>${book.ISBN} </td>
                        <td>${book.title}</td>
                        <td>${book.releaseYear}</td>
                        <td>${book.author}</td>
                        <td>
                            <a href="/editBook/${book.ISBN}" class="btn btn-white btn-lg text-warning"><i class="fas fa-edit"></i> </a>
                        </td>
                        <td>
                            <a href="/deleteBook/${book.ISBN}" class="btn btn-white btn-lg text-danger"> <i class="fas fa-trash-alt"></i>  </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="/addBook" class="btn btn-outline-info" role="button">Add book</a>
        </div>
    </div>
</div>
</body>
</html>
