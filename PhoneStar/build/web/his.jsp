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
        </head>

        <body>
            <jsp:include page="/components/header.jsp" />

            <c:if test="${sessionScope.acc == null}">
                <script>
                  alert('Bạn cần đăng nhập để xem lịch sử mua hàng!');
                </script>
            </c:if>

            <div class="container">

                <h2 class="header" style="color: rgb(135, 115, 78);
                                            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif">
                    LỊCH SỬ MUA HÀNG
                </h2>

                <p style="font-style: italic;color: rgb(135, 115, 78);margin-bottom: 6px;">*Bấm vào mã đơn hàng để xem chi tiết</p>
                <table class="table col-lg-12 table-hover" style="margin-bottom: 280px;">
                    <thead>
                        <tr>
                            <th
                                style="background-color: rgb(135, 115, 78);color: white;font-weight: bold;padding: 10px;padding-left: 8px;">
                                Mã đơn hàng</th>
                            <th
                                style="background-color: rgb(135, 115, 78);color: white;font-weight: bold;padding: 10px;padding-left: 8px;">
                                Ngày xuất đơn</th>
                            <th
                                style="background-color: rgb(135, 115, 78);color: white;font-weight: bold;padding: 10px;padding-left: 8px;">
                                Tổng giá tiền</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.lb}" var="p">
                            <tr>
                                <th style="padding-top: 25px; padding-left: 45px;"><a href="showb?billID=${p.billID}" style="text-decoration: none;">${p.billID}</a></th>
                                <td style="padding-top: 25px;">${p.date}</td>
                                <td style="padding-top: 25px; color:red;">${p.total}đ</td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>

            </div>




            <%@ include file="/components/footer.jsp" %>

                <!-- Boostrap -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                    crossorigin="anonymous"></script>
        </body>

        </html>