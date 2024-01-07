#include <iostream>
#include <string>
using namespace std;

class BilanganPecahan{

    int a, b, c;

    void sederhana(){
        int gcd = fpb(b,c);
        a = a + b/c;
        b = (b % c) / gcd;
        c = c / gcd;
    }
    
    int fpb(int bil1,int bil2){
        int sisa = 1;
        int pembagi, dibagi;

        if(bil1>bil2){
            pembagi = bil2; dibagi = bil1;
        }
        else {
            pembagi = bil1; dibagi = bil2;
        }

        while(sisa!= 0){
            sisa = dibagi%pembagi;
            dibagi = pembagi;
            pembagi = sisa;
        }

        return dibagi;
    }
    
    public:

    BilanganPecahan(){
        a = 0, b = 0, c = 1;
    }

    void setbil(int asli, int pembilang, int penyebut){
        a = asli, b = pembilang, c = penyebut;
        sederhana();
    }

    BilanganPecahan operator+(BilanganPecahan const &p){
        BilanganPecahan hasiltambah;
        hasiltambah.a = this->a + p.a;
        hasiltambah.b = (this->b * p.c) + (p.b * this->c);
        hasiltambah.c = this->c * p.c;
        hasiltambah.sederhana();
        return hasiltambah;
    }

    BilanganPecahan operator* (BilanganPecahan const &p){
        BilanganPecahan hasilkali;
        int bil1_pembilang, bil2_pembilang, penyebut;
        bil1_pembilang = this->c * this->a + this->b;
        bil2_pembilang = p.c * p.a + p.b;
        penyebut = this->c * p.c;
        hasilkali.a = bil1_pembilang*bil2_pembilang / penyebut;
        hasilkali.b = bil1_pembilang*bil2_pembilang % penyebut;
        hasilkali.c = penyebut;
        hasilkali.sederhana();
        return hasilkali;
    }

    BilanganPecahan operator++(int) {
        this->a++;
        return *this;
    }

    BilanganPecahan operator--(int) {
        this->a--;
        return *this;
    } 
    
    void printbil(){
        cout << a;
        if(b>0) cout << " " << b << "/" << c;
        cout << endl;
    }
};

int main(){
    int a, b, c;
    BilanganPecahan pecahan;
    string operasi;

    while(operasi!="end"){
        cin >> operasi;
       if(operasi=="set"){
            cin >> a >> b >> c;
            pecahan.setbil(a,b,c);
       }
       else if(operasi=="p"){
            pecahan.printbil();
       }
       else if(operasi=="add"){
            cin >> a >> b >> c;
            BilanganPecahan penambah;
            penambah.setbil(a,b,c);
            pecahan = pecahan + penambah;
       }
       else if(operasi=="mul"){
           cin >> a >> b >> c;
            BilanganPecahan pengali;
            pengali.setbil(a,b,c);
            pecahan = pecahan * pengali;
       }
       else if(operasi=="inc"){
            pecahan++;
       }
       else if(operasi=="dec"){
            pecahan--;
       }
    
    }

    return 0;
}