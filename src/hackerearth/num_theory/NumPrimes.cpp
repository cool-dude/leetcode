/*Sample code to perform I/O:*/
#include <iostream>
using namespace std;
int sievePrimeCount(int N) {
    bool isPrime[N+1];
    for(int i = 0; i <= N;++i) {
        isPrime[i] = true;
    }
    isPrime[0] = false;
    isPrime[1] = false;
    for(int i = 2; i * i <= N; ++i) {
         if(isPrime[i] == true) {                    //Mark all the multiples of i as composite numbers
             for(int j = i * i; j <= N ;j += i)
                 isPrime[j] = false;
        }
    }
	int count=0;
	for(int i=1;i<=N;i++)
		if(isPrime[i])
			count++;
	return count;
}
int main() {
	int num;
	cin >> num;										// Reading input from STDIN
	cout << sievePrimeCount(num) << endl;		// Writing output to STDOUT
}