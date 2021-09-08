<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 30.07.2021
  Time: 0:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Выберите студентов</title>
    <link rel="stylesheet" type="text/css"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
    <c:forEach var="user" items="${requestScope.userList}">
        <div class="row">
            <div class="col-4">
                <label class="h3">Имя: ${user.userName}</label>
                <label class="h3">Роль: ${user.role.name}</label>
            </div>
            <div class="col-3">
                <form method="post" action="/admin/add-user-to-group">
                    <input type="hidden" name="groupId" value="${requestScope.group.id}">
                    <input type="hidden" name="userId" value="${user.id}">
                    <button type="submit" class="btn-outline-warning">Добавить в группу</button>
                </form>
            </div>
        </div>
    </c:forEach>
</div>

<script src="../../../../static/js/jquery.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
