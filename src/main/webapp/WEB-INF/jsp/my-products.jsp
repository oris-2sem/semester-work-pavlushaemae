<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<jsp:include page="blocks/head.jsp"/>
<body>
<jsp:include page="blocks/bootstrap-scripts.jsp"/>

<jsp:include page="blocks/header-secondary-create.jsp"/>

<section class="main-content">
    <div class="container-fluid">
        <div class="main row">
            <div class="col-sm-10">
                <div class="container">
                    <c:if test="${products != null}">
                        <c:if test="${!(products.isEmpty())}">
                            <div class="row">
                                <c:forEach var="product" items="${products}">
                                    <div class="col-lg-4 col-sm-6">
                                        <div class="card product-card">
                                            <img class="card-img-top" height="400px" width="auto" alt="Картинка"
                                                 src="/images/${product.previewImageId}"/>
                                            <div class="card-body">
                                                <h5 class="card-title">${product.title}
                                                </h5>
                                                <p class="card-text">${product.price} руб.</p>
                                                <a href="<c:url value="/product/edit/${product.id}"/>"
                                                   class="btn btn-primary">Редактировать</a>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:if>
                        <c:if test="${products.isEmpty()}">
                            <br>
                            <br>
                            <h1>Товаров на продажу пока не выставлено</h1>
                        </c:if>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>