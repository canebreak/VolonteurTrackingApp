<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include  file="head.html" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VTA | Svi korisnici</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <img src="img/logo.png" alt="Logo" class="img-center" />
                <div class="row">
                    <div class="col-md-6">
                        <button class="btn btn-default"><a href="ReturnToAdmin">Nazad</a></button>
                    </div>
                </div>
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
                            <c:forEach var="user" items="${sessionScope.users}">
                                <tr>
                                    <td>
                                        <a href="GetUserInfo?userId=${user.id}">${user.name}</a><br/>
                                        <a class="delete-event-btn" href="DeleteUserFromEvent?userId=${user.id}&eventId=${sessionScope.eventId}">Obrisi korisnika sa akcije</a>
                                    </td>
                                    <td>${user.lastName}</td>
                                    <td>${user.birthday}</td>
                                    <td>${user.totalHours}</td>
                                    <td>${user.startYear}</td>
                                    <td>${user.username}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

