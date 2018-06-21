<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include  file="head.html" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VTA | All users</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <img src="img/logo.png" alt="Logo" class="img-center"/>
                <div class="col-md-10 col-md-offset-1">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Ime</th>
                                <th>Prezime</th>
                                <th>Datum rodjenja</th>
                                <th>Angazovanost</th>
                                <th>Godina pocetka</th>
                                <th>Korisnicko ime</th>
                            </tr>
                        </thead>
                        <tbody>
                           <c:forEach var="user" items="${sessionScope.userList}">
                             <tr>
                                <td>${user.name}</td>
                                <td>${user.lastName}</td>
                                <td>${user.birthday}</td>
                                <td>${user.totalHours}</td>
                                <td>${user.startYear}</td>
                                <td>${user.nickName}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

