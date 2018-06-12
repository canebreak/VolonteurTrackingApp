
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script
            src="https://code.jquery.com/jquery-3.3.1.js"
            integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
        crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css"/>
        <link rel="stylesheet" href="css/login-css.css"/>

        <script src="js/bootstrap.min.js"></script>
        <title>VTA | Register</title>
    </head>
    <body>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                            <img src="img/logo.png" alt="Logo" class="img-responsive"/>
                <form action="Register" method="POST">
                    Ime: <input type="text" name="name" class="form-control" required/><br/>
                    Prezime: <input type="text" name="lastName" class="form-control" required/><br/>
                    Datum rodjenja: <input type="date" name="birthday" class="form-control" required/><br/>
                    Godina pocetka volontiranja: <input type="text" name="startYear" class="form-control" required/><br/>
                    Korisnicko ime (koristi se za logovanje): <input type="text" name="nickName" class="form-control" required/><br/>
                    Sifra <input type="password" name="password" class="form-control" required/><br/>
                    <input type="submit" class="submit-button" value="Login"/>
                </form>
            </div>
        </div>
    </body>
</html>
