<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 27.07.2021
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row mt-5">
        <div class="col-3"></div>
        <div class="col-md-6 order-md-1 text-center mt-5">
            <h4 class="mb-3">Добро пожаловать</h4>
            <form:form class="needs-validation" action="/sign-up" method="post" modelAttribute="user">
                <div class="mb-3">
                    <label for="username">Имя аккаунта</label>
                    <div class="input-group">
                        <form:input path="userName" class="form-control" id="username"
                                    placeholder="Username"></form:input>
                        <form:errors path="userName"></form:errors>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="password">Пароль</label>
                    <form:password path="password" id="password" class="form-control"
                                   placeholder="Password"></form:password>
                    <form:errors path="password"></form:errors>
                </div>
                <div class="mb-3">
                    <label for="repeat_password">Повторите пароль</label>
                    <form:password path="repeatPassword" id="repeat_password" class="form-control"
                                   placeholder="Password"></form:password>
                </div>
                <p>У вас есть аккаунта? <a href="/sign-in">Войти</a></p>
                <button class="btn btn-primary w-50">Зарегестрироваться</button>
            </form:form>
        </div>
    </div>
</div>
<script src="../../../static/js/jquery.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
