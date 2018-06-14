$(document).ready(function() {
  var i = 0;
  function pulsate() {
    if(i >= 3) return;
    $("#message").
      animate({opacity: 0.2}, 500, 'linear').
      animate({opacity: 1}, 500, 'linear', pulsate);
    i++;
  }
  pulsate();
});