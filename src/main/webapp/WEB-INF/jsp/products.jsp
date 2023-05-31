<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<jsp:include page="blocks/head.jsp"/>
<body>
<jsp:include page="blocks/bootstrap-scripts.jsp"/>
<jsp:include page="blocks/header-primary.jsp"/>
<section class="main-content">
    <div class="container-fluid">
        <div class="main row">
            <div class="col-sm-2">
                <div class="filter">
                    <div class="row">
                        <form method="get">
                            <div class="list-group aaa">
                                <button name="category" type="submit" value=""
                                        class="list-group-item list-group-item-action">Все категории
                                </button>
                                <button name="category" type="submit" value="Транспорт"
                                        class="list-group-item list-group-item-action">Транспорт
                                </button>
                                <button name="category" type="submit" value="Недвижимость"
                                        class="list-group-item list-group-item-action">Недвижимость
                                </button>
                                <button name="category" type="submit" value="Работа"
                                        class="list-group-item list-group-item-action">Работа
                                </button>
                                <button name="category" type="submit" value="Услуги"
                                        class="list-group-item list-group-item-action">Услуги
                                </button>
                                <button name="category" type="submit" value="Личные вещи"
                                        class="list-group-item list-group-item-action">Личные вещи
                                </button>
                                <button name="category" type="submit" value="Для дома и дачи"
                                        class="list-group-item list-group-item-action">Для дома и дачи
                                </button>
                                <button name="category" type="submit" value="Электроника"
                                        class="list-group-item list-group-item-action">Электроника
                                </button>
                                <button name="category" type="submit" value="Хобби и отдых"
                                        class="list-group-item list-group-item-action">Хобби и отдых
                                </button>
                                <button name="category" type="submit" value="Животные"
                                        class="list-group-item list-group-item-action">Животные
                                </button>
                                <button name="category" type="submit" value="Готовый бизнес и оборудование"
                                        class="list-group-item list-group-item-action">Готовый бизнес и оборудование
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-sm-10">
                <div class="container">
                    <c:if test="${products != null}">
                    <c:if test="${!(products.isEmpty())}">
                    <div class="row">
                        <div class="dropdown col-md-9">
                            <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown"
                                    aria-expanded="false">
                                Фильтровать
                            </button>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="<c:url value="/?sort="/>">По умолчанию</a></li>
                                <li><a class="dropdown-item" href="<c:url value="/?sort=expensive"/>">Дороже</a></li>
                                <li><a class="dropdown-item" href="<c:url value="/?sort=cheap"/>">Дешевле</a></li>
                                <li><a class="dropdown-item" href="<c:url value="/?sort=date"/>">По дате</a></li>
                            </ul>
                        </div>
                        <div class="col-md-3">
                            <form action="${pageContext.request.contextPath}/" method="get">
                                <input type="text" name="title">
                                <input type="submit" value="Поиск">
                            </form>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <jsp:include page="blocks/products-list.jsp"/>
                    </div>
                </div>
                </c:if>
                <c:if test="${products.isEmpty()}">
                    <h1>Товаров пока нет</h1>
                </c:if>
                </c:if>
            </div>
        </div>
    </div>

</section>
<jsp:include page="blocks/modals.jsp"/>
</body>
</html>