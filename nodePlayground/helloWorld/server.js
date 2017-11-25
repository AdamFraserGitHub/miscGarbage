var http = require('http');
var fs = require('fs');
var path = require('path');

var extensions = {
    "" : "text/html",
    ".html" : "text/html",
    ".png" : "image/png"
}

http.createServer(function(req, res){
    var reqPath;
    var contentType;

    if(req.url == '/') { reqPath = 'helloNode.html'; }
    else { reqPath = req.url.substr(1); };
    console.log(reqPath + " requested by " + req.connection.remoteAddress + "\n")

    contentType = contentTypeSelector(req.url);

    serveFile(res, reqPath, contentType);
}).listen(8081, "192.168.0.5");

function serveFile(res, reqPath, type){
    fs.readFile(reqPath, function(err, data) {
        res.writeHead(200, {'Content-Type': type});
        res.end(data); 
    });
}

function contentTypeSelector(requestURL) {
    return extensions[path.extname(requestURL)];
}