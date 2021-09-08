<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 30.07.2021
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="row mt-2"></div>
<c:forEach var="group" items="${requestScope.groupList}">
    <div class="row">
        <div class="col-3 h3">
            <a href="/admin/add-user-to-group/${group.id}">${group.name}</a>
        </div>
    </div>


</c:forEach>

</body>
</html>
