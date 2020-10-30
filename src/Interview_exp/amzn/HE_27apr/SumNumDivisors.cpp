#include<iostream>
using namespace std;
int numDiv(int n){
    int res=1;
    for(int i=2;i<=sqrt(n);i++){
        if(n%i==0){
            if(i==(n/i))
                res+=1;
             else
                res+=2;
        }
    }
    return res+1;
}
int minGood(int k){
    if(k==1) return 1;
    int sum=1;
    for(int i=2;i<=k;i++){
        sum+=numDiv(i);
        if(sum>=k) return i;
    }
    return k;
}
int main(){
    int t;
    cin >> t;
    for(int i=0;i<t;i++){
        int k;
        cin >> k;
        cout << minGood(k) << endl;
    }
}