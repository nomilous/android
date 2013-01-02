require('socket.io').listen(3000)

    .sockets.on 'connection', (socket) -> 

        socket.on 'orientation', (payload) -> 

            console.log "\n", payload