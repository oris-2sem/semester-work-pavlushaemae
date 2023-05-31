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
            <div class="col-sm-10">
                <div class="container">
                    <c:if test="${products != null}">
                        <c:if test="${!products.isEmpty()}">
                            <div class="col-sm-6">
                                <button data-bs-toggle="modal" data-bs-target="#delete"
                                        class="w-100 btn btn-light btn btn-outline-dark btn-lg" type="submit">Заказать
                                    доставку
                                </button>
                            </div>
                            <div class="col-sm-6">
                                <form action="/basket/delete" method="post">
                                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                                    <input class="w-100 btn btn-light btn btn-outline-dark btn-lg" type="submit"
                                           value="Очистить корзину">
                                </form>
                            </div>
                            <div class="row">
                                <jsp:include page="blocks/products-list.jsp"/>
                            </div>
                        </c:if>
                        <c:if test="${products.isEmpty()}">

                            <h1>Корзина пуста</h1>
                            <a href="<c:url value="/"/>" class="w-100 btn btn-light btn btn-outline-dark btn-lg"
                               type="submit">Перейти к товарам
                                и услугам</a>
                        </c:if>
                    </c:if>
                </div>
            </div>
        </div>
    </div>

</section>

<jsp:include page="blocks/modals.jsp"/>
<div class="modal fade" id="delete" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="deleteLabel">Спасибо за заказ.</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Доставка ожидается.
            </div>
            <div class="modal-footer">
                <form action="/basket/order" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input class="btn btn-secondary" type="submit" value="Close">
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>