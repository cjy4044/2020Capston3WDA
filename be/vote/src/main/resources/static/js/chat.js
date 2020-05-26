$(document).ready(function() {
    $(function() {
        var socket = io("http://localhost:4000");
        $('#chatform').submit(function(e) {
            e.preventDefault(); // prevents page reloading
            socket.emit('chat message', $('#chatinput').val());
            $('#chatinput').val('');
            return false;
        });
        socket.on('chat message', function(msg) {
            $('#messages').append($('<li>').text(msg));
            $("#messages").scrollTop($("#messages")[0].scrollHeight);
        });
    });
    
    $(function() {
        $(".c_h").click(function(e) {
            if ($(".chat_container").is(":visible")) {
                $(".c_h .right_c .mini").text("+")
            } else {
                $(".c_h .right_c .mini").text("-")
            }
            $(".chat_container").slideToggle("slow");
            return false
        });
    });
});