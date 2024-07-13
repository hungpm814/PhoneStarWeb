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
            <link rel="stylesheet" href="css/stylekho.css">
            <link rel="stylesheet" href="css/styletk.css">
        </head>

        <body>
            <jsp:include page="/components/header.jsp" />



            <div class="container-fluid">

                <h2 class="header col-lg-12" style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                                                    margin-bottom: 70px;">
                    SỐ LIỆU BÁN HÀNG
                </h2>
            </div>

            <div class="container">
                <div class="row">

                    <div class="rr d-flex justify-content-center">
                        <div class="col-lg-3 item">

                            <h3 class="item-name" style="text-align: center;">
                                Số lượng người dùng
                            </h3>

                            <h2 class="item-info" style="text-align: center;">
                                ${requestScope.usum}
                            </h2>

                        </div>

                        <div class="col-lg-3 item">

                            <h3 class="item-name" style="text-align: center;">
                                Tổng doanh thu
                            </h3>

                            <h2 class="item-info" style="text-align: center;">
                                ${requestScope.btotal}đ
                            </h2>

                        </div>

                        <div class="col-lg-3 item">

                            <h3 class="item-name" style="text-align: center;">
                                Số đơn hàng đã bán
                            </h3>

                            <h2 class="item-info" style="text-align: center;">
                                ${requestScope.bsum}
                            </h2>

                        </div>
                    </div>

                    <div class="rr d-flex justify-content-center">
                        <div class="col-lg-3 item">

                            <h3 class="item-name" style="text-align: center;">
                                Số lượng máy
                            </h3>

                            <h2 class="item-info" style="text-align: center;">
                                ${requestScope.psum}
                            </h2>

                        </div>

                        <div class="col-lg-3 item">

                            <h3 class="item-name" style="text-align: center;">
                                Doanh thu ngày hôm nay
                            </h3>

                            <h2 class="item-info" style="text-align: center;">
                                ${requestScope.btotaltoday}đ
                            </h2>

                        </div>

                        <div class="col-lg-3 item">

                            <h3 class="item-name" style="text-align: center;">
                                GTTB mỗi đơn hàng
                            </h3>

                            <h2 class="item-info" style="text-align: center;">
                                ${requestScope.bavg}đ
                            </h2>

                        </div>
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