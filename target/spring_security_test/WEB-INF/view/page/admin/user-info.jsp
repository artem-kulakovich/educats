<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 29.07.2021
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Информация о пользователе</title>
    <link rel="stylesheet" type="text/css"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<c:import url="/WEB-INF/view/fragment/header.jsp"></c:import>

<div class="container-fluid">
    <div class="row mt-5">
        <div class="col-3">
        </div>
        <div class="col-6 text-center border">
            <img src="/media/user.png" height="200vw">
        </div>
        <div class="col-3"></div>
    </div>
    <div class="row">
        <div class="col-3"></div>
        <div class="col-6 border">
            <label class="h2 font-italic">Имя аккаунта: ${requestScope.user.userName}</label>
        </div>
        <div class="col-3"></div>
    </div>
    <div class="row">
        <div class="col-3"></div>
        <div class="col-6 border">
            <c:if test="${requestScope.user.firstName==null}">
                <label class="h2 font-italic">Имя пользователя: Без имени</label>
            </c:if>
            <c:if test="${requestScope.user.firstName!=null}">
                <label class="h2 font-italic">Имя пользователя: ${requestScope.user.userName}</label>
            </c:if>
        </div>
        <div class="col-3"></div>
    </div>
    <div class="row">
        <div class="col-3"></div>
        <div class="col-6 border">
            <c:if test="${requestScope.user.lastName==null}">
                <label class="h2 font-italic">Фамилия пользователя: Без Фамилии</label>
            </c:if>
            <c:if test="${requestScope.user.lastName!=null}">
                <label class="h2 font-italic">Фамилия пользователя: ${requestScope.user.userName}</label>
            </c:if>
        </div>
        <div class="col-3"></div>
    </div>
    <div class="row">
        <div class="col-3"></div>
        <div class="col-4 border">
            <c:if test="${requestScope.user.role==null}">
                <label class="h2 font-italic">Роль пользователя: Без роли</label>
            </c:if>
            <c:if test="${requestScope.user.role!=null}">
                <label class="h2 font-italic">Роль пользователя: ${requestScope.user.role.name}</label>
            </c:if>
        </div>
        <div class="col-2 text-left border">
            <form action="/admin/edit-role" method="get">
                <input type="hidden" name="userId" value="${requestScope.user.id}">
                <button class="btn-outline-secondary w-100 h-100 text-center" type="submit">Изменить</button>
            </form>
        </div>
        <div class="col-3"></div>
    </div>
    <br>
    <div class="row">
        <div class="col-3"></div>
        <div class="col-6 text-center">
            <form action="/admin/add-user" method="post">
                <input type="hidden" name="userId" value="${requestScope.user.id}">
                <button type="submit" class="btn-outline-warning w-50 h-100">Добавить</button>
            </form>
        </div>
        <div class="col-3"></div>
    </div>
</div>

<script src="../../../../static/js/jquery.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
