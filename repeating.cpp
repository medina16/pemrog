#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

class Person {
    string nama;
    int usia;
    int tinggi;
    double berat;

    public:
        Person(){
            nama = "";
            usia = 0;
            tinggi = 0;
            berat = 0;
        }
        void setPerson(string nm, int u, int t, double b){
            nama = nm;
            usia = u;
            tinggi = t;
            berat = b;
        }
        string getNama() {return nama;}
        int getUsia() {return usia;}
        int getTinggi() {return tinggi;}
        double getBerat() {return berat;}
        double getIMT() {
            double imt;
            double x = (double)tinggi/100;
            imt = berat/(x*x);
            return imt;
        }
        int getStatusGizi(double imt){
            if(imt<17.0) return 1;
            else if(imt>=17.0 && imt<18.5) return 2;
            else if(imt>=18.5 && imt<25.0) return 3;
            else if(imt>=25.0 && imt<28.0) return 4;
            else return 5;
        }
};

int main(){
    int n, i;
    cin >> n;

    Person orang[n];
    string nm;
    int u, t;
    double b, totaltinggi = 0;

    for(i=0;i<n;i++){
        cin >> nm >> u >> t >> b;
        orang[i].setPerson(nm,u,t,b);
        totaltinggi = totaltinggi + (double)t;
    }

    double rata2tinggi = totaltinggi/n;
    int atasrata2 = 0;
    int saku = 0, ku = 0, no = 0, ge = 0, sage = 0;

    for(i=0;i<n;i++){
        nm = orang[i].getNama();
        u = orang[i].getUsia();
        t = orang[i].getTinggi();
        b = orang[i].getBerat();

        cout << nm << " ";
        cout << u << " ";
        cout << t << " ";

        if((double)t>rata2tinggi) atasrata2++;

        cout << fixed << showpoint;
        cout << setprecision(2) << b << " ";

        double imt = orang[i].getIMT();
        cout << fixed << showpoint;
        cout << setprecision(2) << imt << " ";

        int status = orang[i].getStatusGizi(imt);
        if(status==1) {cout << "sangat kurus" << endl; saku++;}
        if(status==2) {cout << "kurus" << endl; ku++;}
        if(status==3) {cout << "normal" << endl; no++;}
        if(status==4) {cout << "gemuk" << endl; ge++;}
        if(status==5) {cout << "sangat gemuk" << endl; sage++;}
    }

    cout << setprecision(2) << rata2tinggi << endl;
    cout << atasrata2 << endl;
    cout << saku << " " << ku << " " << no << " " << ge << " " << sage << endl;
}
