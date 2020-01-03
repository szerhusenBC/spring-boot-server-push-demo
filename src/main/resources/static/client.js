$(function () {
    var socket = new SockJS("socket");

    var $counter = $("#counter");

    var stompClient = Stomp.over(socket);

    stompClient.connect({}, function (frame) {
        // Do something, all subscribes must be done is this callback
        // This is needed because this will be executed after a (re)connect

        stompClient.subscribe('/topic/notification', function (message) {
            // do something with the message
            $counter.text(JSON.parse(message.body).count);

            // and acknowledge it
            message.ack();
        });
    });
});
