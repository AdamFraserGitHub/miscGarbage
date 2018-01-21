var canvas = document.getElementById('displayCanvas');
var ctx = canvas.getContext('2d');

var waves = [];

waves[0] = {
    type: 'single',
    name: 'wave 0',
    values: [],
    functCoef: 1,
    xCoef: 0.1,
    functPhase: 0,
    xPhase: 0
};

waves[1] = {
    type: 'single',
    name: 'wave 0',
    values: [],
    functCoef: 0.75,
    xCoef: 0.25,
    functPhase: 0,
    xPhase: 50
};

waves[2] = {
    type: 'single',
    name: 'wave 0',
    values: [],
    functCoef: 0.25,
    xCoef: 1,
    functPhase: 0,
    xPhase: 0
};

waves[3] ={
    type: 'single',
    name: 'wave 1',
    values: [],
    functCoef: 0.25,
    xCoef: 1,
    functPhase: 0,
    xPhase: 20
}

waves[4] ={
    type: 'single',
    name: 'wave 1',
    values: [],
    functCoef: 0.05,
    xCoef: 5,
    functPhase: 0,
    xPhase: 10
}

waves[5] ={
    type: 'single',
    name: 'wave 1',
    values: [],
    functCoef: 2,
    xCoef: 0.05,
    functPhase: 0,
    xPhase: 50
}

waves[6] ={
    type: 'sum',
    name: 'combined 0',
    values: [],
    wavesToAdd: [0,1,2,3,4,5]
}

for(var wave = 0; wave < waves.length; wave++) {
    if(waves[wave].type == 'single') { singleWave(wave); }
    if(waves[wave].type == 'sum') { sumWave(waves[wave].wavesToAdd, wave); }
}

for(var wave = 0; wave < waves.length; wave++) {
    for(var x = 0; x < canvas.clientWidth; x ++) {
        ctx.beginPath();
        ctx.lineWidth = 1;
        ctx.moveTo(x, (waves[wave].values[x] * 50) + (wave + 1) * 100);
        ctx.lineTo(x + 1, (waves[wave].values[x + 1] * 50) + (wave + 1) * 100)
        ctx.stroke();
        ctx.closePath();
    }
}

function x2Sine(x, yTop , amplitude) {
    return ((Math.sin(x) / (Math.PI * 2)) * amplitude * 2) + yTop; 
}

function sumWave(indeciesToAdd, sumIndex) {
    for(var i = 0; i < canvas.clientWidth; i++) {
        waves[sumIndex].values[i] = 0;

        for(var j = 0; j < waves[sumIndex].wavesToAdd.length; j++) {
            waves[sumIndex].values[i] += waves[j].values[i];
        }
    }
}

function singleWave(index) {
    for(var i = 0; i < canvas.clientWidth; i++) {
        waves[index].values[i] = (waves[index].functCoef * (Math.sin((i / 20 * waves[index].xCoef) + waves[index].xPhase) / (Math.PI / 2))) + waves[index].functPhase;
    }
}