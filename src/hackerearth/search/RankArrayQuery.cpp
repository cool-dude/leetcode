/*
// Sample code to perform I/O:*/
#include <bits/stdc++.h>
using namespace std;
#define ll long long int
#define ul unsigned long int
#define F(i,a,b) for(int i = (int)(a); i < (int)(b); i++)
#define RF(i,a,b) for(int i = (int)(a)-1; i >= (int)(b); i--)
#define MOD 1000000007
#define MAX 100000
#define ME 999
int binSearchRank(int a[MAX],int lo,int hi,int key){
	while(lo<=hi){
		int mi=lo+(hi-lo)/2;
		if(a[mi]==key) return mi+1;
		else if(a[mi]<key)
			lo=mi+1;
		else
			hi=mi-1;
	}
}
int main() {
	int a[MAX];
	memset(a,MAX,ME);
	int n;
	cin >> n;
	for(int i=0;i<n;i++)
		cin >> a[i];
	int q;cin >> q;
	sort(a,a+n);
	while(q--){
		int e;cin >> e;
		cout << binSearchRank(a,0,n-1,e) << endl;
	}
}