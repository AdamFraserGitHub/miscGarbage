var ctx = document.getElementById('canvas').getContext('2d');
var collumWidth = 3; // number of nodes per collum
var nodeDiameter = 25; //diameter in pixels
var nodeRadius = nodeDiameter / 2;
var nodeSpacing = 150; //space between the begining of one collum / row and the start of annother

var lineColors = ['red','orange','yellow','green','lightBlue','blue','purple','black','magenta'];

var edgeList =[ [0,1], [0,6], [0,8], 
                [1,4], [1,6], [1,9], 
                [2,4], [2,6], 
                [3,4], [3,5],
                [3,8], 
                [4,5], [4,9], 
                [7,8], [7,9], [7,10]];

var nodePositions = [[0,1,2,3,4,5,6,7,8,9],[0,1]];
var numNodes = findNumNodes(edgeList);

for(var i = 0; i < Math.ceil(numNodes / collumWidth); i++) {
    if(Math.ceil(numNodes / collumWidth) - i > 1) {
        for(var j = 0; j < collumWidth; j++) {
                var index = j + collumWidth*i;
                nodePositions[index] = new Object();
                nodePositions[index].x = j * nodeSpacing + nodeDiameter + Math.random() * 50;
                nodePositions[index].y = i * nodeSpacing + nodeDiameter + Math.random() * 50;
                ctx.arc(nodePositions[index].x, nodePositions[index].y, nodeRadius, 0, Math.PI * 2);
                ctx.fill();
            ctx.closePath();
        }
    } else {
        for(var j = 0; j < numNodes - ((Math.ceil(numNodes / collumWidth) - 1) * collumWidth); j++) {
            ctx.beginPath();
                var index = j + collumWidth*i;
                nodePositions[index] = new Object();
                nodePositions[index].x = j * nodeSpacing + nodeDiameter + Math.random() * 50;
                nodePositions[index].y = i * nodeSpacing + nodeDiameter + Math.random() * 50;
                ctx.arc(nodePositions[index].x, nodePositions[index].y, nodeRadius, 0, Math.PI * 2);
                ctx.fill();
            ctx.closePath();
        }
    }
}

for(var i = 0; i < edgeList.length; i++) {
    ctx.beginPath();
        ctx.lineWidth = 3;
        ctx.strokeStyle = lineColors[Math.round(Math.random() * lineColors.length)];
        ctx.moveTo(nodePositions[edgeList[i][0]].x,nodePositions[edgeList[i][0]].y);
        ctx.lineTo(nodePositions[edgeList[i][1]].x,nodePositions[edgeList[i][1]].y);
        ctx.stroke();
    ctx.closePath();
}





function findNumNodes(edgeList) {
    var nNodes = 0;

    for(var i = 0; i < edgeList.length; i++) {
        for(var j = 0; j < 2; j++) {
            if(edgeList[i][j] > nNodes) { nNodes = edgeList[i][j]; }
        }
    }

    return nNodes + 1;
}