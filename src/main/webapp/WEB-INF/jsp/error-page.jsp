<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<jsp:include page="blocks/head.jsp"/>
<body style="color: red">
<jsp:include page="blocks/bootstrap-scripts.jsp"/>
<jsp:include page="blocks/header-noauth.jsp"/>

<div class="main">
    <div class="container">
        <div class="col-md-9 col-sm-7">
            <div class="row">
                <div class="col-md-6 col-sm-6">
                    <div class="product-main-image">
                        <img class="card-img-top" alt="Картинка"
                             src="/resources/images/${code}.avif"/>
                    </div>
                </div>
                <div class="col-md-6 col-sm-6">
                    <h1>Error</h1>
                    </h1>
                    <div class="price-availability-block clearfix">
                        <c:if test="${code != null}">
                            <div class="price">
                                <strong>status: ${code}</strong>
                            </div>
                        </c:if>
                        <c:if test="${message != null}">
                            <div class="description">
                                <p>message :${message}
                                </p>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
