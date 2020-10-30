SLN:1
#include <bits/stdc++.h>
using namespace std;
typedef long long int ll;
map<ll,ll > c;
#define MOD 1000000007
ll swap(ll n){
	if(n==0)
		return 0;
	if(c[n]==0){
		int k=swap(n/2)+swap(n/3)+swap(n/4);
		c[n]=k>n?k:n;
	}
	return c[n];
}
int main()
{
	ll n;
	while(scanf("%lld",&n)==1){
		cout<<swap(n)<<endl;
	}
	return 0;
}

SLN2:
#include <bits/stdc++.h>
using namespace std;
typedef unsigned long long int ull;
unordered_map<ull,ull> f;
ull convert(ull n)
{
	if(n==0)return 0;
	if(f[n])return f[n];
	return f[n]=max(n,convert(n/2)+convert(n/3)+convert(n/4));
}
int main()
{
	ull n;
	while(cin>>n)
		cout<<convert(n)<<endl;
	return 0;
}