<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include  file="head.html" %>
        <script src="js/get-all-users-ajax.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VTA | Sve akcije</title>
    </head>
    <body>
        <div class="notification">
</div>
        <div class="container">
            <div class="row">
                <img src="img/logo.png" alt="Logo" class="img-center"/>
                <button class="btn btn-default"><a href="ReturnToAdmin">Nazad</a></button>
                <h3 class="text-danger text-center" id="message">
                    ${sessionScope.message}
                </h3>
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
                                <th>Dodaj volontera</th>
                                <th>Broj sati</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="event" items="${sessionScope.events}" >
                                <tr>
                                    <td>
                                        <a href="GetUsersForEvent?eventId=${event.id}">${event.name}</a><br/>
                                        <a href="DeleteEvent?eventId=${event.id}" class="delete-event-btn">Obrisi akciju</a>
                                    </td>
                                    <td>${event.place}</td>
                                    <td>${event.date}</td>
                                    <td>${event.startTime}</td>
                                    <td>${event.endTime}</td>
                                    <td>${event.durationInHours}</td>
                                    <td style="width:250px">
                                        <select class="add-user" id="select-${event.id}"></select>
                                        <button class="btn-get-available-users" data-eventid="${event.id}">Vidi slobodne</button>
                                        <button class="btn-add-selected-user" data-eventid="${event.id}">Dodaj izabranog</button>
                                    </td>
                                    <td><input type="number" class="hours-input" id="hours-${event.id}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
