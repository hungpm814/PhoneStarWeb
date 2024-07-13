<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/stylelogin.css">
        <style>
            .login {
                border: 1px solid grey;
                padding: 15px;
                border-radius: 15px;
                border: none;
                box-shadow: 0 2px 12px rgba(0,0,0,.12);
                height: 550px;
                background-color: white;margin-top: 50px;
            }
        </style>
    </head>

    <body>
        <div class="login" style="width: 20%;">
            <h1 style="text-align: center; margin: 5px; margin-top: 25px; color: rgb(86, 141, 189);">Đăng nhập</h1>
            <div class="logo">
                <img src="images/PhoneStar.png" alt="Phone Star">
            </div>
            <form action="login" method="post">
                <label for="username" class="lb">Username:</label></br>
                <input type="text" name="username" id="username" class="iput" required /></br>

                <label for="pass" class="lb">Password:</label></br>
                <input type="password" name="pass" id="pass" class="iput" required />

                <p style="color: red; margin-left: 20px; font-style: italic;">
                    <% if(request.getAttribute("mes") !=null){ 
                        String err=(String)request.getAttribute("mes");
                        out.println(err); 
                        } 
                    %>
                </p>

                <center>
                    <input type="submit" value="LOGIN" class="send"/><br>
                    <span>Bạn chưa có tài khoản? </span><a href="register.jsp">Đăng ký ngay</a>
                </center>


            </form>
        </div>
    </body>

    </html>