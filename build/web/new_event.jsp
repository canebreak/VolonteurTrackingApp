<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include  file="head.html" %>
        <script src="js/new-event.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VTA | nova akcija</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <img src="img/logo.png" alt="Logo" class="img-center"/>
                    <h3 class="text-danger text-center" id="message">
                        ${sessionScope.message}
                    </h3>
                    <form action="AddEvent" method="POST">
                        Ime <input type="text" name="name" class="form-control" required autofocus />
                        Datum <input type="date" name="date" class="form-control" required />
                        Adresa <input type="text" name="place" class="form-control" required />
                        Pocetak akcije <input type="text" name="startTime"  class="form-control" id="eventStart" required/>
                        Kraj akcije <input type="text" name="endTime" class="form-control" id="eventEnd" required/>
                        Trajanje u satima (automatski se popunjava)<input type="text" name="hoursDuration" class="form-control" id="hours" readonly />
                        <input type="submit" value="Dodaj akciju" class="submit-button" />
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
