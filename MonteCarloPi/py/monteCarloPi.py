from random import randint

squareSideLen = 500
halfSquareSideLen = squareSideLen / 2
squareArea = squareSideLen**2

circleRadius = squareSideLen / 2;
radiusSquare = circleRadius**2

nInCircle = 0
nTotal = 0

for i in range(0,100000000):
    nTotal += 1
    x = randint(0,squareSideLen)
    y = randint(0,squareSideLen)

    if abs(x - halfSquareSideLen)**2 + abs(y - halfSquareSideLen)**2 <= radiusSquare:
        nInCircle += 1
        
    if nTotal % 500000 == 0:
        ratio = nInCircle / nTotal
        pi = (ratio * squareArea) / radiusSquare
        print(pi)
        print(nTotal / 1000000, ' million points thrown')
        print('')