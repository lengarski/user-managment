$(document).ready(function() {



      $.get("http://192.168.0.105:2020/users", function(data, status){
        alert("Data: " + data + "\nStatus: " + status);
      });


});
