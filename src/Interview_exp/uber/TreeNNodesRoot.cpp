/*Tree N nodes rooted at 1. The tree given by array of size (n-1)
p[i]=parent of i+1-th node
 val size n
 number of nodes co-prime*/
class Solution{
#define MAXV 1000
    private:
    vector<vector<pair<int,int>>>core_divisors;
    vector<int> A;
    public:
    long coprimeSum(int n,vector<int> p,vector<int> val){
        if(n<=1)  return 0;

        vector<int> mu(MAXV+1,1);
        for(int i=2;i<=MAXV;i++)
            for(int d=2;d<=i;d++)
                if(i%d==0){
                    if(i%(d*d)==0)  mu[i]=0;
                    else            mu[i]=-mu[i/d];
                    break;
                }

        A=vector<int>(MAXV+1,0);
        core_divisors=vector<vector<pair<int,int>>>(MAXV+1);
        for(int i=1;i<=MAXV;i++)
            for(int d=1;d<=i;d++)
                if(i%d==0 && mu[d]!=0)
                    core_divisors[i].push_back({d,mu[d]});

        vector<vector<int>> graph(n+1);
        for(int i=0;i<n-1;i++)
            graph[p[i]-1].push_back(i+1);

        long ans=0;
        dfs(0,graph,val,ans);
        return ans;
    }

    void dfs(int x,vector<vector<int>>& graph,vector<int>& val,long& ans){

        int v=val[x];
        for(auto a:core_divisors[v]){
            ans+=a.second * A[a.first];
            A[a.first]++;
        }

        for(int y:graph[x])
            dfs(y,graph,val,ans);

        for(auto a:core_divisors[v])
            A[a.first]--;
    }
};

int main(void){

        Solution *s=new Solution;
        cout<<s->coprimeSum(5,{1,1,3,3},{1,2,3,4,5})<<endl;

        return 0;
        }
// output 6