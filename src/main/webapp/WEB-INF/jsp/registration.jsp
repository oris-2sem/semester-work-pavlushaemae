<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<jsp:include page="blocks/head.jsp"/>
<body>
<jsp:include page="blocks/bootstrap-scripts.jsp"/>
<jsp:include page="blocks/header-noauth.jsp"/>

<div class="container-sm my-container">
    <form class="px-sm-1 py-sm-0 needs-validation" action="/registration" method="post">
        <h1>Регистрация</h1>
        <div class="md-3">
            <label for="exampleDropdownFormEmail" class="form-label">Ваш никнейм</label>
            <input type="text" class="form-control" id="exampleDropdownFormEmail" name="nickname" placeholder="nickname"
                   required>
        </div>
        <div class="md-3">
            <label for="exampleDropdownFormEmail1" class="form-label">Ваша электронная почта</label>
            <input type="email" class="form-control" id="exampleDropdownFormEmail1" name="email" placeholder="email"
                   required>
        </div>
        <c:if test="${errorMessage != null}">
            <p style="color: red">${errorMessage}</p>
        </c:if>
        <div class="md-3">
            <label for="exampleDropdownFormPhone" class="form-label">Номер телефона</label>
            <input type="text" class="form-control" id="exampleDropdownFormPhone" name="phone" placeholder="phone"
                   required>
        </div>
        <div class="mb-sm-6">
            <label for="exampleDropdownFormPassword1" class="form-label">Пароль</label>
            <input type="password" class="form-control" id="exampleDropdownFormPassword1" name="password"
                   placeholder="Password" required>
        </div>
        <br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button id="btn" type="submit" class="btn btn-primary">Зарегистрироваться</button>
    </form>
    <div class="dropdown-divider"></div>
    <p><a href="<c:url value="/"/>">Продолжить как гость</a></p>
</div>
</body>
</html>
