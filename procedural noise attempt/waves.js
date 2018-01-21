var canvas = document.getElementById('displayCanvas');
var ctx = canvas.getContext('2d');

var waves = [];

waves[0] = {
    type: 'sine',
    name: 'wave 0',
    values: [],
    functCoef: 1,
    xCoef: 0.1,
    functPhase: 0,
    xPhase: 0
};

waves[1] = {
    type: 'sine',
    name: 'wave 0',
    values: [],
    functCoef: 0.75,
    xCoef: 0.25,
    functPhase: 0,
    xPhase: 50
};

waves[2] = {
    type: 'sine',
    name: 'wave 0',
    values: [],
    functCoef: 0.25,
    xCoef: 1,
    functPhase: 0,
    xPhase: 0
};

waves[3] ={
    type: 'sine',
    name: 'wave 1',
    values: [],
    functCoef: 0.25,
    xCoef: 1,
    functPhase: 0,
    xPhase: 20
}

waves[4] ={
    type: 'sine',
    name: 'wave 1',
    values: [],
    functCoef: 0.05,
    xCoef: 5,
    functPhase: 0,
    xPhase: 10
}

waves[5] ={
    type: 'sine',
    name: 'wave 1',
    values: [],
    functCoef: 2,
    xCoef: 0.05,
    functPhase: 0,
    xPhase: 0
}

waves[6] ={
    type: 'sine',
    name: 'wave 1',
    values: [],
    functCoef: 10,
    xCoef: 0.005,
    functPhase: 0,
    xPhase: 200
}

waves[7] ={
    type: 'sum',
    values: [],
    wavesToAdd: [0,1,2,3,4,5,6]
}

for(var wave = 0; wave < waves.length; wave++) {
    if(waves[wave].type == 'rand') { randWave(wave); }
    if(waves[wave].type == 'sine') { singleWave(wave); }
    if(waves[wave].type == 'sum') { sumWave(waves[wave].wavesToAdd, wave); console.log('Y tho')}
}

for(var wave = waves.length - 1; wave < waves.length; wave++) {
    for(var x = 0; x < canvas.clientWidth; x ++) {
        ctx.beginPath();
        ctx.lineWidth = 3;
        ctx.moveTo(x, (waves[wave].values[x] * 50 / 8.34747966653779 * 10) + 1000);
        ctx.lineTo(x + 1, (waves[wave].values[x + 1] * 50 / 8.34747966653779  * 10) + 1000)
        ctx.stroke();
        ctx.closePath();
    }
}

function x2Sine(x, yTop , amplitude) {
    return ((Math.sin(x) / (Math.PI * 2)) * amplitude * 2) + yTop; 
}

function sumWave(indeciesToAdd, sumIndex) {
    var max = 0;
    for(var i = 0; i < canvas.clientWidth; i++) {
        waves[sumIndex].values[i] = 0;

        for(var j = 0; j < waves[sumIndex].wavesToAdd.length; j++) {
            waves[sumIndex].values[i] += waves[j].values[i];
        }
        waves[sumIndex].values[i] /= 8.34747966653779;
        if(waves[sumIndex].values[i] < 0) {
            console.log(i + "   " + waves[sumIndex].values[i]);
        }
    }
    console.log(max)
}

function singleWave(index) {
    for(var i = 0; i < canvas.clientWidth; i++) {
        waves[index].values[i] = (waves[index].functCoef * (Math.sin((i / 20 * waves[index].xCoef) + waves[index].xPhase) / (Math.PI / 2))) + waves[index].functPhase;
    }
}

function randWave(index) {
    for(var i = 0; i < canvas.clientWidth; i+= waves[index].xCoef) {
        waves[index].values[i] = waves[index].functCoef * Math.random();
        for(var j = i + 1; j < i + waves[index].xCoef; j++) {
            waves[index].values[j] = waves[index].values[i];
        }
    }
}