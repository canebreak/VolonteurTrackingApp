<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <script
            src="https://code.jquery.com/jquery-3.3.1.js"
            integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
        crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css"/>
        <script src="js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="row">
                    <div class="col-md-4 col-md-offset-4">
                        <div class="col-md-2">Ime:</div>
                        <div class="col-md-2 col-md-offset-2 pull-right">Ime</div>
                    </div></div>
                <div class="row">
                    <div class="col-md-4 col-md-offset-4">
                        <div class="col-md-2">Prezime:</div>
                        <div class="col-md-2 col-md-offset-2 pull-right">Prezime</div>
                    </div></div>
                <div class="row">
                    <div class="col-md-4 col-md-offset-4">
                        <div class="col-md-2">Datum rodjenja:</div>
                        <div class="col-md-2 col-md-offset-2 pull-right">Datum rodjenja</div>
                    </div></div>
                <div class="row">
                    <div class="col-md-4 col-md-offset-4">
                        <div class="col-md-2">Broj sati:</div>
                        <div class="col-md-2 col-md-offset-2 pull-right">Broj sati</div>
                    </div></div>
                <div class="row">
                    <div class="col-md-4 col-md-offset-4">
                        <div class="col-md-2">Aktivan od: </div>
                        <div class="col-md-2 col-md-offset-2 pull-right">Aktivan od</div>
                    </div></div>
                <div class="row">
                    <div class="col-md-4 col-md-offset-4">
                        <div class="col-md-2">Korisnicko ime: </div>
                        <div class="col-md-2 col-md-offset-2 pull-right">Korisnicko ime</div>
                    </div></div>
                
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
    </body>
</html>
