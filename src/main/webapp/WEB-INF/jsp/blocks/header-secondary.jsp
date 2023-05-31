<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<nav class="navbar navbar-expand-lg fixed-top navbar navbar-dark bg-dark n">
    <div class="container-fluid">
        <a class="navbar-brand" href="<c:url value="/"/>"><img src="${pageContext.request.contextPath}/resources/images/fan-solid.svg"> Dragi</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
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
                        <li>
                            <form action="${pageContext.request.contextPath}/logout" method="post">
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                                <input class="dropdown-item" aria-current="page" type="submit"
                                       value="Выйти из аккаунта">
                            </form>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
