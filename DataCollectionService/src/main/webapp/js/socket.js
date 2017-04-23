/**
 * Created by Egor on 22.04.2017.
 */
$(document).ready(function () {
    var $respPlaceholder = $("#resp");

    var webSocket = new WebSocket("ws://localhost:8080/respCounter");

    webSocket.onopen = function () {
        console.log("Connection is open");
    };

    webSocket.onmessage = function (event) {
        $respPlaceholder.html('Responses' + '(' + event.data + ')');
    };
});