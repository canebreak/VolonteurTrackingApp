<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> <script
            src="https://code.jquery.com/jquery-3.3.1.js"
            integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
        crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css"/>
        <link rel="stylesheet" href="css/login-css.css"/>
        <script src="js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VTA | Change password</title>
    </head>
    <body>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <img src="img/logo.png" alt="Logo" class="img-responsive"/>
                <form action="ChangePassword" method="POST">
                    Stara sifra: <input type="password" name="oldPassword" class="form-control" required/><br/>
                    Nova sifra <input type="password" name="newPassword" class="form-control" required/><br/>
                    Potvrda nove sifre <input type="password" name="newPasswordConfirm" class="form-control" required/><br/>

                    <input type="submit" class="submit-button" value="Login"/>
                </form>
            </div>
        </div>
    </body>
</html>
