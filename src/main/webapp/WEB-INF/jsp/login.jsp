<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<jsp:include page="blocks/head.jsp"/>
<body>
<jsp:include page="blocks/bootstrap-scripts.jsp"/>
<jsp:include page="blocks/header-noauth.jsp"/>

<div class="container-sm my-container">
    <form class="px-sm-1 py-sm-0" action="${pageContext.request.contextPath}/login" method="post">
        <h1>Авторизация</h1>
        <div class="md-3">
            <label for="exampleDropdownFormEmail1" class="form-label">Электронная почта</label>
            <input type="email" class="form-control" id="exampleDropdownFormEmail1" name="username" placeholder="email"
                   required>
        </div>
        <div class="mb-sm-6">
            <label for="exampleDropdownFormPassword1" class="form-label">Пароль</label>
            <input type="password" class="form-control" id="exampleDropdownFormPassword1" name="password"
                   placeholder="Password" required>
        </div>
        <br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button id="btn" type="submit" class="btn btn-primary">Войти</button>
    </form>
    <div class="dropdown-divider"></div>
    <p><a href="${pageContext.request.contextPath}/registration">Впервые на этом сайте? Зарегистрируйтесь</a></p>
    <p><a href="<c:url value="/"/>">Продолжить как гость</a></p>
</div>
</body>
</html>