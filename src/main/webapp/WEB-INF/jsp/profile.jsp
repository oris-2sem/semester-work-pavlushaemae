<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<jsp:include page="blocks/head.jsp"/>
<body>
<jsp:include page="blocks/bootstrap-scripts.jsp"/>
<jsp:include page="blocks/header-primary.jsp"/>
<h1 style="text-align: center">Личный кабинет</h1>
<hr>
<br>
<div style="text-align: center">
    <h2>${user.nickname}</h2>
    <br>
    Электоронная почта: <b>${user.email}</b>
    <br>
    Номер телефона: <b>${user.phone}</b>
    <br>
    <br>
    <div class="my-container container-sm">
        <c:if test="${user.admin}">
            <a class="btn btn-dark mb-3" style="text-align: center; width: 100%"
               href="/admin">
                Панель администратора
            </a><br>
        </c:if>
        <c:if test="${roles.contains('ROLE_SELLER')}">
            <a class="btn btn-dark mb-3" style="text-align: center; width: 100%"
               href="/product/my-products">
                Мои товары
            </a>
        </c:if>
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit" style="text-align: center; width: 100%" class="btn btn-danger mb-2">
                Выйти из аккаунта
            </button>
        </form>
    </div>
</div>
<c:if test="${orders.size() != 0}">
    <div class="container">
        <h3>Заказы:</h3>
        <c:forEach var="order" items="${orders}">
            <div class="container">
                <p>Заказ: ${order.dateOfCreated}</p>
                <div class="row">
                    <c:forEach var="product" items="${order.products}">
                        <div class="col-md-3" style="max-height: 100px">
                            <div class="card mb-3" style="max-width: 540px; min-height: 100px">
                                <div class="row g-0">
                                    <div class="col-md-4">
                                        <img src="/images/${product.previewImageId}" class="img-fluid rounded-start"
                                             alt="...">
                                    </div>
                                    <div class="col-md-8">
                                        <div class="card-body">
                                            <h5 class="card-title"><a href="/product/${product.id}">${product.title}</a>
                                            </h5>
                                            <p class="card-text">${product.price} руб</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <br>
        </c:forEach>
    </div>
</c:if>
<jsp:include page="blocks/modals.jsp"/>
</body>
</html>
