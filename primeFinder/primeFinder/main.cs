using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace primeFinder
{
    class main {

        static void Main(string[] args) {
            long nPrimes;

            Console.WriteLine("this is a simple program to find a given number of primes.\nplease enter the number of primes you would like to find.");

            nPrimes = Convert.ToInt64(Console.ReadLine());
            findPrimes primes = new findPrimes();

            primes.run(nPrimes);
        }
    }

    class findPrimes {
        public void run(long nPrimes) {
            int primesFound = 0;
            int numToCheck = 3;
            bool prime = true;

            while (primesFound != nPrimes) {
                for (int i = 2; i < numToCheck; i++) {

                    if (numToCheck % i == 0) {
                        prime = false;
                    }
                }
                if (prime) {
                    primesFound++;
                    Console.WriteLine("{0}\t{1}\t{2}%",numToCheck, primesFound, (float)primesFound / (float)nPrimes * 100f);
                }
                prime = true;
                numToCheck++;
            }

            Console.ReadLine();
        }
    }
}
