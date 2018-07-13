let _users = [];
$(document).ready(function () {
    $(".btn-get-available-users").click(getUsers);
});

function getUsers() {

    let eventId = $(this).data('eventid');
    $.ajax({
        type: 'GET',
        url: 'GetAvailableUsersForEvent?eventId='+eventId,
        contentType: 'application/json; charset=utf-8',
        success: function (response) {
            _users = JSON.parse(response);
            
        },
        error: function (response) {
            alert(response);
        }
    });
}