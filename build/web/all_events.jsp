<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include  file="head.html" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VTA | Sve akcije</title>
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
                                <th>Datum</th>
                                <th>Pocetak akcije</th>
                                <th>Mesto</th>
                                <th>Kraj akcije</th>
                                <th>Trajanje u satima</th>
                                <th>Broj volontera</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="event" items="${sessionScope.events}" >
                             <tr>
                                <td>
                                    <a href="GetUsersForEvent?eventId=${event.id}">${event.name}</a>
                                </td>
                                <td>${event.place}</td>
                                <td>${event.date}</td>
                                <td>${event.startTime}</td>
                                <td>${event.endTime}</td>
                                <td>${event.durationInHours}</td>
                                <td>${event.volonteurNumber}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
