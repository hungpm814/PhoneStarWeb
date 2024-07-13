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
            background-color: white;
            margin-top: 50px;
        }
    </style>
</head>

<body>
    <div class="login" style="width: 20%;">
        <h1 style="text-align: center; margin: 5px; margin-top: 25px; color: rgb(86, 141, 189);">Đăng ký</h1>
        <div class="logo">
            <img src="images/PhoneStar.png" alt="Phone Star">
        </div>
        <form action="register" method="post" name="myForm">
            <label for="username" class="lb">Username:</label>
            <input type="text" name="username" id="username" class="iput" required /><br>

            <label for="pass" class="lb">Password:</label><br>
            <input type="password" name="pass" id="pass" class="iput" onkeyup="validate()" required /><br>
            <span style="margin-left: 20px;">Độ mạnh mật khẩu:</span> <span id="mylocation">None</span>

            <p style="color: red; margin-left: 20px; font-style: italic;">
                <% if(request.getAttribute("mes") !=null){ 
                    String err=(String)request.getAttribute("mes");
                    out.println(err); 
                    } 
                %>
            </p>

            <center>
                <input type="submit" value="SIGN-UP" class="send"/><br>
                <span>Bạn đã có tài khoản? </span><a href="login.jsp">Đăng nhập</a>
            </center>
        </form>
    </div>

    <script type="text/javascript">
        function validate() {
            var msg;
            if (document.getElementById('pass').value.length > 4) {
                msg = "Tốt";
            } else {
                msg = "Yếu";
            }
            document.getElementById('mylocation').innerText = msg;
        }
    </script>
</body>

</html>
