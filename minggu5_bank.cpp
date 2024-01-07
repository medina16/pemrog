#include <iostream>
#include <map>
using namespace std;

class TestCase{
    map<string,int> transaksi_akun;
    public:
    TestCase(){
        transaksi_akun.clear();
    }
    void add_transaksi(){
        int jlh_transaksi;
        string nomor_akun;
        scanf("%d ", &jlh_transaksi);
        for(int i=1;i<=jlh_transaksi;i++){
            getline(cin, nomor_akun);
            if(transaksi_akun.find(nomor_akun)!=transaksi_akun.end()){
                transaksi_akun[nomor_akun]++;
            }
            else{
                transaksi_akun.insert({nomor_akun,1});
            }
        }
    }
    void print_transaksi(){
        map<string,int>::iterator itr;
        for (itr=transaksi_akun.begin();itr!= transaksi_akun.end();itr++) { 
            cout << itr->first << " " << itr->second << endl;
        } 
    }
};

int main(){
    int jlh_testcase;
    cin >> jlh_testcase;
    for(int i=1;i<=jlh_testcase;i++){
        TestCase kasus;
        kasus.add_transaksi();
        kasus.print_transaksi();
        if(i!=jlh_testcase) cout << endl;
    }
    return 0;
}