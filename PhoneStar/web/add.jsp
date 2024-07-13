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
        </head>

        <body>
            <jsp:include page="/components/header.jsp" />


            <div class="container-fluid">

                <div style="display: flex;">

                   <div class="add">

                    <h2 style="text-align: center;">Thêm dòng điện thoại mới</h2>
                    
                    <p style="color: red;font-style: italic;text-align: center;">
                        ${requestScope.mes1}
                    </p>
                    
                    <hr>

                    <form action="add?type=1" method="post">
                        <div class="mb-3 mt-3">
                            <label for="name" class="form-label">Tên dòng máy:</label>
                            <input type="text" class="form-control" id="name" name="phoneName"required>
                        </div>

                        <div class="mb-3">
                            <label for="os" class="form-label">Hệ điều hành:</label>
                            <input type="text" class="form-control" id="os" name="os"required>
                        </div>

                        
                        <label for="ram" class="form-label">RAM:</label>
                        <div class="input-group mb-3">
                            <input type="number" class="form-control" id="ram" name="ram"required>
                            <div class="input-group-append">
                                <span class="input-group-text">GB</span>
                              </div>
                        </div>

                        <div class="mb-3">
                            <label for="detail" class="form-label">Thông tin sản phẩm:</label>
                            <input class="form-control" id="detail" name="detail"required></input>
                        </div>


                        <label for="camera" class="form-label">Camera:</label>
                        <div class="input-group mb-3">
                            <input type="number" class="form-control" id="camera" name="camera"required>
                            <div class="input-group-append">
                                <span class="input-group-text">MP</span>
                              </div>
                        </div>

                        <div class="mb-3">
                            
                        </div>

                        <div class="mb-3">
                            <label for="year" class="form-label">Năm sản xuất:</label>
                            <input type="number" class="form-control" id="year" name="year"required>
                        </div>

                        <div class="mb-3">
                            <label for="chip" class="form-label">Chip:</label>
                            <input type="text" class="form-control" id="chip" name="chip"required>
                        </div>

                        <div class="mb-3">
                            <label for="screen" class="form-label">Màn hình:</label>
                            <input type="text" class="form-control" id="screen" name="screen"required>
                        </div>

                        <div class="mb-3">
                            <label for="brand" class="form-label">Hãng:</label>
                            <select name="brand" id="brand" class="filter-btn" style="margin-left: 5px;margin-top:5px;">
                                <c:forEach var="b" items="${sessionScope.lb}">
                                    <option value="${b.brandID}">${b.brandName}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div style="width: 100%;display: flex;justify-content: center;">
                            <button type="submit" class="btn btn-primary" style="padding: 7px 35px; font-size: 17px;">Xác nhận</button>
                        </div>
                        
                    </form>

                </div>

                <div class="add">

                    <h2 style="text-align: center;">Thêm mẫu mới của dòng máy đã có</h2>

                    <p style="color: red;font-style: italic;text-align: center;">
                        ${requestScope.mes2}
                    </p>
                    
                    <hr>

                    <form action="add?type=2" method="post">

                        <div class="mb-3">
                            <label for="phoneName" class="form-label">Tên dòng máy:</label>
                            <select name="phoneName" id="phoneName" class="filter-btn" style="margin-left: 5px;margin-top:5px;">
                                <c:forEach var="v" items="${sessionScope.lv}">
                                    <option value="${v.phoneName}">${v.phoneName}</option>
                                </c:forEach>
                            </select>
                        </div>


                        <div class="mb-3 mt-3">
                            <label for="series" class="form-label">Mã điện thoại:</label>
                            <input type="text" class="form-control" id="series" name="series"required>
                        </div>

                        <div class="mb-3">
                            <label for="color" class="form-label">Màu:</label>
                            <input type="text" class="form-control" id="color" name="color"required>
                        </div>

                        <div class="mb-3">
                            <label for="rom" class="form-label">Bộ nhớ:</label>
                            <input type="text" class="form-control" id="rom" name="rom"required>
                        </div>

                        <label for="price" class="form-label">Giá:</label>
                        <div class="input-group mb-3">
                            <input type="text" class="form-control" id="price" name="price"required>
                            <div class="input-group-append">
                                <span class="input-group-text">đ</span>
                              </div>
                        </div>

                        <div class="mb-3">
                            <label for="quantity" class="form-label">Số lượng:</label>
                            <input type="number" class="form-control" id="quantity" name="quantity"required>
                        </div>

                        <div class="mb-3">
                            <label for="image" class="form-label">Nguồn ảnh:</label>
                            <input type="text" class="form-control" id="image" name="image"required>
                        </div>

                        <div style="width: 100%;display: flex;justify-content: center;">
                            <button type="submit" class="btn btn-primary" style="padding: 7px 35px; font-size: 17px;">Xác nhận</button>
                        </div>
                        
                    </form>

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