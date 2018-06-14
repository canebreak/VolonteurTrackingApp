
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include  file="head.html" %>
        <link rel="stylesheet" href="css/login-css.css"/>
        <script src="js/login.js"></script>
        <title>VTA | Login</title>
    </head>
    <body>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <img src="img/logo.png" alt="Logo" class="img-center"/>
                <h3 class="text-danger text-center" id="message">${message}</h3>
                <form action="Login" method="POST">
                    Korisnicko ime: <input type="text" name="username" class="form-control" required/><br/>
                    Sifra: <input type="password" name="password" class="form-control" required/><br/>

                    <input type="submit" class="submit-button" value="Login"/>
                </form>
                <br/>
                <a href="register.jsp">Registrujte se</a>
            </div>
        </div>
    </body>
</html>
