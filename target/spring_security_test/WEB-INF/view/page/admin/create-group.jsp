<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 29.07.2021
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Создать группу</title>
    <link rel="stylesheet" type="text/css"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row mt-5">
        <div class="col-3"></div>
        <div class="col-md-6 order-md-1 text-center mt-5">
            <h4 class="mb-3">Добро пожаловать</h4>
            <form:form class="needs-validation" action="/admin/create-group" method="post" modelAttribute="group">
                <div class="mb-3">
                    <label for="name">Название группы</label>
                    <div class="input-group">
                        <form:input path="name" class="form-control" id="name" placeholder="group_name"></form:input>
                        <form:errors path="name"></form:errors>
                    </div>
                </div>
                <button class="btn btn-primary w-50">Cоздать группу</button>
            </form:form>
        </div>
    </div>
</div>
<script src="../../../static/js/jquery.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
