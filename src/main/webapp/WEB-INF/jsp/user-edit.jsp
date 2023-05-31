<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pavel
  Date: 07.05.2023
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<jsp:include page="blocks/head.jsp"/>
<body>
<jsp:include page="blocks/bootstrap-scripts.jsp"/>
<jsp:include page="blocks/header-noauth.jsp"/>
<h1 style="text-align: center">Редактирование пользователя ${user.nickname}</h1>
<hr>
<div class="container-sm my-container">
    <form action="/admin/user/edit" method="post">
        <c:forEach var="role" items="${roles}">
            <div>
                <label><input class="form-check-input" type="checkbox"
                              name="${role}" ${user.roles.contains(role) ? "checked" : ""}>${role}</label>
            </div>
        </c:forEach>
        <br>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button class="btn btn-light btn btn-outline-dark btn-lg" type="submit">Сохранить</button>
    </form>
</div>
</body>
</html>
