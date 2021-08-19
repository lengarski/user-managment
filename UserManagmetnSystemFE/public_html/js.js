$(document).ready(function() {

         $.ajax({
            url: "http://backend:2020/users",
            type: "GET",
            crossDomain: true,
            headers: {
              "accept": "application/json",
              "Access-Control-Allow-Origin":"*"},

            success: function (response) {
                var resp = JSON.parse(response)
                alert(resp.status);
            },
            error: function (xhr, status) {
                alert("error");
            }
        });



});
