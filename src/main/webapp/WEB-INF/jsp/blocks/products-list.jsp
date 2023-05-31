<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pavel
  Date: 08.05.2023
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach var="product" items="${products}">
  <div class="col-lg-4 col-sm-6 ">
    <div class="card product-card ">
      <img class="card-img-top" alt="Картинка" height="400px" width="auto"
           src="/images/${product.previewImageId}"/>
      <div class="card-body">
        <h5 class="card-title">${product.title}</h5>
        <p class="card-text">${product.price} руб.</p>
        <a href="<c:url value="/product/${product.id}"/>"
           class="btn btn-primary">Перейти</a>
      </div>
    </div>
  </div>
</c:forEach>
