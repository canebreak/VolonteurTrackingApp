<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <%@include  file="head.html" %>
        <link rel="stylesheet" href="css/user.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${empty sessionScope.userEvents}" >
            <jsp:forward page = "index.jsp"/>
        </c:if>
        <div class="container">
            <div class="row">
                <img src="img/logo.png" alt="Logo" class="img-center"/>
                <div class="col-md-10 col-md-offset-1">
                    <div class="row">
                        <div class="col-md-4 col-md-offset-4">
                            <div class="row">
                                <div class="col-md-8 col-md-offset-2">
                                    <p>Ime: <c:out value="${sessionScope.userEvents.name }"/></p>
                                    <p>Prezime: <c:out value="${sessionScope.userEvents.lastName }"/></p>
                                    <p>Datum rodjenja: <c:out value="${sessionScope.userEvents.birthday }"/></p>
                                    <p>Broj sati: <c:out value="${sessionScope.userEvents.totalHours }"/></p>
                                    <p>Godina pocetka: <c:out value="${sessionScope.userEvents.startYear }"/></p>
                                    <p>Korisnicko ime: <c:out value="${sessionScope.userEvents.nickName }"/></p>
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
                                <th>Trajanje</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>John</td>
                                <td>Doe</td>
                                <td>john@example.com</td>
                                <td>John</td>
                                <td>Doe</td>
                                <td>john@example.com</td>
                            </tr> <tr>
                                <td>John</td>
                                <td>Doe</td>
                                <td>john@example.com</td>
                                <td>John</td>
                                <td>Doe</td>
                                <td>john@example.com</td>
                            </tr> 
                            <tr>
                                <td>John</td>
                                <td>Doe</td>
                                <td>john@example.com</td>
                                <td>John</td>
                                <td>Doe</td>
                                <td>john@example.com</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
