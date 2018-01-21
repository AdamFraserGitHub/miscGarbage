var canvas = document.getElementById('canvas');
var ctx = canvas.getContext('2d');

var radius = 100;
var points = [];

var dXPoints = (Math.sin(30 / 180 * Math.PI)).toFixed(2) * radius; //round to deal with FP innacuracies
var halfHeight = Math.sqrt((radius * radius) - (dXPoints * dXPoints));

for(var i = 0; i < 6; i++) {
    points[i] = new Object();
}

for(var i = 0; i < Math.floor(800 / radius / 1.5); i++) {
    tile(i * radius * 1.5 + radius, halfHeight * (i % 2), radius);
}

for(var i = 0; i < Math.floor(800 / radius / 1.5); i++) {
    tile(i * radius * 1.5 + radius, halfHeight * (i % 2) + 2*halfHeight, radius);
}

for(var i = 0; i < Math.floor(800 / radius / 1.5); i++) {
    tile(i * radius * 1.5 + radius, halfHeight * (i % 2) + 4*halfHeight, radius);
}

function tile(centX,centY,radius) {
    points[0].x = centX - dXPoints;
    points[1].x = centX + dXPoints;
    points[2].x = centX + 2*dXPoints;
    points[3].x = centX + dXPoints;
    points[4].x = centX - dXPoints;
    points[5].x = centX - 2*dXPoints;

    for(var i = 0; i < 6; i++) {
        var dXCent = points[i].x - centX
        points[i].dYCent = Math.sqrt((radius * radius) - (dXCent * dXCent));
        if(i > 2) {
            points[i].dYCent *= -1;
        }
    }

    ctx.beginPath();
        ctx.moveTo(points[0].x, centY + points[0].dYCent);
        ctx.lineTo(points[1].x, centY + points[1].dYCent);
        ctx.lineTo(points[2].x, centY + points[2].dYCent);
        ctx.lineTo(points[3].x, centY + points[3].dYCent);
        ctx.lineTo(points[4].x, centY + points[4].dYCent);
        ctx.lineTo(points[5].x, centY + points[5].dYCent);
        ctx.lineTo(points[0].x, centY + points[0].dYCent);
        ctx.stroke();
    ctx.closePath();
}
