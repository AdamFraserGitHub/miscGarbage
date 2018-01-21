var ctx = document.getElementById('canvas').getContext('2d');
var matrix =  [ [0, 0.5, 0, 0, 0, 0, 0.5, 0, 0.5, 0],
                [0.5, 0, 0, 0, 0.5, 0, 0.5, 0, 0, 0.5],
                [0, 0, 0, 0, 0.5, 0, 0.5, 0, 0, 0],
                [0, 0, 0, 0, 0.5, 0.5, 0, 0, 0.5, 0],
                [0, 0.5, 0.5, 0.5, 0, 0.5, 0, 0, 0, 0.5],
                [0, 0, 0, 0.5, 0.5, 0, 0, 0, 0, 0],
                [0.5, 0.5, 0.5, 0, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 0, 0, 0, 0.5, 0.5],
                [0.5, 0, 0, 0.5, 0, 0, 0, 0.5, 0, 0],
                [0, 0.5, 0, 0, 0.5, 0, 0, 0.5, 0, 0] ];
                //way to store weights and positions?
var matrixWidth = matrix[0].length;
var matrixHeight = matrix.length;
var nNodes = countNodes(matrix);










function countNodes(matrix) {
    var nNodes = 0;
    for(var i = 0; i < matrixWidth; i++) {
        for(var j = 0; j < matrixHeight; j++) {
            if(matrix[i][j] > 0) {
                nNodes += 0.5 //since there will be two markers for a single node
            }
        }
    }
    return nNodes;
}