var express = require("express");
var app = express();
var router = express.Router();
var path = __dirname + '/clientSide/';
var bodyParser = require('body-parser');

app.use(function (req,res,next) {
    if(req.method == 'GET'){
        console.log(req.method + "\n" + req.url + "\n" + req.connection.remoteAddress + "\n\n");
    }
    next();
});

app.use(bodyParser.urlencoded({ extended: true })); 

app.get("/",function(req,res){
    res.sendFile(path + "index.html");
});

app.get("/stylesheet.css",function(req,res){
    res.sendFile(path + "stylesheet.css");
});

app.post('/', function(req, res) {
    console.log(req.connection.remoteAddress + "  favourive colour is  " + req.body.colorChoice)
    res.writeHead(200, {'content-type' : 'text/html'})
    res.end("<html><link href='https://fonts.googleapis.com/css?family=Ubuntu' rel='stylesheet'><style>html, body {margin:0px; padding:0px; border: 0px; background-color:" + req.body.colorChoice + "} .textDisp{font-family: 'Ubuntu', sans-serif; top:40%; left:50%; transform: translateY(-50%); transform: translateX(-50%); position:absolute;}</style><body><h1 class='textDisp'>This is your favourite colour!</h1></body></html>");
});

app.use("/",router);

app.listen(8080, '0.0.0.0',function(){
    console.log("server online at local ip:8080");
});