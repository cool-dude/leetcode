int f[100055],qs[100055];
class Solution {
public:
    int constrainedSubsetSum(vector<int>& g, int k) {
        int n=g.size(),ans=-2e9,h=0,t=0;
        for(int i=0;i<n;++i){
            while(h!=t&&qs[h]<i-k) ++h;
            int w=(h==t)?0:f[qs[h]];
            w=max(w,0); w+=g[i];
            f[i]=w;
            while(h!=t&&f[qs[t-1]]<f[i]) --t;
            qs[t++]=i;
            ans=max(ans,w);
        }
        return ans;
    }
};