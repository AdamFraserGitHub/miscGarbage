var canvas = document.getElementById('canvas');
var ctx = canvas.getContext('2d');
var nIn = 0, nTotal = 0;

ctx.strokeStyle = 'rgb(0,0,0)';
ctx.lineWidth = 1;

ctx.beginPath();
ctx.rect(0,0,500,500);
ctx.stroke();
ctx.closePath();

ctx.beginPath();
ctx.arc(250,250,250,0,2*Math.PI);
ctx.stroke();
ctx.closePath();

var timeStart100Mill = window.performance.now();

setInterval(monteCarloPoint, 0);
setInterval(piCalc, 5000);

function monteCarloPoint() {
    // ctx.beginPath();
    for(var i = 0; i < 100000; i++){
        nTotal++;
        var x = (Math.random() * 500);
        var y = (Math.random() * 500);
        var xAbs = Math.abs(x - 250);
        var yAbs = Math.abs(y - 250);
        if((xAbs*xAbs) + (yAbs*yAbs) <= 250*250) {
            // ctx.fillStyle = 'rgb(255,0,0)';
            nIn++;
        } //else {
            //ctx.fillStyle = 'rgb(0,0,255)';
        //}
        // ctx.fillRect(x,y,1,1);
    if(nTotal == 1000000000) {
        console.log('T:   ' + (window.performance.now() -timeStart100Mill));
    }
    }
    // ctx.closePath();
}

function piCalc() {
    console.log(((nIn / nTotal) * 500 * 500) / (250*250));
    console.log((nTotal / 1000000) + ' million points');
    console.log('\n');
}