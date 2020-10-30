#include <bits/stdc++.h>
using namespace std;
char s[100], es[100];
int len, joinIndex[100];
stack<int> joinList;
void expand(int i, int j, int *endIndex = NULL){
	cout << i << " " << j << endl;
	if(i == len){
		es[j] = 0;
		//an solution is built
		printf("%s\n", es);
		return;
	}
	if(s[i] == '{'){
		//we are going to fork several path
		joinList.push(joinIndex[i]);
		int tepos = i;
		while(s[tepos] != '}'){
			cout << "fork: " << tepos+1 << endl;
			expand(tepos+1, j, &tepos);
		}
		joinList.pop();
	}
	else if(s[i] == ',' || s[i] == '}'){
		//we are at join position
		int joinLocation = joinList.top();
		joinList.pop();
		cout << "join: " << joinLocation+1 << endl;
		expand(joinLocation+1, j);
		joinList.push(joinLocation);
		if(endIndex){
			*endIndex = i;
		}
	}
	else {
		es[j] = s[i];
		expand(i+1, j+1, endIndex);
	}
}
int main() {
	stack<int> ts;
	scanf("%s", s);
	len = strlen(s);
	for(int i=len-1; i>=0; i--){
		if(s[i] == '}'){
			ts.push(i);
		} else if(s[i] == '{'){
			joinIndex[i] = ts.top();
			ts.pop();
		}
	}
	expand(0, 0);
	return 0;
}