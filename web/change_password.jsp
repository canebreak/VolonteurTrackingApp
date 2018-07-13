<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include  file="head.html" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VTA | Change password</title>
    </head>
    <body>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <img src="img/logo.png" alt="Logo" class="img-center"/>
                <h3 class="text-danger text-center" id="message">
                    ${sessionScope.message}
                </h3>
                <form action="ChangePassword" method="POST">
                    Stara sifra: <input type="password" name="oldPassword" class="form-control" required/><br/>
                    Nova sifra <input type="password" name="newPassword" class="form-control" required/><br/>
                    Potvrda nove sifre <input type="password" name="newPasswordConfirm" class="form-control" required/><br/>
                    <input type="submit" class="submit-button" value="Promeni sifru"/>
                </form>
            </div>
        </div>
    </body>
</html>
