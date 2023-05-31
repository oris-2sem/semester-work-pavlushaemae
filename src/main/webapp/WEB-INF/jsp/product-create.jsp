<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<jsp:include page="blocks/head.jsp"/>
<body>
<jsp:include page="blocks/bootstrap-scripts.jsp"/>
<jsp:include page="blocks/header-secondary.jsp"/>
<div class="container">
    <main>
        <br>
        <div class="py-5 text-center">
            <h2>Разместить объявление</h2>
        </div>
        <div class="row g-5">
            <div class="col-md-11 col-lg-12">
                <div class="row g-3">
                    <form id="a" action="/product/create" class="needs-validation" method="post"
                          enctype="multipart/form-data">
                        <div class="col-sm-6">
                            <label class="form-label" for="category">Категория</label>
                            <select class="form-select" name="category" id="category" required="">
                                <option selected disabled value="">Выберите категорию из предложенных</option>
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
                        <div class="col-sm-12">
                            <label class="form-label" for="name">Название</label>
                            <input type="text" class="form-control" name="title" id="name" placeholder="" value=""
                                   required>
                        </div>
                        <div class="col-12">
                            <label class="form-label" for="description">Описание</label>
                            <input type="text" class="form-control" name="description" id="description" placeholder=""
                                   required>
                        </div>
                        <div class="col-12">
                            <label class="form-label" for="city">Ваш город</label>
                            <input type="text" class="form-control" name="city" id="city" placeholder="" required>
                            <div class="invalid-feedback">
                                Укажите действующий город.
                            </div>
                        </div>
                        <div class="col-12">
                            <label class="form-label" for="price">Цена</label>
                            <input type="number" step="any" class="form-control" name="price" id="price"
                                   placeholder="" value="" required>
                        </div>
                        <div class="col-sm-12">
                            <label class="form-label">Загрузите одну или несколько фотографий</label>
                            <br>
                            Первая фотография: <input class="form-control" type="file" name="file1" id="formFile1"
                                                      required><br>
                            Вторая фотография: <input class="form-control" type="file" name="file2" id="formFile2"><br>
                            Третья фотография: <input class="form-control" type="file" name="file3" id="formFile3"><br>
                        </div>
                        <br>
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <button form="a" class="w-100 btn btn-light btn btn-outline-dark btn-lg" type="submit">
                            Разместить
                            объявление
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </main>
</div>
</body>
</html>
