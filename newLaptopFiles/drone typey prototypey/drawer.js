var canvas = document.getElementById("canvas"),
    ctx = canvas.getContext('2d'),
    ctxWidth = canvas.width;
    ctxHeight = canvas.height;

var word = ['A','B','B','A'],
    nLetters = word.length;

ctx.fillStyle = 'rgb(0)';
ctx.rect(0,0,ctxWidth,ctxHeight);
ctx.fill();

ctx.strokeStyle = 'rgb(0,255,0)';
var letterToNumber;

for(var letterIndex = 0; letterIndex < nLetters; letterIndex++){
    letterToNumber = word[letterIndex].charCodeAt() - 65;
    for(var letterSection = 0; letterSection < letters[letterToNumber].length; letterSection++){
        for(var letterPoint = 0; letterPoint < letters[letterToNumber][letterSection].length - 2; letterPoint+=2){
            ctx.beginPath();
                ctx.moveTo((letters[letterToNumber][letterSection][letterPoint] * ctxWidth / nLetters) + letterIndex/nLetters * ctxWidth,
                        letters[letterToNumber][letterSection][letterPoint + 1] * (ctxHeight / nLetters) + (2 * ctxHeight / nLetters));

                ctx.lineTo((letters[letterToNumber][letterSection][letterPoint + 2] * ctxWidth / nLetters) + letterIndex/nLetters * ctxWidth, 
                        letters[letterToNumber][letterSection][letterPoint + 3] * (ctxHeight / nLetters) + (2 * ctxHeight / nLetters));

                ctx.stroke();
            ctx.closePath();
        }
    }
}