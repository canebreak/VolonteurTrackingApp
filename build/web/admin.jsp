<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include  file="head.html" %>
        <link rel="stylesheet" href="css/admin-css.css"/>
        <script src="js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VTA | Admin page</title>
    </head>
    <body>
    <c:if test="${empty sessionScope.userEvents}">
        <jsp:forward page = "index.jsp"/>
    </c:if>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <img src="img/logo.png" alt="Logo" class="img-center"/>
            <a href="new_event.jsp" class="btn btn-success">Dodaj akciju</a>
            <a href="GetEvents" class="btn btn-info">Vidi akcije</a>
            <a href="GetUsers" class="btn btn-info">Vidi sve volontere</a>
            <a href="deactivate_user.jsp" class="btn btn-danger">Deaktiviraj volontera</a>
            <a href="change_password.jsp" class="btn btn-primary">Promeni sifru</a>
            <a href="Logout" class="btn btn-primary">Log out</a>
        </div>
    </div>
</body>
</html>
