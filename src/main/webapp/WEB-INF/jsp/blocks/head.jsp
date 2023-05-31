<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<meta http-equiv="Content-Security-Policy"
      content="default-src 'self' *.fontawesome.com *.googleapis.com https://fonts.gstatic.com;
      script-src 'self' 'unsafe-inline' *.fontawesome.com *.jsdelivr.net *.gstatic.com;
      img-src 'self' *.fontawesome.com;
      style-src 'self' 'unsafe-inline' *.fontawesome.com  *.jsdelivr.net *.googleapis.com">

<head id="head">
    <title>Dragi</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,900;1,400&display=swap"
          rel="stylesheet">
    <script src="https://kit.fontawesome.com/bd02cb2387.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/dompurify@2.3.2/dist/purify.min.js"></script>
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/edit.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/auth.css"/>" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/fetch-reviews.js"></script>
</head>

