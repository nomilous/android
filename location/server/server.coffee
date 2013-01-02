app    = require('express')()
server = require('http').createServer app
io     = require('socket.io').listen server
qrCode = require 'qrcode-npm'

qr = qrCode.qrcode 4, 'M'
qr.addData 'nnn.nnn.nnn.nnn:nnnnn:nn'
qr.make()

server.listen 3000


app.get '/', (req, res) -> 

    res.send qr.createImgTag(4)



io.sockets.on 'connection', (socket) -> 

    socket.on 'orientation', (payload) -> 

        console.log "\n", payload