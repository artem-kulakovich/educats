<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 29.07.2021
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить роль</title>
    <link rel="stylesheet" type="text/css"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row mt-5">
        <div class="col-3"></div>
        <div class="col-md-6 order-md-1 text-center mt-5">
            <form class="needs-validation" novalidate="" action="/admin/edit-role" method="post">
                <div class="mb-3">
                    <label for="role">Имя аккаунта</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="role" name="role" value="${requestScope.user.role.name}">
                        <input type="hidden" name="userId" value="${requestScope.user.id}">
                    </div>
                </div>
                <button type="submit" class="btn-warning">Изменить</button>
            </form>
        </div>
    </div>
</div>

<script src="../../../static/js/jquery.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
