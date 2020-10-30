#include <iostream>
using namespace std;
int main()
{
    int a[99],temp,count=0,n;
    cin >> n;
    for(int j = 0; j < n-1; j++)
        cin >> a[j];
    for(int k = 0; k < n-1 ; k++){
        for(int i = 0; i < n-k-1; i++){
            if(a[i] > a[i+1]){
                temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                count++;
            }
        }
    }
    cout << a[99]<<endl;
    return 0;
}