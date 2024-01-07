#include <iostream>
#include <cmath>
#include <vector>
#include <algorithm>
#include <iomanip>
using namespace std;

class Ruang2D{
    protected:
        double sisi1, sisi2, sisi3, sisi4;
    public:
        Ruang2D(){
            sisi1 = sisi2 = sisi3 = sisi4 = 0;
        }
        virtual double luas() = 0;
        virtual double keliling() = 0;
        void set(double s1=0, double s2=0, double s3=0, double s4=0){
            sisi1 = s1;
            sisi2 = s2;
            sisi3 = s3;
            sisi4 = s4;
        }
};

class Segiempat : public Ruang2D{
    public:
        void set(double panjang, double lebar){
            sisi1 = sisi3 = panjang;
            sisi2 = sisi4 = lebar;
        }
        double luas(){
            return sisi1 * sisi2;
        }
        double keliling(){
            return sisi1 + sisi2 +sisi3 + sisi4;
        }
};

class Segitiga : public Ruang2D{
    public:
        void set(double alas, double tinggi){
            sisi1 = alas;
            sisi2 = tinggi;
            sisi3 = sqrt(alas*alas + tinggi*tinggi);
        }
        double luas(){
            return sisi1*sisi2/2;
        }
        double keliling(){
            return sisi1 + sisi2 + sisi3;
        }
};

class Koleksi{
    private:
        vector<Segiempat> S4;
        vector<Segitiga> S3;
        template<typename T>
        static bool sort_descending(T &a,  T &b){
            return ((a.luas() > b.luas())||(a.keliling() > b.keliling()) && (a.luas() == b.luas()));
        }
    public:
        Koleksi(){
            S4.clear();
            S3.clear();
        }
        void addSegiempat(double panjang, double lebar){
            Segiempat segiempat_obj;
            segiempat_obj.set(panjang,lebar);
            S4.push_back(segiempat_obj);
        }
        void addSegitiga(double alas, double tinggi){
            Segitiga segitiga_obj;
            segitiga_obj.set(alas,tinggi);
            S3.push_back(segitiga_obj);
        }
        void sortSegiempat(){
            sort(S4.begin(),S4.end(),sort_descending<Segiempat>);
        }
        void sortSegitiga(){
            sort(S3.begin(),S3.end(),sort_descending<Segitiga>);
        }
        void printAll(){
            cout << "SEGIEMPAT\n";
            cout << fixed << showpoint;
            for(int i=0;i!=(int)S4.size();i++){
                cout << setprecision(1) <<  S4[i].luas() << " ";
                cout << setprecision(1) << S4[i].keliling() << endl;
            }
            cout << "SEGITIGA\n";
            for(int i=0;i!=(int)S3.size();i++){
                cout << setprecision(1) << S3[i].luas() << " ";
                cout << setprecision(1) << S3[i].keliling() << endl;
            }
        }
};

int main(){
    int m, n;
    cin >> m >> n;

    Koleksi koleksi_obj;
    for(int i=0;i<m;i++){
        int panjang, lebar;
        cin >> panjang >> lebar;
        koleksi_obj.addSegiempat(panjang,lebar);
    }
    koleksi_obj.sortSegiempat();
    for(int i=0;i<n;i++){
        int alas, tinggi;
        cin >> alas >> tinggi;
        koleksi_obj.addSegitiga(alas,tinggi);
    }
    koleksi_obj.sortSegitiga();

    koleksi_obj.printAll();

    return 0;
}