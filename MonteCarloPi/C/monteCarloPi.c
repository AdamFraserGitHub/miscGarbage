#include <stdio.h>
#include <stdlib.h>

int main() {
    int squareLen = 10000;
    int squareArea = squareLen * squareLen;
    int radius = squareLen / 2;
    int radiusSqu = radius * radius;
    float x = 0, y = 0, xabs, yabs;
    unsigned int nInRad = 0, nTotal = 0;
    double pi;
    int numEndUnsignIntTot = 0, numEndUnsignIntRad = 0;

    while(1) {
        nTotal += 1;
        if(x < squareLen - 1) {
            x += 0.001;
        } else {
            x = 0;
            if(y < squareLen - 1) {
                y+= 0.001;
            } else {
                y = 0;
            }
        }
        // x = rand() % 500;
        // y = rand() % 500;
        
        xabs = abs(x - radius);
        yabs = abs(y - radius);

        if ((xabs*xabs) + (yabs*yabs) <= radiusSqu) {
            nInRad += 1;
        }

        if(nTotal % 100000000 == 0) {
            pi = ((double) (nInRad + numEndUnsignIntRad * 4000000000) / (double) (nTotal + numEndUnsignIntTot * 4200000000)) * squareArea / radiusSqu;
            printf("%lf\n", pi);
            printf("%d million monte carlo points\n\n", (nTotal / 1000000));
            
            if(nTotal >= 4200000000) {
                numEndUnsignIntTot += 1;
                nTotal = 0;
            };

            if(nInRad >= 4000000000) {
                numEndUnsignIntRad += 1;
                nInRad = 0;
            }
        }
    }
}