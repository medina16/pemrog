#include <bits/stdc++.h>
using namespace std;

int what(vector<int> Vektor, int n){
    int i;
    int m = Vektor[0];
    for(i=1;i<n;i++){
        if(Vektor[i]>m)
            m = Vektor[i];
    }
    return m;
}

int main(){
    int i, n, bilangan;

    cout << "Tentukan nilai n: ";
    cin >> n;

    cout << "Input sebanyak n bilangan: ";
    vector<int> Vektor;
    for(i=1;i<=n;i++){
        cin >> bilangan;
        Vektor.push_back(bilangan);
    }

    cout << "Hasilnya adalah : "
         << what(Vektor,n);

    return 0;
}