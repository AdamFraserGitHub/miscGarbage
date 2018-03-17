var numbers = [];

for (var i = 0; i < 100000; i++) {
  numbers[i] = i + 2; //+2 since 1 is not prime and 0 messes everything up
}

// var allNotFound = true;
var i = 0;
while(i < numbers.length) {
  if(isPrime(numbers[i], i)) {
    removeNums(numbers[i], i);
  }

  if(i % 500 == 0) {
    console.log(Math.round(i / numbers.length * 100) + '%');
  }
  i++;
}

function isPrime(number, index) {
  var isPrime = true;
  var i = 0;
  while(i < index && isPrime) {
    if(number % numbers[i] == 0) {
      isPrime = false;
    }
    i++;
  }
  return isPrime;
}

function removeNums(factor, index) {
  for(var i = index + 1; i < numbers.length; i++) {
    if(numbers[i] % factor == 0) {
      numbers.splice(i,1);
    }
  }
}

console.log('100%')
