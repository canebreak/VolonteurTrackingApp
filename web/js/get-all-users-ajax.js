let _users = [];
$(document).ready(function () {
    $(".btn-get-available-users").on('click',getUsers);
    $(".btn-add-selected-user").on('click', addUserToEvent);
    
});

function getUsers() {
    _users = [];
    
    let eventId = $(this).data('eventid');
    $.ajax({
        type: 'GET',
        url: 'GetAvailableUsersForEvent?eventId='+eventId,
        contentType: 'application/json; charset=utf-8',
        success: function (response) {
            _users = JSON.parse(response);
            populateSelect(eventId);
            
        },
        error: function (response) {
            alert(response);
        }
    });
}

function populateSelect(eventId)
{
    let select = $("#select-"+eventId);
    let html = "";
    
    for(let i = 0;i<_users.length;i++){
        html+="<option class='userSelect' value='"+_users[i].id+"'>";
        html+=_users[i].name + " " + _users[i].lastName;
        html+= " " +_users[i].birthday;
        html += "</option>";
    }
    select.html(html);
    
}
function addUserToEvent(){
        let eventId = $(this).data('eventid');
        let userId = $("#select-"+eventId).val();
        let hours = $("#hours-"+eventId).val();
        
        if(hours === "" || hours === undefined)
        {
            return false;
        }
        $.ajax({
        type: 'GET',
        url: 'AddUserToEvent?eventId='+eventId+'&userId='+userId+'&hours='+hours,
        contentType: 'application/json; charset=utf-8',
        success: function () {
            showNotification(true);
        },
        error: function (response) {
            console.log(response);
             showNotification(false);

        }
    });
}