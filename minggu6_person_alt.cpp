#include <iostream>
#include <bits/stdc++.h>
#include <string>
#include <vector>
#include <iomanip>

using namespace std;

class Person {
    protected:
        string nama; // nama
        char jk; // jenis kelamin
        int usia; // usia (tahun)
        string kota; // kota lahir
    public:
        void set(string n, char j, int u, string k) { 
            nama = n;
            jk = j;
            usia = u;
            kota = k;
        }
        string getNama(){
            return nama;
        }
        char getSex(){
            return jk;
        }
        int getUsia(){
            return usia;
        }
        string getKota(){
            return kota;
        }

};

class Male:public Person{
    public:
        Male(){
            nama = "";
            jk = 'L';
            usia = 0;
            kota = "";
        }
};

class Female:public Person{
    public:
        Female(){
            nama = "";
            jk = 'P';
            usia = 0;
            kota = "";
        }
};

template <class T>
double rataan(vector<T> p){
    double sum = 0;
    for(int i=0;i<(int)p.size();i++){
        sum = sum + p[i].getUsia();
    }
    return sum/(double)p.size();
}

template <class T>
int jumlahdibawah(vector<T> p){
    int banyak = 0;
    for(int i=0;i<(int)p.size();i++){
        if(p[i].getUsia()<rataan(p)) banyak++;
    }
    return banyak;
}

int main(){
    vector<Male> L;
    vector<Female> P;
    string input;

    while (getline(cin,input)) {
        string nama;
        char jk;
        int usia;
        string usia_string;
        string kota;

        nama = input.substr(0,24);
        jk = input[25];
        usia_string = input.substr(26,2);
        usia = stoi(usia_string);
        kota = &input[28];

        if(jk=='L'){
            Male laki;
            laki.set(nama,jk,usia,kota);
        }
        if(jk=='P'){
            Female perempuan;
            perempuan.set(nama,jk,usia,kota);
            P.push_back(perempuan);
        }
    }

    cout << "L ";
    cout << L.size() << " ";
    cout << fixed << showpoint;
    cout << setprecision(2) << rataan(L) << " ";
    cout << jumlahdibawah(L) << endl;

    cout << "P ";
    cout << P.size() << " ";
    cout << fixed << showpoint;
    cout << setprecision(2) << rataan(P) << " ";
    cout << jumlahdibawah(P) << endl;

    return 0;
}

//Medina Fitri Maulida    P20Jakarta Timur