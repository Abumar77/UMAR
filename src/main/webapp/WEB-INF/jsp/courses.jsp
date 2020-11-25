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
        <div class="alert alert-info mt-2"0><h3>${course.cname};</h3>
            <br>
        <p>${course.description};</p>
            <br>
            <p>  <b>Price:</b> ${course.cprice} $ ;</p>
            <br>
            <button class="btn btn-lg btn-primary" type="submit">More Details</button>

        </div>
        </c:forEach>
    </div>

</div>


<footer class="text-muted">
    <div class="container">
        <p class="float-right">
            <a href="#">Back to top</a>
        </p>
        <p>Album example is © Bootstrap, but please download and customize it for yourself!</p>
        <p>New to Bootstrap? <a href="https://getbootstrap.com/">Visit the homepage</a> or read our <a href="/docs/4.5/getting-started/introduction/">getting started guide</a>.</p>
    </div>
</footer>
</body>
</html>