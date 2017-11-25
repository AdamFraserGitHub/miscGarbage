var c = document.getElementById("Canvas")
var ctx = c.getContext("2d")

var listSize = 20;
var maxVal = 100;
var minVal = 0;

var list = []
for(var i = 0; i < listSize; i++) {
	list[i] = Math.floor(Math.random()*(maxVal-minVal+1)+minVal);
	ctx.fillRect((i/listSize) * 1300, 600 - ((list[i]/maxVal) * 600), (1/listSize) * 1300, (list[i]/maxVal) * 600);
}
var smallIndexVal, largerIndexVal;
var sorted = false;
var pointInChecking = true;
var nPasses = 0;
setTimeout(sortAndDisplay, 1000/10);

function sortAndDisplay() {
	
pointInChecking = true;
/*
one pass of the array sort algorithm which checks the 
next value. if it is greater they switch
*/
for(var i = 0; i < listSize - 1; i++) {
	alert("?")
	if(list[i] > list[i + 1]){
		smallIndexVal = list[i + 1];
		largerIndexVal = list[i];
		
		list[i] = smallIndexVal;
		list[i+1] = largerIndexVal;
	}
}

/*
check if the array is sorted by checking that every value of i > i
has value >= list[i]
*/
for(var i = 0; i < listSize - 1; i++) {
	if(list[i+1] >= list[i] && pointInChecking) {
		sorted = true;
	} else {
		sorted = false;
		pointInChecking = false;
	}
}
nPasses++;	
}

ctx.clearRect(0,0,1300,600);

for(var i = 0; i < listSize; i++) {
	ctx.fillRect((i/listSize) * 1300, 600 - ((list[i]/maxVal) * 600), (1/listSize) * 1300, (list[i]/maxVal) * 600);
}
