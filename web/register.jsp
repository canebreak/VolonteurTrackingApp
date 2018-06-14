
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include  file="head.html" %>
        <title>VTA | Register</title>
    </head>
    <body>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <img src="img/logo.png" alt="Logo" class="img-center"/>
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
