"use strict"

$().ready(function() {
    var latitude = 0;
    var longitude = 0;
    // Position watch ID
    var watchId;

    $.getJSON("/participants", function(data) {
        $.each(data, function(index, user) {
            $("#participant").append('<option value="' + user.uuid + '">' + user.name + '</option>' );
        });
   });


   if(navigator.geolocation) {
        watchId = navigator.geolocation.watchPosition(updatePosition);
    } else {
      // Pas de support, proposer une alternative ?
    }

    $("#bac-form").submit(function(event) {
        event.preventDefault();
        var request = {
            uuid: $("#participant").val(),
            bac: $("#bac").val(),
            latitude: latitude,
            longitude: longitude
        };

        var jqxhr = $.ajax({
            url: "bac",
            dataType: "json",
            contentType: "application/json",
            method: "PUT",
            data: JSON.stringify(request)
        })
          .done(function() {
            $("#bac").val("");
            $("#message").text("Et bonne soirée !").show();
            $("#message").fadeOut(10 * 1000)
          })
          .fail(function() {
            $("#message").text("Oups ! Il y a eu un problème, vérifie ta saisie...").show();
            $("#message").fadeOut(10 * 1000)
          });
    });



    function updatePosition(position) {
        latitude = position.coords.latitude;
        longitude = position.coords.longitude;
    }
});


