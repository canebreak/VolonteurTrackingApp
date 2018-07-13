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
                <h3 class="text-danger text-center" id="message">
                    ${sessionScope.message}
                </h3>                <div class="col-md-10 col-md-offset-1">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Ime</th>
                                <th>Prezime</th>
                                <th>Datum rodjenja</th>
                                <th>Godina pocetka</th>
                                <th>Korisnicko ime</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${sessionScope.users}" >
                                <tr>
                                    <td>
                                        <a href="GetEventsForUser?userId=${user.id}">${user.name}</a>
                                        <br/>
                                        <a href="DeelteUser?userId=${user.id}" class="delete-event-btn">Obrisi korisnika</a>

                                    </td>
                                    <td>${user.lastName}</td>
                                    <td>${user.birthday}</td>
                                    <td>${user.startYear}</td>
                                    <td>${user.username}</td>
                                </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

