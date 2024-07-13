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
            <link rel="stylesheet" href="css/styleuser.css">

        </head>

        <body class="bg-body-tertiary" data-new-gr-c-s-check-loaded="14.1157.0" data-gr-ext-installed="">

            <jsp:include page="/components/header.jsp" />

            <c:set var="acc" value="${sessionScope.acc}"></c:set>
            
            <div class="container">
                <main>
                    <h2 style="text-align: center; margin: 40px 0; color: lightcoral; 
                        padding: 10px 50px;background-color: lightgrey;border-radius: 10px;">CHECK OUT</h2>

                    <div class="row g-5">
                        <div class="col-md-5 col-lg-4 order-md-last">
                            <h4 class="d-flex justify-content-between align-items-center mb-3">
                                <span class="text-primary">Đơn hàng</span>
                            </h4>
                            <ul class="list-group mb-3">
                                <c:forEach items="${sessionScope.lo}" var="i">
                                    <c:forEach items="${sessionScope.lop}" var="p">
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
                                    <strong>${requestScope.total}đ</strong>
                                </li>
                            </ul>

                        </div>
                        <div class="col-md-7 col-lg-8">
                            <h4 class="mb-3" style="color: #0D6EFD; margin-left: 25px;">Thông tin nhận hàng</h4>

                            <form action="checkout" method="post">

                                <div style="display: flex;justify-content: space-around; margin: 30px 0;">
                                    <div class="half">

                                        <div class="mb-3 mt-3">
                                            <label for="name" class="form-label">Tên người nhận:</label>
                                            <input type="text" class="form-control" id="name" name="name"
                                                value="${acc.name}" required>
                                        </div>

                                        <div class="mb-3 mt-3">
                                            <label for="phoneNumber" class="form-label">Số điện thoại:</label>
                                            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber"
                                                value="${acc.phoneNumber}" required>
                                        </div>

                                    </div>

                                    <div class="half">

                                        <div class="mb-3 mt-3">
                                            <label for="address" class="form-label">Địa chỉ:</label>
                                            <input type="text" class="form-control" id="address" name="address"
                                                value="${acc.address}" required>
                                        </div>

                                    </div>
                                </div>



                                <div style="width: 100%;display: flex;justify-content: center;">
                                    <button type="submit" class="btn btn-primary"
                                        style="padding: 7px 35px; font-size: 17px;">Xác nhận mua</button>
                                </div>

                            </form>
                        </div>
                    </div>
                </main>


            </div>

            <%@ include file="/components/footer.jsp" %>

                <script src="/docs/5.3/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                    crossorigin="anonymous"></script>


        </body>

        </html>