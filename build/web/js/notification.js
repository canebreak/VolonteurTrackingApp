function showNotification(response)
{
    let htmlTrue = "<div class='alert alert-success'><strong>Korisnik dodat!</strong></div>";

    let htmlFalse = "  <div class='alert alert-danger'><strong>Korisnik nije dodat!</strong></div>";

    dispalyNotification();
    if (response)
    {

        $(".notification").html(htmlTrue);
    } else {
        $(".notification").html(htmlFalse);
    }

    hideNotification();
}

function dispalyNotification() {
    $(".notification").css({"visibility": "visible"});
}
function hideNotification() {
    setTimeout(function () {
        $(".notification").css({"visibility": "hidden"});
    }, 3000);
}