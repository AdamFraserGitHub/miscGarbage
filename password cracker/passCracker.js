var fs = require('fs');
var keyLength = 4;
var dicts = [];

dicts[0] = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
dicts[1] = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'];
dicts[2] = [0,1,2,3,4,5,6,7,8,9];

var keys = [];
keys[0] = 0;

var uppercaseDict = dicts[0].concat(dicts[2]);

    var charValues = [];

uppercaseKeys();
// testCase();

function uppercaseKeys() {
    var uppercaseDict = dicts[0].concat(dicts[2]);

    var charValues = [];
    for(var i = 0; i < keyLength; i++) { charValues[i] = 0; }
    // for(var i = 0; i < keyLength; i++) { charValues[i] = 0; }
    
    // for(var k = 0; k < 36; k++){
    //     baseCase(uppercaseDict, charValues);
    //     charValues[keyLength - 2]++;   
    //     charValues[keyLength - 1] = 0;
    // }

    if(keyLength > 1) {
        recursiveCase(uppercaseDict, charValues, keyLength);
    } else {
        baseCase(uppercaseDict, charValues);
    }

    console.log(keys[keys.length - 1]);

    if(keys.length % 1000000 != 0) {
        writeToFile();
    }
    
}

function lowercaseKeys() {
    
}

function recursiveCase(dictionary, charValues, level) {
    for(var i = 0; i < dictionary.length; i++) {
        if(level > 2) { recursiveCase(dictionary, charValues, level - 1); } 
        else {baseCase(dictionary, charValues, level)}
        charValues[keyLength - level]++;   
        for(var j = 1; j < keyLength; j++) {
            charValues[j] = 0;
        }
    }
}

function baseCase(dictionary, charValues) {
    var keyIndex;
    for(var i = 0; i < dictionary.length; i++) {
        keyIndex = keys.length;
        keys[keyIndex] = '';
        for(var j = keyLength; j > 0; j--) {
            keys[keyIndex] += dictionary[charValues[keyLength - j]];
        }
        charValues[keyLength - 1] ++;
        if(keys.length > 1000000) {
            console.log(keys.length);
            writeToFile();
        }
    }
} 

function writeToFile() {
    fs.appendFile('keys.txt', keys, function (err) {
        if(err) throw err;
            console.log('Changes saved');
        });
    keys = [];
}

function testCase() {
    for(var a = 0; a < 36; a++) {
        for(var b = 0; b < 36; b++) {
            for(var c = 0; c < 36; c++) {
                for(var d = 0; d < 36; d++) {
                    for(var e = 0; e < 36; e++) {
                        var keyIndex;
                        for(var i = 0; i < 36; i++) {
                            keyIndex = keys.length;
                            keys[keyIndex] = '';
                            for(var j = 6; j > 0; j--) {
                                keys[keyIndex] += uppercaseDict[charValues[6 - j]];
                            }
                            charValues[5] ++;
                            if(keys.length > 1000000) {
                                console.log(keys.length);
                                writeToFile();
                            }
                        }
                        charValues[4]++; 
                        for(var j = 5; j < 6; j++) {
                            charValues[j] = 0;
                        }
                    }
                    charValues[3]++; 
                    for(var j = 4; j < 6; j++) {
                        charValues[j] = 0;
                    }
                }
                charValues[2]++; 
                for(var j = 3; j < 6; j++) {
                    charValues[j] = 0;
                }
            }
            charValues[1]++; 
            for(var j = 2; j < 6; j++) {
                charValues[j] = 0;
            }
        }
        charValues[0]++; 
        for(var j = 1; j < 6; j++) {
            charValues[j] = 0;
        }
    }
}