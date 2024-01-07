#include <iostream>
#include <string>
#include <vector>
#include <iomanip>
using namespace std;

class Orang{
    protected:
        string nama;
        int usia;
    public:
        Orang(){
            nama = "";
            usia = 0;
        }
        void setData(string n, int u){
            nama = n;
            usia = u;
        }
};

class Mahasiswa : public Orang{
    protected:
        string nim;
    public:
        Mahasiswa(){
            nim = "";
        }
        void setData(string n, int u, string nomornim){
            nama = n;
            usia = u;
            nim = nomornim;
        }
};

class Nilai : public Mahasiswa{
    private:
        vector<string> kode_matkul;
        vector<int> sks;
        vector<char> hurufmutu;
        int totalsks;
        double totalhurufmutu;
        double convertHurufMutu(char huruf){
            if(huruf=='A')  return 4;
            else if(huruf=='B')  return 3;
            else if(huruf=='C')  return 2;
            else if(huruf=='D')  return 1;
            else if(huruf=='F')  return 0;
            else return -1;
        }

    public:
        Nilai(){
            kode_matkul.clear();
            sks.clear();
            hurufmutu.clear();
            totalsks = 0;
            totalhurufmutu = 0;
        }
        void addNilai(string matkul, int kredit, char huruf){
            kode_matkul.push_back(matkul);
            sks.push_back(kredit);
            hurufmutu.push_back(huruf);
            totalsks = totalsks + kredit;
            totalhurufmutu = totalhurufmutu + convertHurufMutu(huruf)*kredit;
        }
        void printNilai(){
            cout << nama << " ";
            cout << "(" << nim << "):";
            cout << totalsks << ":";
            cout << fixed << showpoint << setprecision(2) << totalhurufmutu/totalsks << endl;
        }
};

int main(){
    string nama, nim;
    int usia;
    string kode_matkul;
    int sks;
    char hurufmutu;

    Nilai nilai_mahasiswa;
    getline(cin,nama);
    cin >> usia;
    cin >> nim;
    nilai_mahasiswa.setData(nama,usia,nim);

    while(cin >> kode_matkul >> sks >> hurufmutu){
        nilai_mahasiswa.addNilai(kode_matkul,sks,hurufmutu);
    }
    
    nilai_mahasiswa.printNilai();

    return 0;
}

/*
NamDo-San
18
G64251234
KOM20C 3 A
KOM123 2 B
KOM098 3 B
KOM789 4 C
*/