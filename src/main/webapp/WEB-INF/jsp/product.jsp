<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<jsp:include page="blocks/head.jsp"/>
<body>
<jsp:include page="blocks/bootstrap-scripts.jsp"/>

<jsp:include page="blocks/header-primary.jsp"/>

<div class="main">
    <div class="container">
        <div class="col-md-9 col-sm-7">
            <div class="row">
                <div>
                    <h4>Продавец: <a href="/user/${product.user.id}">${product.user.nickname}</a>
                    </h4>
                    <p>Дата добавления: ${product.dateOfCreate}</p>
                </div>
                <div class="col-md-6 col-sm-6">
                    <div class="product-main-image">
                        <img class="card-img-top" alt="Картинка"
                             src="/images/${images.get(0).id}"/>
                    </div>
                </div>
                <div class="col-md-6 col-sm-6">
                    <h1>${product.title}
                    </h1>
                    <div class="price-availability-block clearfix">
                        <c:if test="${product.price != null}">
                            <div class="price">
                                <strong>${product.price}<span> руб.</span></strong>
                            </div>
                        </c:if>
                        <c:if test="${product.description != null}">
                            <div class="description">
                                <p>${product.description}
                                </p>
                            </div>
                        </c:if>
                    </div>
                    <form action="<c:url value="/basket/add/${product.id}"/>" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <input class="w-100 btn btn-light btn btn-outline-dark btn-lg" type="submit"
                               value="Добавить в корзину"/>
                    </form>
                    <div id="postContainer"></div>
                    <br>
                    <form action="<c:url value="/review/create/${product.id}"/>" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <input type="text" class="form-control" name="text" id="name" placeholder="Введите отзыв о товаре или услуге" value=""
                               required>
                        <br>
                        <input class="w-100 btn btn-light btn btn-outline-dark btn-lg" type="submit"
                               value="Добавить отзыв"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>



<script>
    window.onload = function() {
        fetchData(${product.id});
    }
</script>

<!-- Modal -->
<jsp:include page="blocks/modals.jsp"/>
</body>
</html>