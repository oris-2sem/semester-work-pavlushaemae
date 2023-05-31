<%@ page contentType="text/html;charset=UTF-8" %>
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="staticBackdropLabel">VIP</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Для того, чтобы продавать на этой площадке, нужно оплатить платную подписку за 399 рублей
                <br>
                Реквизиты:
                <br>
                По номеру телефона +79911153704 Сбербанк, в сообщении указать "Хочу быть легендой"
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <form action="${pageContext.request.contextPath}/user/seller" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input class="btn btn-primary" aria-current="page" type="submit"
                           value="OK">
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="needSeller" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="needSellerLabel">VIP</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Для того, чтобы продавать на этой площадке, нужно приобрести права продавца.
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
