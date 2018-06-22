$(document).ready(function () {
    $(".btn-get-available-users").click(getUsers);
});

function getUsers() {

    let eventId = $(this).data('eventid');


    console.log(eventId);
    $.ajax({
        url: 'GetAvailableUsersForEvent',
        data: JSON.stringify(eventId),
        contentType: 'application/json; charset=utf-8',
        type: 'POST',
        success: function (response) {
            console.log(response);
        },
        error: function (response) {
            console.log(response);
        }
    });
}