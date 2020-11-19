<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/sign-in/">
    <link href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/4.0/examples/sign-in/signin.css" rel="stylesheet">
</head>

<body>
<sec:authorize access="isAuthenticated()">
    <% response.sendRedirect("/"); %>
</sec:authorize>

<form class="form-signin" method="POST" action="/login">
    <img class="mb-4" src="https://seekvectorlogo.com/wp-content/uploads/2019/01/coursera-vector-logo.png"  alt="" width="300" height="200">
    <h1 class="h3 mb-3 font-weight-normal">Вход в систему</h1>
    <label for="username" class="sr-only">Username</label>
    <input type="text" id="username" name="username" class="form-control" placeholder="Username" required="" autofocus="">
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required="">
    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="remember-me"> Remember me
        </label>
    </div>
    <h4><a href="/registration">Зарегистрироваться</a></h4>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
    <p class="mt-5 mb-3 text-muted">© 2017-2018</p>
</form>

</body>
</html>