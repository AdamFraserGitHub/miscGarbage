var nIn = 0, nTotal = 0;

monteCarlo();

function monteCarlo() {
    
    while(true){
        nTotal++;
        var xAbs = Math.abs((Math.random() * 500) - 250);
        var yAbs = Math.abs((Math.random() * 500) - 250);
        if((xAbs*xAbs) + (yAbs*yAbs) <= 250*250) {
            nIn++;
        } 

        if(nTotal % 100000000 == 0) {
            console.log(((nIn / nTotal) * 500 * 500) / (250*250));
            console.log((nTotal / 1000000) + ' million points');
            console.log('\n');
        }
    }
}