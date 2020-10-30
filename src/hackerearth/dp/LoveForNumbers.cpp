#include<bits/stdc++.h>
using namespace std;
main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    //F and G arrays declared initially to find the answer
    //for each value from [2,10^6] and store it at that index
    int i,j;
    long long F[1000001]={0},G[1000001]={0};

    //Modified Sieve of Eratosthenes (modification done to build arrays F and G)
    for (i=2;i<1000001;i++){
        if (F[i]==0){
            for (j=i;j<1000001;j+=i){
                F[j]=i;
                if (G[j]==0)
                    G[j]=i;
            }
        }
    }

    //Prefix-sum technique applied on arrays F and G
    for (i=1;i<1000001;i++){
        F[i]=F[i]+F[i-1];       //Now F[i]=F[0]+F[1]+...+F[i-1]+F[i]
        G[i]=G[i]+G[i-1];       //Now G[i]=G[0]+G[1]+...+G[i-1]+G[i]
    }

    //Now we will answer queries
    int t,l,r;
    cin>>t;
    while (t--){
        cin>>l>>r;
        //Sum from F[l] to F[r]=F[r]-F[l-1]  (after applying prefix-sum)
        //Sum from G[l] to G[r]=G[r]-G[l-1]  (after applying prefix-sum)
        long long ans=(F[r]-F[l-1])-(G[r]-G[l-1]);
        cout<<ans<<'\n';
    }
}