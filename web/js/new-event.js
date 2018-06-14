$(document).ready(function () {
    $("#eventEnd").change(countHours);
});

function countHours()
{
    let eventStart = $("#eventStart").val();
    let eventEnd = $("#eventEnd").val();
    let hoursInput = $("#hours");



    let eventStartArray = eventStart.split(":");
    let eventEndArray = eventEnd.split(":");

    if (eventStart === "" || eventEnd === "")
    {
        return;
    }
    if (isNaN(eventStartArray[0]) || isNaN(eventEndArray[0]))
    {
        return;
    }


    let minutes = Math.abs((eventStartArray[0] * 60 + parseInt(eventStartArray[1])) -
            (eventEndArray[0] * 60 + parseInt(eventEndArray[1])));

    console.log(Math.floor(minutes / 60) + ":" + minutes % 60);

    hoursInput.val(Math.round(minutes / 60));

}