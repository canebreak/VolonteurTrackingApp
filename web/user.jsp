<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- C:if -->

<html>
    <head> 
        <%@include file="head.html" %>
        <link rel="stylesheet" href="css/user.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VTA | <c:out value="${sessionScope.user.name}" />
</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <img src="img/logo.png" alt="Logo" class="img-center"/>
                <div class="col-md-10 col-md-offset-1">
                    <div class="row">
                        <div class="col-md-4 col-md-offset-4">
                            <div class="row">
                                <div class="col-md-8 col-md-offset-2">
                                    <p><strong>Ime:</strong> <c:out value="${sessionScope.user.name}" /></p>
                                    <p><strong>Prezime:</strong> <c:out value="${sessionScope.user.lastName}" /></p>
                                    <p><strong>Datum rodjenja:</strong><c:out value="${sessionScope.user.birthday}" /></p>
                                    <p><strong>Broj sati: </strong><c:out value="${sessionScope.user.totalHours}" /></p>
                                    <p><strong>Godina pocetka:</strong> <c:out value="${sessionScope.user.startYear}" /></p>
                                    <p><strong>Korisnicko ime:</strong> <c:out value="${sessionScope.user.username}" /></p>
                                    <a href="change_password.jsp" class="btn btn-primary">Promeni sifru</a>
                                    <a href="Logout" class="btn btn-primary">Log out</a>
                                </div>
                            </div>
                        </div>
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
                            <c:forEach items="${sessionScope.events}" var="event" >
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
        </div>
        <br/><br/>
        <footer class="footer">
            test
        </footer>
    </body>
</html>
