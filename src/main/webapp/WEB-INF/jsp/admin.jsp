<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pavel
  Date: 07.05.2023
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="blocks/head.jsp"/>
<body>
<jsp:include page="blocks/bootstrap-scripts.jsp"/>
<jsp:include page="blocks/header-noauth.jsp"/>
<h4>Панель администратора</h4>
<table class="table table-hover table-dark">
    <tr>
        <th>Email</th>
        <th>Номер телефона</th>
        <th>Активность</th>
        <th>Роли</th>
        <th>Бан</th>
        <th>Редактирование</th>
        <th>Подробная информация</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <th>${user.email}</th>
            <th>${user.phone}</th>
            <th>
                <c:if test="${user.active}">
                    active
                </c:if>
                <c:if test="${!user.active}">
                    not active
                </c:if>
            </th>
            <th>
                <c:forEach var="role" items="${user.roles}">
                    ${role}
                </c:forEach>
            </th>
            <th>
                <form action="/admin/user/ban/${user.id}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Бан"/>
                </form>
            </th>
            <th><a href="/admin/user/edit/${user.id}">Редактирование</a></th>
            <th><a href="/user/${user.id}">Подробная информация</a></th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
