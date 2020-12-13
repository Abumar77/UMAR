<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>
    <table>
        <thead>
        <th>ID</th>
        <th>UserName</th>
        <th>Password</th>
        <th>Roles</th>
        <th>Courses</th>
        </thead>
        <c:forEach items="${allUsers}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>
                    <c:forEach items="${user.roles}" var="role">${role.name}; </c:forEach>
                </td>
                <td>
                    <c:forEach items="${user.courses}" var="course">${course.cname}; </c:forEach>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/admin" method="post">
                        <input type="hidden" name="userId" value="${user.id}"/>
                        <input type="hidden" name="action" value="delete"/>
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        <br><br><br>
        <h1>Want to upload files for lessons?</h1>
        <form:form method = "POST" modelAttribute = "form"
                   enctype = "multipart/form-data">
            Please select a file to upload :
            <input type = "file" name = "file"  />
            <input type = "submit" value = "upload" />
        </form:form>

        <br><br><br>

        <script>

            var form = new FormData();
            form.append("file", "CROPPED-IMG_3236.JPG");

            var settings = {
                "async": true,
                "crossDomain": true,
                "url": "http://localhost:8080/storage/uploadFile/2",
                "method": "POST",
                "headers": {
                    "cache-control": "no-cache",
                    "postman-token": "fadb96b9-e7b8-0855-77d2-c0075565df8e"
                },
                "processData": false,
                "contentType": false,
                "mimeType": "multipart/form-data",
                "data": form
            }

            $.ajax(settings).done(function (response) {
                console.log(response);
            });
        </script>
    </table>
    <a href="/">Главная</a>
</div>
</body>
</html>