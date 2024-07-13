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

        <body>
            <jsp:include page="/components/header.jsp" />

            <c:set var="acc" value="${sessionScope.acc}"></c:set>

            <div class="container-fluid" style="display: flex; justify-content: center;align-items: center;">



                <div class="pro">

                    <h2 style="text-align: center;color: rgb(136, 38, 38);">Thông tin cá nhân</h2>
                    <div style="width: 100%;text-align: center; margin-top: 10px;">
                        <i class="bi-person-circle" style="font-size: 55px;"></i>
                    </div>

                    <p style="color: red;font-style: italic;text-align: center;">
                        ${requestScope.mes}
                    </p>

                    <hr>

                    <div class="d-flex" style="justify-content: space-around;">
                        <h4>Username: &nbsp;${acc.userName}</h4>
                        <h4 class="text-end">Password: *****</h4>
                    </div>


                    <form action="updateu" method="post">

                        <div style="display: flex;justify-content: space-around; margin: 30px 0;">
                            <div class="half">

                                <div class="mb-3 mt-3">
                                    <label for="name" class="form-label">Tên của bạn:</label>
                                    <input type="text" class="form-control" id="name" name="name" value="${acc.name}"
                                        required>
                                </div>

                                <div class="mb-3 mt-3">
                                    <label for="phoneNumber" class="form-label">Số điện thoại:</label>
                                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber"
                                        value="${acc.phoneNumber}" required>
                                </div>

                            </div>

                            <div class="half">

                                <div class="mb-3 mt-3">
                                    <label for="email" class="form-label">Email:</label>
                                    <input type="text" class="form-control" id="email" name="email" value="${acc.email}"
                                        required>
                                </div>

                                <div class="mb-3 mt-3">
                                    <label for="address" class="form-label">Địa chỉ:</label>
                                    <input type="text" class="form-control" id="address" name="address"
                                        value="${acc.address}" required>
                                </div>

                            </div>
                        </div>



                        <div style="width: 100%;display: flex;justify-content: center;">
                            <button type="submit" class="btn btn-primary"
                                style="padding: 7px 35px; font-size: 17px;">Cập nhật</button>
                        </div>

                    </form>

                </div>



            </div>


            <%@ include file="/components/footer.jsp" %>

                <!-- Boostrap -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                    crossorigin="anonymous"></script>
        </body>

        </html>