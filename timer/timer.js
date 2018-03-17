var textOut = document.getElementById('timerTextOut');

var cs = 0;
var s = 0;
var m = 0;
var h = 0;

var interval = 1000; // ms
var expected = Date.now() + interval;
setTimeout(step, interval);
function step() {
    var dt = Date.now() - expected; // the drift (positive for overshooting)

    s++;
    if(s >= 60) {
      m++;
      s = 0;
      if(m >= 60) {
        h++;
        m = 0;
      }
    }

    textOut.innerHTML = h + ':' + m + ':' + s;

    expected += interval;
    setTimeout(step, Math.max(0, interval - dt)); // take into account drift
}
