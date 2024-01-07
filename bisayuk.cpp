#include <bits/stdc++.h>
#include <iomanip>
using namespace std;

class Barang {

    public:
        string kode; // kode barang
        string nama; // nama barang
        int harga; // harga satuan barang (rupiah)
};

class DaftarKode {

    private:
        map<string,Barang> dt; // daftar kode barang
        int size; // ukuran daftar kode barang yang ada

    public:
        DaftarKode() { dt.clear(); size = 0; }
        void init(); // membaca daftar kode barang dari stdin
        string getNama(string kode); // mendapatkan nama barang dari kode
        int getHarga(string kode); // mendapatkan harga barang dari kode

};

void DaftarKode::init(){

    int banyak_kode;
    cin >> banyak_kode;
    cout << "Banyak kode: " << banyak_kode << endl;

    for(int i=1;i<banyak_kode;i++){
        string kode, nama;
        int hargasat;
        cin >> kode;
        cin >> nama;
        cin >> hargasat;

        Barang barang;
        barang.kode = kode;
        barang.nama = nama;
        barang.harga = hargasat;
        dt[kode] = barang;

        size = size + 1;
        cout << "Barang" << size << ": " << dt[kode].kode << "/" << dt[kode].nama << "/" << dt[kode].harga << endl;
    }

}

string DaftarKode::getNama(string kode){
    string Nama;
    Nama = dt.at(kode).nama;
    return Nama; 
}

int DaftarKode::getHarga(string kode){
    int Harga;
    Harga = dt.at(kode).harga;
    return Harga;
}

class Penjualan {
    private:
        DaftarKode daftar; // daftar kode barang yang ada
        map<string,int> st; // data penjualan
        int size; // ukuran data penjualan

    public:
        Penjualan() { daftar.init(); size=0;}
        void add(string kode, int jumlah){ // menambah data penjualan
            if(st.find(kode) == st.end()){
                st[kode] = jumlah;
            } else{
                st[kode] = st[kode] + jumlah;
            }
            size++;
            cout << "Penjualan " << size << ": " << kode << "/" << st[kode] << endl;
        }
        double totalbarang(string kode){
            string kode;
            double hargasat, hargatot;
            hargasat = (double)daftar.getHarga(kode);
            return (hargasat * st[kode])/1000000;
        }
};

int main(){

    Penjualan sale;
    int banyak_data, jumlah;

    cout << "Penjualan" << endl;
    cin >> banyak_data;
    cout << "Banyak data: " << banyak_data << endl;

    vector<double> urutan;
    string kode;
    for(int i=1;i<=banyak_data;i++){
        cin >> kode;
        cin >> jumlah;
        sale.add(kode, jumlah);
        urutan.push_back(sale.totalbarang(kode));
    }

    sort(urutan.begin(), urutan.end());
    for (auto x : urutan){
        
    }

    return 0;
}