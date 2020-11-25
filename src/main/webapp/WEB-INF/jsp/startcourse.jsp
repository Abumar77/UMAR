<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Courses</title>
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div>

    <div >
        <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
            <h5 class="my-0 mr-md-auto font-weight-normal">Coursera</h5>
            <nav class="my-2 my-md-0 mr-md-3">
                <a class="p-2 text-dark" href="/">Главное</a>
                <a class="p-2 text-dark" href="/news">Новости (Users)</a>
                <a class="p-2 text-dark" href="/about">О нас</a>
                <a class="p-2 text-dark" href="/admin" >Админ</a>
                <b>${pageContext.request.userPrincipal.name}</b>

                <sec:authorize access="isAuthenticated()">
                    <a class="btn btn-outline-primary" href="/logout">Выйти</a>
                </sec:authorize>
            </nav>
        </div>
    </div>




    <div class="container mt-5">
        <c:forEach items="${allCourses}" var="course">
            <div class="col-md-4">

                <div class="card h-100">
                    <a href="#"><img class="card-img-top" src="" alt=""></a>
                    <div class="card-body">
                        <h4 class="card-title">
                            <h1>${course.cname}</h1>
                        </h4>
                        <h5>${course.cprice} $ </h5>
                        <p class="card-text">${course.description};</p>
                        <a href="/courses/${course.cid}/start" class="btn btn-lg btn-primary" type="submit">Start the Course</a>
                    </div>
                     </div>
                </div>
        </c:forEach>

    </div>


</div>

<br><br><br>
<footer class="text-muted">
    <div class="container">
        <p class="float-right">
            <a href="/courses">Back to top</a>
        </p>
        <p>© 2020 Coursera Inc. All rights reserved.</p>
     </div>
</footer>
</body>
</html>