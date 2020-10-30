void checkprime(int N) {
    int count = 0;
    for( int i = 1;i * i <=N;++i ) {
        if( N % i == 0) {
            if( i * i == N )
                count++;
            else       // i < sqrt(N) and (N / i) > sqrt(N)
                count += 2;
        }
    }
    if(count == 2)
        cout << N << “ is a prime number.” << endl;
    else
        cout << N << “ is not a prime number.” << endl;
}
//T:O(sqrt(n))
void sieve(int N) {
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
}
//N * (½ + ⅓ + ⅕ + … ) = O(NloglogN)
vector<int> factorize(int n) {
    vector<int> res;
    for (int i = 2; i * i <= n; ++i) {
        while (n % i == 0) {
            res.push_back(i);
            n /= i;
        }
    }
    if (n != 1) {
        res.push_back(n);
    }
    return res;
}
int minPrime[n + 1];
memset(minPrime,0,sizeof(minPrime)/sizeof(minPrime[0]));
for (int i = 2; i * i <= n; ++i) {
    if (minPrime[i] == 0) {         //If i is prime
        for (int j = i * i; j <= n; j += i) {
            if (minPrime[j] == 0) {
                minPrime[j] = i;
            }
        }
    }
}
for (int i = 2; i <= n; ++i) {
    if (minPrime[i] == 0) {
        minPrime[i] = i;
    }
}
vector<int> factorize(int n) {
    vector<int> res;
    while (n != 1) {
        res.push_back(minPrime[n]);
        n /= minPrime[n];
    }
    return res;
}

//Check number of primes between l and r
int numPrimes(long l,long r){
    bool isPrime[r - l + 1]; //filled by true
    memset(isPrime,true,sizeof(isPrime/isPrime[0]))
    for (long long i = 2; i * i <= r; ++i) {
        for (long long j = max(i * i, (l + (i - 1)) / i  * i); j <= r; j += i) {
            isPrime[j - l] = false;
        }
    }
    for (long long i = max(l, 2); i <= r; ++i) {
        if (isPrime[i - l]) {
            //then i is prime
        }
    }
}
bool isPrime(int n) {
    for (int i = 2; i * i <= n; ++i) {
        if (n % i == 0) {
            return false;
        }
    }
    return true;
}