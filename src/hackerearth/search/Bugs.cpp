#include <bits/stdc++.h>
#include <iostream>
using namespace std;
void insertEnemies(int a[], int n, int x) {
    for(int i=n; i>=x; i--)
        a[i] = a[i-1];
}
int main() {
    int n, x, y, i=0, count;
    cin >> count;
    int a[count];
    for(int k=0; k<count; k++) {
        cin >> n;
        switch(n) {
            case 1:
                cin >> x;
                if(i==0) {
                    a[i++] = x;
                }
                else {
                    int l=0;
                    int r=i-1;
                    if(a[l] >= x) {
                        insertEnemies(a, i, l+1); // for(int j=i-1; j>=l+1;j--) { a[j] = a[j-1]; }
                        i++;
                        a[l] = x;
                    }
                    else if(a[r] <= x) {
                        i++;
                        a[r+1] = x;
                    }
                    else {
                        while(l<=r) {
                            int mid = (l+r)/2;
                            if(a[mid] > x) {
                                if(a[mid-1] <= x) {
                                    insertEnemies(a, i, mid+1); // for(int j=i-1; j>=mid+1; j--) { a[j] = a[j-1]; }
                                    i++;
                                    a[mid] = x;
                                    break;
                                }
                                else {
                                    r = mid-1;
                                }
                            }
                            else if(a[mid] < x) {
                                if(mid+1!=i && a[mid+1] >= x) {
                                    insertEnemies(a, i+1, mid+2); // for(int j=i; j>=mid+2; j--) { a[j] = a[j-1]; }
                                    i++;
                                    a[mid+1] = x;
                                    break;
                                }
                                else {
                                    l = mid+1;
                                }
                            }
                            else {
                                insertEnemies(a, i+1, mid+2); // for(int j=i; j>=mid+2; j--) { a[j] = a[j-1]; }
                                i++;
                                a[mid+1] = x;
                                break;
                            }
                        }
                    }
                }
            break;
            case 2:
            if(i<3) {
                cout << "Not enough enemies\n";
            }
            else {
                y = i/3;
                cout << a[i-y] << "\n";
            }
            break;
        }
    }
}