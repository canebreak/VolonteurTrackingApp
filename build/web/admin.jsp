<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="head.html"></c:import>   
            <link rel="stylesheet" href="css/admin-css.css"/>
            <script src="js/bootstrap.min.js"></script>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>VTA | Admin strana</title>
        </head>
        <body>
            <div class="container">
                <div class="row">
                    <div class="col-md-4 col-md-offset-4">
                        <img src="img/logo.png" alt="Logo" class="img-center"/>
                    <h4 class="text-danger text-center" id="message">
                        ${sessionScope.message}
                    </h4>
                    <a href="new_event.jsp" class="btn btn-success">Dodaj akciju</a>
                    <a href="GetAllEvents" class="btn btn-info">Vidi sve akcije</a>
                    <a href="GetAllUsers" class="btn btn-info">Vidi sve volontere</a>
                    <a href="change_password.jsp" class="btn btn-primary">Promeni sifru</a>
                    <a href="Logout" class="btn btn-primary">Log out</a>
                </div>
                <div class="col-md-4">
                    <br/><br/><br/><br/><br/>
                    <p><strong>Ime:</strong> <c:out value="${sessionScope.user.name}" /></p>
                    <p><strong>Prezime:</strong> <c:out value="${sessionScope.user.lastName}" /></p>
                    <p><strong>Datum rodjenja:</strong><c:out value="${sessionScope.user.birthday}" /></p>
                    <p><strong>Broj sati: </strong><c:out value="${sessionScope.userHours}" /></p>
                    <p><strong>Godina pocetka:</strong> <c:out value="${sessionScope.user.startYear}" /></p>
                    <p><strong>Korisnicko ime:</strong> <c:out value="${sessionScope.user.username}" /></p>
                </div>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Ime</th>
                            <th>Mesto</th>
                            <th>Datum</th>
                            <th>Pocetak</th>
                            <th>Kraj</th>
                            <th>Prisustvo u casovima</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${sessionScope.userEvents}" var="event" >
                            <tr>
                                <td>${event.name}</td>
                                <td>${event.place}</td>
                                <td>${event.date}</td>
                                <td>${event.startTime}</td>
                                <td>${event.endTime}</td>
                                <td>${event.durationInHours}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
