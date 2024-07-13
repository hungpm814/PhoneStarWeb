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
        </head>

        <body>
            <jsp:include page="/components/header.jsp" />



            <div class="container">

                <h2 class="header" style="margin: 50px 0;
                color: rgb(135, 115, 78);
                text-align: center;
                text-shadow: 1px 1px 1px lightgray;
                font-size: 50px;
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">CHI TIẾT ĐƠN HÀNG</h2>

                <div class="row d-flex justify-content-center" style="margin-bottom: 220px;">

                    <div class="col-md-5 col-lg-4 order-md-last">
                        <h5 class="mb-0" style="text-align: center;background-color: rgb(214, 187, 187);
                                            padding: 8px 0;border-radius: 7px;">
                            Mã đơn hàng: ${requestScope.b.billID}
                        </h5>
                        <ul class="list-group mb-3">
                            <c:forEach items="${requestScope.lbo}" var="i">
                                <c:forEach items="${requestScope.lbp}" var="p">
                                    <c:if test="${i.series == p.series}">
                                        <li class="list-group-item d-flex justify-content-between lh-sm">
                                            <div>
                                                <h6 class="my-0">${p.phoneName} &nbsp;(${i.quantity})</h6>
                                                <small class="text-body-secondary">${p.rom}, ${p.color}</small>
                                            </div>
                                            <span class="text-body-secondary">${i.price}đ</span>
                                        </li>
                                    </c:if>
                                </c:forEach>

                            </c:forEach>

                            <li class="list-group-item d-flex justify-content-between">
                                <span>Total (VNĐ)</span>
                                <strong>${requestScope.b.total}đ</strong>
                            </li>
                        </ul>

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