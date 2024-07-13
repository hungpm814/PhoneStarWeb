<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page import="dal.BrandDAO" %>
<%@page import="dal.PhoneDAO" %>
<%@page import="dal.VersionDAO" %>
<%@page import="model.Brand" %>

  <%@page contentType="text/html" pageEncoding="UTF-8" %>

    <!DOCTYPE html>
    <html>

    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Cửa hàng</title>

      <!-- Bootstrap -->
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
      
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <link rel="stylesheet" href="css/style.css">

    </head>

    <body>

      <jsp:include page="/components/header.jsp"/>

      <div class="container">

        <div class="hotbrand col-lg-12 d-flex" style="margin-top: 40px;justify-content: space-around;">

          <a href="filter?brand=2" class="btn col-lg-2 d-flex align-items-center justify-content-center logobtn"
            style="border: solid grey 2px; border-radius: 40px;padding: 0;background-color: white;">
            <img src="images/logo-samsung.png" alt="SAMSUNG" style="height: 45px;">
          </a>

          <a href="filter?brand=1" class="btn col-lg-2 d-flex align-items-center justify-content-center logobtn"
            style="border: solid grey 2px; border-radius: 40px;padding: 0;background-color: white;">
            <img src="images/logo-iphone.jpg" alt="iPhone" style="height: 45px;">
          </a>

          <a href="filter?brand=3" class="btn col-lg-2 logobtn"
            style="border: solid grey 2px; border-radius: 40px;padding: 0;background-color: white;">
            <img src="images/logo-xiaomi.png" alt="Xiaomi" style="height: 60px;">
          </a>

          <a href="filter?brand=4" class="btn col-lg-2 d-flex align-items-center justify-content-center logobtn"
            style="border: solid grey 2px; border-radius: 40px;padding: 0;background-color: white;">
            <img src="images/logo-oppo.png" alt="Oppo" style="height: 40px;margin-top: 7px;">
          </a>

          <a href="filter?brand=7" class="btn col-lg-2 d-flex align-items-center justify-content-center logobtn"
            style="border: solid grey 2px; border-radius: 40px;padding: 0;background-color: white;">
            <img src="images/logo-nokia.jpg" alt="Nokia" style="height: 47px;">
          </a>

        </div>

        <jsp:include page="/components/filter.jsp"/>

        <h2 class="list-header">${requestScope.listproduct.size()} sản phẩm</h2>

        <div class="phonelist row">


          <c:forEach items="${requestScope.listproduct}" var="p">

            <div class="product col-lg-2">
              <a href="show?phoneName=${p.phoneName}" style="text-decoration: none;">
                <div class="pr-image">
                  <img src="${p.image}" alt="">
                </div>

                <p class="pr-name">${p.phoneName}</p>
                <p class="pr-screen">
                  <span>${p.screen}</span>
                </p>
                <span class="pr-chip">${p.chip}</span>

                <div class="pr-rom">
                  <c:forEach items="${p.rom}" var="r">
                    <p class="pr-rom-op">${r}</p>
                  </c:forEach>
                </div>
                
                <div class="pr-rom">
                  <c:forEach items="${p.color}" var="c">
                    <p class="pr-rom-op">${c}</p>
                  </c:forEach>
                </div>

                <h4 class="pr-price">${p.price}đ</h4>
                <p>
                  <span class="fa fa-star checked"></span>
                  <span class="fa fa-star checked"></span>
                  <span class="fa fa-star checked"></span>
                  <span class="fa fa-star checked"></span>
                  <span class="fa fa-star checked"></span>
                  <span class="evaluate"></span>
                </p>
              </a>
            </div>
          </c:forEach>

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