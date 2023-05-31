<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<jsp:include page="blocks/head.jsp"/>
<body>
<jsp:include page="blocks/bootstrap-scripts.jsp"/>

<jsp:include page="blocks/header-secondary-create.jsp"/>
<div class="main">
    <div class="container">
        <div class="main row">
            <div class="col-8">
                <div class="container">
                    <div class="row">
                        <c:if test="${product != null}">
                        <div>
                            <h4>Продавец: ${product.user.nickname}
                            </h4>
                            <p>Дата добавления: ${product.dateOfCreate}
                            </p>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <div class="product-main-image">
                                <img class="card-img-top" alt="Картинка"
                                     src="/images/${product.previewImageId}"/>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <h1>${product.title}
                            </h1>
                            </c:if>
                            <div class="price-availability-block clearfix">
                                    <div class="price">
                                        <strong>${product.price}<span> руб.</span></strong>
                                    </div>
                                    <div class="description">
                                        <p>${product.description}</p>
                                    </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <div class="container">
                    <div class="row">
                        <form action="${pageContext.request.contextPath}/product/delete" method="post">
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                            <input type="hidden" name="productId" value="${product.id}">
                            <input class="w-100 btn btn-light btn btn-outline-dark btn-lg" type="submit"
                                   value="Удалить товар">
                        </form>
                        <br>
                        <form id="a" action="/product/edit" class="needs-validation" method="post">
                            <div class="col-sm-12">
                                <label class="form-label" for="category">Редактировать товар</label>
                                <select class="form-select" name="category" id="category">
                                    <option selected disabled value="">Категория</option>
                                    <option>Транспорт</option>
                                    <option>Недвижимость</option>
                                    <option>Работа</option>
                                    <option>Услуги</option>
                                    <option>Личные вещи</option>
                                    <option>Для дома и дачи</option>
                                    <option>Электроника</option>
                                    <option>Хобби и отдых</option>
                                    <option>Животные</option>
                                    <option>Готовый бизнес и оборудование</option>
                                </select>
                            </div>
                            <input type="hidden" name="id" value="${product.id}">
                            <div>
                                <input class="form-control" type="text" name="title" id="name"
                                       placeholder="Название">
                            </div>
                            <div>
                                <input class="form-control" type="text" name="description" id="description"
                                       placeholder="Описание">
                            </div>
                            <div>
                                <input class="form-control" type="text" name="city" id="city"
                                       placeholder="Город">
                            </div>
                            <div>
                                <input class="form-control" type="number" step="any" name="price" id="price"
                                       placeholder="Цена">
                            </div>
                            <br>
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                            <button form="a" class="w-100 btn btn-light btn btn-outline-dark btn-lg" type="submit">ОК
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>