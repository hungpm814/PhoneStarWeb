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



            <div class="container">

                <h2 class="header">KHO HÀNG</h2>

                <table class="table col-lg-12 table-hover">
                    <thead >
                        <tr >
                            <th style="background-color: black;color: white;font-weight: bold;padding: 10px;padding-left: 8px;">Mã điện thoại</th>
                            <th style="background-color: black;color: white;font-weight: bold;padding: 10px;padding-left: 8px;">Điện thoại</th>
                            <th style="background-color: black;color: white;font-weight: bold;padding: 10px;padding-left: 8px;">Bộ nhớ</th>
                            <th style="background-color: black;color: white;font-weight: bold;padding: 10px;padding-left: 8px;">Màu sắc</th>
                            <th style="background-color: black;color: white;font-weight: bold;padding: 10px;padding-left: 8px;">Ngày nhập kho</th>
                            <th style="background-color: black;color: white;font-weight: bold;padding: 10px;padding-left: 8px;">SL</th>
                            <th style="background-color: black;color: white;font-weight: bold;padding: 10px;padding-left: 8px;">Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.lp}" var="p">
                        <tr>
                            <th style="padding-top: 25px; padding-left: 45px;">${p.series}</th>

                            <td class="d-flex" style="height: 80px;align-items: center;">
                                <img src="${p.image}" alt="" class="rounded" style="width: 50px;height: 50px;">
                                <p style="margin-top: 13px;margin-left: 15px;border-radius: 4px;padding: 0 7px;
                                    background-color: rgba(81, 187, 81, 0.3);">${p.phoneName}</p>
                            </td>

                            <td style="padding-top: 26px;">${p.rom}</td>
                            <td style="padding-top: 25px;">${p.color}</td>
                            <td style="padding-top: 25px;">${p.date}</td>
                            <td style="padding-top: 25px;">${p.quantity}</td>

                            <td style="height: 100%;padding-top: 25px;" >
                                
                                <a href="update?series=${p.series}" style="color: gray;margin:0 8px"><i class="bi bi-pencil-fill"></i></a>
                                <a href="deletep?series=${p.series}" style="color: gray;margin:0 8px"><i class="bi bi-trash3-fill"></i></a>
                                
                            </td>
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