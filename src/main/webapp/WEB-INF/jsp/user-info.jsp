<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pavel
  Date: 07.05.2023
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<jsp:include page="blocks/head.jsp"/>
<body>
<jsp:include page="blocks/bootstrap-scripts.jsp"/>
<jsp:include page="blocks/header-primary.jsp"/>
<br>
<br>
<br>
<h1 style="text-align: center">Информация о пользователе</h1>
<div style="text-align: center">
    <b>Номер телефона: </b> ${user.phone}<br>
    <b>Электронная почта: </b> ${user.email}<br>
</div>

<section class="main-content">
    <div class="container-fluid">
        <div class="col-sm-10">
            <div class="container">
                <h4>Товары пользователя ${user.nickname}</h4>
                <c:if test="${products != null}">
                    <c:if test="${!products.isEmpty()}">
                        <div class="row">
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
</body>
</html>
