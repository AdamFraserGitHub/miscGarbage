var canvas = document.getElementById('displayCanvas');
var ctx = canvas.getContext('2d');

var nPoints = 500;
var points = [];
var count;
var height = canvas.height;
var width = canvas.width;

setInterval(loop, 1000/10);

function loop() {
    ctx.clearRect(0,0,width,height);
    ctx.fillStyle = 'rgb(0,0,0)'
    ctx.fillRect(0,0,width,height);

    ctx.fillStyle = 'rgb(255,0,0)'
    ctx.beginPath();
    for(var i = 0; i < nPoints; i++) {
        points[i] = [Math.random() * 0.98 + 0.01, Math.random() * 0.98 + 0.01];
    }




    for (var currentPoint = 0; currentPoint < nPoints; currentPoint++) {
        var smallestSize = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
        var smallestDistancePointIndex;
        var naturalPath = false;
        for(var checkPoint = currentPoint + 1; checkPoint < nPoints; checkPoint++){
            var absDist = distanceBetweenPoints(points[checkPoint],points[currentPoint]);
            // console.log(absDist);
            if(absDist < smallestSize && checkPoint != currentPoint) {
                // console.log(absDist + "    " + smallestSize);
                smallestSize = absDist;
                smallestDistancePointIndex = checkPoint;
            }
            
            if(absDist < 50) {
                ctx.beginPath()
                ctx.strokeStyle = 'rgb(100,255,0)';
                ctx.moveTo(points[currentPoint][0] * width,points[currentPoint][1] * height);
                ctx.lineTo(points[checkPoint][0] * width,points[checkPoint][1] * height);
                ctx.stroke();
                ctx.closePath();
                naturalPath = true;
            }
    
        }
        // console.log(smallestDistancePointIndex);
        if(!naturalPath) {
            ctx.beginPath();
            ctx.strokeStyle = 'rgb(100,255,0)';
            ctx.moveTo(points[currentPoint][0] * width,points[currentPoint][1] * height);
            ctx.lineTo(points[smallestDistancePointIndex][0] * width,points[smallestDistancePointIndex][1] * height);
            ctx.stroke();
            ctx.closePath();
        }
    } 
    ctx.fill();
    ctx.closePath();

    for(var i = 0; i < nPoints; i++) {
        ctx.fillRect(points[i][0] * width, points[i][1] * height,5,5);

    }

    function distanceBetweenPoints(point1, point2) {
        var dx = (point2[0] - point1[0]) * width;
        var dy = (point2[1] - point1[1]) * height;

        return Math.sqrt(dx*dx + dy*dy);
    }
}