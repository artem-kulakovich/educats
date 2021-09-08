<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 29.07.2021
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container-fluid">

    <div class="row mt-5"></div>
    <div class="row mt-5">
        <div class="col-3">
            <a class="h3" href="/admin/create-group">Создать группу</a>
        </div>
        <div class="col-6 text-center"><label class="h2">Пользователи:</label></div>
        <div class="col-3"></div>
    </div>
    <div class="row mt">
        <div class="col-3">
            <a class="h3" href="/admin/add-user-to-group">Добавить в группу</a>
        </div>
        <div class="col-6 text-center"></div>
        <div class="col-3"></div>
    </div>
    <div class="row mt-2">
        <div class="col-3">
            <a class="h3" href="/admin/delete-group">Удалить группу</a>
        </div>
        <div class="col-6 text-center"></div>
        <div class="col-3"></div>
    </div>
    <c:forEach var="user" items="${requestScope.userList}">
        <div class="row">
            <div class="col-3"></div>
             <div class="col-3 border">
                <label class="h2 font-italic">${user.userName}</label>
            </div>
            <div class="col-3 border text-right">
                <a href="/admin/user-info/${user.id}"><label class="h2">Подробно</label></a>
            </div>
            <div class="col-3"></div>
        </div>
    </c:forEach>
</div>


</body>
</html>
