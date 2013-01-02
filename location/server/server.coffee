app    = require('express')()
server = require('http').createServer app
io     = require('socket.io').listen server
qrCode = require 'qrcode-npm'

qr = qrCode.qrcode 2, 'L'
qr.addData 'nnn.nnn.nnn.nnn:nnnnn:nn'
qr.make()
imageTag = qr.createImgTag 20, 0

server.listen 3000


app.get '/', (req, res) -> 

    res.send imageTag



io.sockets.on 'connection', (socket) -> 

    socket.on 'orientation', (payload) -> 

        console.log "\n", payload