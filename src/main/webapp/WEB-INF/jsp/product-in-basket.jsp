<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pavel
  Date: 14.11.2022
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="blocks/head.jsp"/>
<body>
<jsp:include page="blocks/bootstrap-scripts.jsp"/>
<jsp:include page="blocks/header-primary.jsp"/>

<div class="main">
    <div class="container">
        <div class="col-md-9 col-sm-7">
            <div class="row">
                <c:if test="${requestScope.name != null}">
                <div>
                    <h4>Продавец: ${requestScope.seller}
                    </h4>
                    <p>Дата добавления: ${requestScope.date}
                    </p>
                </div>
                <div class="col-md-6 col-sm-6">
                    <div class="product-main-image">
                        <img class="card-img-top" alt="Картинка"
                             src="/images/${requestScope.name}"/>
                    </div>
                </div>
                <div class="col-md-6 col-sm-6">

                    <h1>${requestScope.name}
                    </h1>
                    </c:if>
                    <div class="price-availability-block clearfix">
                        <c:if test="${requestScope.price != null}">
                            <div class="price">
                                <strong>${requestScope.price}<span> руб.</span></strong>
                            </div>
                        </c:if>
                        <c:if test="${requestScope.desc != null}">
                            <div class="description">
                                <p>${requestScope.desc}</p>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="blocks/modals.jsp"/>
</body>
</html>