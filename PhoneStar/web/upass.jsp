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



                <div class="pro" style="width: 50%;">

                    <h2 style="text-align: center;color: rgb(136, 38, 38);">Thay đổi mật khẩu</h2>
                    <div style="width: 100%;text-align: center; margin-top: 10px;">
                        <i class="bi-person-circle" style="font-size: 55px;"></i>
                    </div>

                    <p style="color: red;font-style: italic;text-align: center;">
                        ${requestScope.mes}
                    </p>

                    <hr>

                    
                    <h4 style="text-align: center;">Username: &nbsp;${acc.userName}</h4>
                        


                    <form action="updatepass" method="post" style="padding: 20px 60px;">

                        <div class="mb-3 mt-3">
                            <label for="oldpass" class="form-label">Mật khẩu cũ:</label>
                            <input type="password" class="form-control" id="oldpass" name="oldpass" 
                                required>
                        </div>

                        <div class="mb-3 mt-3">
                            <label for="newpass" class="form-label">Mật khẩu mới:</label>
                            <input type="password" class="form-control" id="newpass" name="newpass" 
                                required>
                        </div>

                        <div class="mb-3 mt-3">
                            <label for="cf" class="form-label">Xác nhận mật khẩu mới:</label>
                            <input type="password" class="form-control" id="cf" name="cf" 
                                required>
                        </div>

                        <div style="width: 100%;display: flex;justify-content: center;">
                            <button type="submit" class="btn btn-primary"
                                style="padding: 7px 35px; font-size: 17px; margin-top: 20px;">Thay đổi</button>
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