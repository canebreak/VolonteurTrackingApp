<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include  file="head.html" %>
        <script src="js/all-users.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VTA | All users</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <img src="img/logo.png" alt="Logo" class="img-center"/>
                <button class="btn btn-default"><a href="ReturnToAdmin">Nazad</a></button>
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
                                        <a href="GetUserInfo?userId=${user.id}">${user.name}</a>
                                        <br/>
                                        <button class="btn btn-default delete-event-btn" data-id="${user.id}" 
                                                data-target="#myModal"><a href="DeleteUser?userId=${user.id}">Obrisi korisnika</a></button>
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
        <!-- Modal -->
        <div id="myModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Modal Header</h4>
                    </div>
                    <div class="modal-body">
                        <p>Some text in the modal.</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>        
    </body>
</html>

