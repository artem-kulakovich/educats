<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 30.07.2021
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создать предмет</title>
    <link rel="stylesheet" type="text/css"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row mt-5">
        <div class="col-3"></div>
        <div class="col-md-6 order-md-1 text-center mt-5">
            <h4 class="mb-3">Создание предмета</h4>
            <form class="needs-validation" novalidate="" action="/teacher/create-subject" method="post">
                <div class="mb-3">
                    <label for="name">Название предмета</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="name" name="name" placeholder="subject name">
                    </div>
                </div>
                <button class="btn btn-primary w-50">Добавить</button>
            </form>
        </div>
    </div>
</div>

<script src="../../../static/js/jquery.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
