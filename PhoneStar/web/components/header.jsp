<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@page contentType="text/html" pageEncoding="UTF-8" %>

    <header class="p-3 text-bg-secondary">
      <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
          <a href="home" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
            <img src="images/PhoneStar.png" alt="Logo" style="height: 50px; border-radius: 5px;">
          </a>

          <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
            <li><a href="home" class="nav-link px-2 hd-item" style="margin-left: 25px;">Trang chủ</a></li>
            <li><a href="shop" class="nav-link px-2 hd-item">Cửa hàng</a></li>
            <li><a href="cart" class="nav-link px-2 hd-item"><i class="bi-cart2"></i><span>&nbsp;&nbsp;Giỏ hàng</span></a>
            </li>
            <li><a href="history" class="nav-link px-2 hd-item">Lịch sử mua</a></li>
            <li>
              <c:if test="${(sessionScope.acc != null) && (sessionScope.acc.role==1)}">
                <div class="dropdown">
                  <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown"
                          aria-expanded="false" style="font-size: 18px;">
                    Quản lý
                  </button>
                  <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="add">Thêm sản phẩm</a></li>
                    <li><a class="dropdown-item" href="inventory">Kho hàng</a></li>
                    <li><a class="dropdown-item" href="listb">Các đơn hàng</a></li>
                    <li><a class="dropdown-item" href="listu">Quản lí người dùng</a></li>
                    <li><a class="dropdown-item" href="tk">Thống kê số liệu</a></li>
                  </ul>
                </div>
              </c:if>
            </li>
          </ul>




          <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search" action="search" method="post">
            <input type="search" class="form-control form-control-dark text-bg-white" placeholder="Search..."
              aria-label="Search" name="text">
          </form>

          <div class="text-end">
            <c:choose>
              <c:when test="${not empty sessionScope.acc}">
                <!-- User is logged in -->

                <div class="dropdown">
                  <button class="btn btn-primary dropdown-toggle hello" type="button" data-bs-toggle="dropdown"
                    aria-expanded="false">
                    Hello, ${sessionScope.acc.userName} <i class="bi-person"></i>
                  </button>
                  <ul class="dropdown-menu drop-mn">
                    <li><button class="dropdown-item" type="button"><a href="uprofile.jsp" class="dra">Thay đổi thông
                          tin</a></button></li>
                    <li><button class="dropdown-item" type="button"><a href="upass.jsp" class="dra">Thay đổi mật
                          khẩu</a></button></li>
                    <hr style="width: 85%;margin: 0 auto;margin-top: 7px;">
                    <li><button class="dropdown-item" type="button"><a href="logout?type=login" class="dra">Đăng
                          xuất</a></button></li>
                  </ul>
                </div>

              </c:when>
              <c:otherwise>
                <!-- No user in session, show login and sign up -->
                <a href="logout?type=login" class="btn btn-outline-light me-2">Đăng nhập</a>
                <a href="logout?type=register" class="btn btn-warning">Đăng ký</a>
              </c:otherwise>
            </c:choose>
          </div>
        </div>
      </div>
    </header>