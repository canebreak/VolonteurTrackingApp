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
                            <c:forEach var="current" items="${sessionScope.events}" >
                                <tr>
                                    <td>${current.name}</td>
                                    <td>${current.date}</td>
                                    <td>${current.startTime}</td>
                                    <td>${current.place}</td>
                                    <td>${current.endTime}</td>
                                    <td>${current.durationInHours}</td>
                                    <td>${current.volonteurNumber}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
