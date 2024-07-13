<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>

            <!-- Bootstrap -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                crossorigin="anonymous">
            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

            <link rel="stylesheet"
                href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
            <link rel="stylesheet" href="css/style.css">
            <link rel="stylesheet" href="css/styleadd.css">
            <link rel="stylesheet" href="css/stylecart.css">
        </head>

        <body>
            <jsp:include page="/components/header.jsp" />

            <div class="container-fluid">

                <div style="display: flex;justify-content: center;align-items: center;">

                    <div class="add" style="min-height: 600px; position: relative;padding-bottom: 150px;">

                        <h2 class="hd-te" style="text-align: center;">Giỏ hàng</h2>

                        <c:forEach items="${sessionScope.lo}" var="i">
                        <div class="item">

                            <div style="display: flex; justify-content: space-around; align-items: center; width: 90%;
                                        border-right: 1px solid grey;">
                                <c:forEach items="${sessionScope.lop}" var="p">
                                    <c:if test="${i.series == p.series}">
                                <div class="item-info">
                                    <img src="${p.image}" alt="">

                                    <div class="item-text ">
                                        <h6 style="width: 130px;">${p.phoneName}</h6>
                                        <p style="width: 130px;">${p.rom}, ${p.color}</p>

                                        <h6 class="pr-price">${p.price}đ</h6>
                                    </div>

                                </div>
                                </c:if>
                                </c:forEach>
                                <p class="quan">SL: ${i.quantity}</p>
                                <p class="quan">Tổng: ${i.price}đ</p>
                            </div>

                            <div style="width: 8%;display: flex;justify-content: center;">
                                <a href="deleteo?series=${i.series}" style="color: rgb(99, 91, 91);font-size: 20px;"><i class="bi-x-square"></i></a>
                            </div>

                        </div>
                        </c:forEach>

                        <c:if test="${(sessionScope.lo != null) && (sessionScope.lo.size() != 0)}">
                        <a href="checkout" class="btn btn-danger send">Mua hàng</a>
                        </c:if>

                    </div>

                </div>

            </div>


            <%@ include file="/components/footer.jsp" %>

                <!-- Boostrap -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                    crossorigin="anonymous"></script>
        </body>

        </html>