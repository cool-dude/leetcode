//prog for in-place matrix transpose
#include <cstdio>
#include <iostream>
#include <bitset>
#define HASH_SZ 128
using namespace std;
//a util fn to print 2D array of sz nrXnc and base adrs A
void print2DArr(int *a,int nr,int nc)
{
	for(int r=0;r<nr;r++){
		for(int c=0;c<nc;c++)
			cout << *(a+r*nc+c);
		cout << endl;
	}
	cout << "\n\n";
}

//non-square matrix multiplication
void matInplaceTrans(int* a,int r,int c)
{
	int sz=r*c-1;
	int t;		//holds loc to be replaced
	int nxt;	//loc of t to be moved
	int cycBegin;//holds start of cycle
	int i;		//iterator
	bitset<HASH_SZ> b;

	b.reset();
	b[0]=b[sz]=1;
	i=1;	
	//Note a[0] and a[sz-1] wont move

	while(i<sz){
		cycBegin=i;
		t=a[i];
		do{
			nxt=(i*r)%sz;
			swap(a[nxt],t);
			b[i]=1;
			i=nxt;
		}while(i!=cycleBegin);
		// get nxt move
		// (what abt querying 
		// random location
		for(i=1;i<sz&&b[i];i++)
			;
		cout << endl;
	}
}

#include <iostream>
#include <bitset>
#define HASH_SZ 128
using namespace std;

void matInplcXpose(int* a,int r,int c)
{
	int sz=r*c-1;
	bitset<HASH_SZ> b; 

	b.reset();
	int i=1;
	while(i<sz){
		int cycleBegin=i;
		int t=a[i];
		//i_new=(i*r)%sz
		do{
			int nxt=(i*r)%sz;
			swap(a[nxt],t);
			b[i]=true;
			i=nxt;
		}while(i!=cycleBegin);
		
		for(i=1;i<sz&&b[i];i++)
			;
		cout << endl;
	}
}

void prnMatrix(int *a,int r,int c)
{
	for(int i=0;i<r;++i){
		for(int j=0;j<c;++j)
			cout << *(a+i*c+j) << " ";
		cout << endl;	
	}
	cout << endl << endl;
}

void matInplaceTrans(int* A,int r,int c)
{
	int sz=r*c-1;
	int t,next,cycleBegin;
	bitset<HASH_SZ> b;
	
	b.reset();
	b[0]=b[sz]=1;
	int i=1;
	
	while(i<sz){
		cycBegin=i;
		t=a[i];
		do{
			next=(i*r)%sz;
			swap(a[next],t);
			b[i]=1;
			i=next;
		}while(i!=cycBegin);
		//get next move(querying random location)
		for(i=1;i<sz && b[i];i++)
			;
		cout << endl;
	}
}

void matrixInPlace(int m[][],int r,int c){
	int sz=r*c-1;
	int t;
	//elm to be replaced,eventually nxt 
	//elemt to move
	int nxt;//location of future table
	int cycleBegin;
	int i=1;
	bitset<HASH_SZ> b;
	
	b.reset();
	b[0]=b[sz]=1;
	while(i<sz){
		cycleBegin=i;
		t=a[i];	
		do{
			nxt=(i*r)%sz;
			swap(a[nxt],t);
			b[i]=1;
			i=nxt;
		}while(i!=cycleBegin);
		 // Get Next Move (what about querying random location?)
        for (i = 1; i < size && b[i]; i++)
            ;
	}
}