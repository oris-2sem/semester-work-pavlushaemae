<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar fixed-top navbar-dark bg-dark n">
    <div class="container-fluid">
        <a class="navbar-brand" href="<c:url value="/"/>"><img src="${pageContext.request.contextPath}/resources/images/fan-solid.svg"> Dragi</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <c:if test="${user.email != null}">
                <li class="nav-item col-6 col-lg-auto">
                    <a class="nav-link" role="button" href="/basket">
                        <img src="${pageContext.request.contextPath}/resources/images/basket-shopping-solid.svg">
                        <small class="d-lg-none ms-2">Basket</small>
                    </a>
                </li>
                <li class="nav-item dropdown col-6 col-lg-auto">
                    <a class="nav-link" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        <img src="${pageContext.request.contextPath}/resources/images/user-solid.svg">
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a class="dropdown-item" href="/profile" role="button">
                                Профиль
                            </a>
                        </li>
<%--                        <li>--%>
<%--                            <form action="${pageContext.request.contextPath}/logout" method="post">--%>
<%--                                <input type="hidden" name="_csrf" value="${_csrf.token}">--%>
<%--                                <input class="dropdown-item" aria-current="page" type="submit"--%>
<%--                                       value="Выйти из аккаунта">--%>
<%--                            </form>--%>
<%--                        </li>--%>
                        <c:if test="${!(roles.contains('ROLE_SELLER'))}">
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li>
                                <button class="dropdown-item" data-bs-toggle="modal"
                                        data-bs-target="#staticBackdrop"
                                        type="submit">Стать продавцом
                                </button>
                            </li>
                        </c:if>
                        <c:if test="${roles.contains('ROLE_SELLER')}">
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li>
                                <a href="/product/my-products" class="dropdown-item"
                                   type="submit">Мои продукты</a>
                            </li>
                        </c:if>
                        </c:if>
                    </ul>
                    <c:if test="${user.email == null}">
                        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="<c:url value="/login"/>">Вход
                                    и регистрация</a>
                            </li>
                        </ul>
                    </c:if>

                </li>
                <li class="nav-item">
                    <c:if test="${roles.contains('ROLE_SELLER')}">
                        <a class="btn btn-outline-light" href="/product/create" type="submit">Разместить
                            объявление</a>
                    </c:if>
                    <c:if test="${!(roles.contains('ROLE_SELLER'))}">
                        <button class="btn btn-outline-light" data-bs-toggle="modal" data-bs-target="#needSeller"
                                type="submit">Разместить объявление
                        </button>
                    </c:if>
                </li>
            </ul>
        </div>
    </div>
</nav>
