#include <iostream>
#include <string>
#include <vector>
#include <iomanip>
#include <cstdio>

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

        int i = 0;
        while(i!=53){
            string nama;
            char jk;
            int usia;
            string usia_string;
            string kota;

            while(!(input[i]==' ' && input[i+1]==' ') && i!=25){
                nama.push_back(input[i]);
                i++;
            }

            jk = input[25];

            usia_string.push_back(input[26]);
            usia_string.push_back(input[27]);
            usia = stoi(usia_string);

            i = 28;
            while(input[i]!='\0'){
                kota.push_back(input[i]);
                i++;
            }

            if(jk=='P'){
                Female perempuan;
                perempuan.set(nama,jk,usia,kota);
                P.push_back(perempuan);
            }
            else if(jk=='L'){
                Male laki;
                laki.set(nama,jk,usia,kota);
                L.push_back(laki);
            }
            i = 53;
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