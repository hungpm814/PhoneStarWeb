<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <%@page import="model.Product" %>
    <%@page import="java.util.*" %>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <title>Sản phẩm</title>

          <!-- Bootstrap -->
          <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
          <link rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">


          <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
          <link rel="stylesheet" href="css/style.css">
          <link rel="stylesheet" href="css/styleshow.css">
        </head>

        <body>
          <jsp:include page="/components/header.jsp" />

          <div class="container" style="padding-top: 70px;">

            <c:set var="v" value="${requestScope.version}" />
            <c:set var="p" value="${requestScope.product}" />
            <c:set var="ph" value="${requestScope.phone}" />
            <c:set var="b" value="${requestScope.brand}" />

            <c:if test="${sessionScope.acc == null}">
              <script>
                alert('Bạn cần đăng nhập để mua hàng!');
              </script>
            </c:if>

            <div class="row">

              <h4 class="sh-name">${p.phoneName}</h4>
              <hr style="color: rgb(57, 56, 56);height: 3px;">

              <div class="sh-l col-lg-8">
                <div class="sh-image">

                  <img src="${ph.image}" alt="">

                </div>

                <h2 class="sh-dt-head">Thông tin sản phẩm</h2>
                <p class="sh-detail">${v.detail}</p>

                <div class="comment"></div>

              </div>

              <div class="sh-r col-lg-4">

                <div class="pr-rom" style="cursor: pointer;">
                  <c:forEach items="${p.rom}" var="r">
                    <c:choose>
                      <c:when test="${r==requestScope.romm}">
                        <a class="pr-rom-op" href=""
                          style="border-color: rgb(89, 164, 210);color: rgb(89, 164, 210); text-decoration: none;">${r}</a>
                      </c:when>
                      <c:otherwise>
                        <a class="pr-rom-op" href="show?phoneName=${p.phoneName}&rom=${r}&color=${requestScope.colorr}"
                          style="text-decoration: none; color: black;">${r}</a>
                      </c:otherwise>
                    </c:choose>
                  </c:forEach>
                </div>

                <div class="pr-rom" style="cursor: pointer;">
                  <c:forEach items="${p.color}" var="r">
                    <c:choose>
                      <c:when test="${r==requestScope.colorr}">
                        <a class="pr-rom-op"
                          style="border-color: rgb(89, 164, 210);color: rgb(89, 164, 210); text-decoration: none;">${r}</a>
                      </c:when>
                      <c:otherwise>
                        <a class="pr-rom-op" href="show?phoneName=${p.phoneName}&rom=${requestScope.romm}&color=${r}"
                          style="text-decoration: none; color: black;">${r}</a>
                      </c:otherwise>
                    </c:choose>
                  </c:forEach>
                </div>

                <h3 class="pr-price" style="margin: 10px 0; margin-bottom: 30px;">
                  <c:choose>
                    <c:when test="${ph.price==requestScope.mes}">
                      ${ph.price}!
                    </c:when>
                    <c:otherwise>
                      ${ph.price}đ
                    </c:otherwise>
                  </c:choose>
                </h3>

                <h5 style="text-align: center;">Cấu hình sản phẩm</h5>

                <table class="table table-striped col-lg-4" style="margin-bottom: 40px;">

                  <tbody>
                    <tr>
                      <th scope="row">Màn hình:</th>
                      <td>${v.screen}</td>
                    </tr>
                    <tr>
                      <th scope="row">Camera:</th>
                      <td>${v.camera}MP</td>
                    </tr>
                    <tr>
                      <th scope="row">Hệ điều hành:</th>
                      <td>${v.os}</td>
                    </tr>
                    <tr>
                      <th scope="row">Chip:</th>
                      <td>${v.chip}</td>
                    </tr>
                    <tr>
                      <th scope="row">RAM:</th>
                      <td>${v.ram}</td>
                    </tr>
                    <tr>
                      <th scope="row">Bộ nhớ:</th>
                      <td>${requestScope.romm}</td>
                    </tr>
                    <tr>
                      <th scope="row">Năm sản xuất:</th>
                      <td>${v.year}</td>
                    </tr>
                    <tr>
                      <th scope="row">Hãng:</th>
                      <td>${b.brandName}</td>
                    </tr>
                  </tbody>
                </table>

                <c:if test="${ph.quantity>0}">
                  <h5 style="margin: 0;">SL: &nbsp;</h5>

                  <form name="f" action="" method="post" class="quantity-input">
                    <input type="button" class="btn-minus" onclick="decreaseQuantity()" value="-"></input>
                    <input type="text" id="quantity" value="1">
                    <input type="button" class="btn-plus" onclick="increaseQuantity()" value="+"></input>
                  </form>
                </c:if>
                <h6 style="color: red;margin-bottom: 20px;"><span>Kho:</span> <span class="kho">${ph.quantity}</span>
                </h6>


                <c:if test="${ph.quantity>0}">
                  <div style="margin-bottom: 5px;">
                    <input type="submit" onclick="buy('${ph.series}','1')" class="buybt1 bt col-lg-4"
                      value="Mua ngay"></input>
                  </div>

                  <input type="submit" onclick="buy('${ph.series}','2')" class="buybt2 bt col-lg-2"
                    value="Thêm vào giỏ hàng"></input>
                </c:if>



                <c:if test="${requestScope.mes1 != null}">
                  <script>
                    alert('Thêm vào giỏ hàng thành công');
                  </script>
                </c:if>
                  
              </div>

            </div>


          </div>

          <%@ include file="/components/footer.jsp" %>

            <!-- Boostrap -->
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"></script>


            <script src="js/func.js"></script>
        </body>

        </html>