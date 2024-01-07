#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Pegawai
{
    protected:
        string id;
        int usia, tipe;
        int income;
    public:
        void set(string pid, int u, int t ) {id=pid; usia=u; tipe=t; }
        string getID() { return id; }
        void print()
        { cout << id << " " << tipe << " " << income << endl; }
};

class Tetap: public Pegawai{
    public:
        Tetap(){
            id = "";
            usia = tipe = income = 0;
        }
        void setPokok(int nominal){
            income = nominal;
        }
        void setLembur(int nominal){
            income = income + nominal;
        }
};

class Harian: public Pegawai{
    public:
        Harian(){
            id = "";
            usia = tipe = income = 0;
        }
        void setUpah(int nominal){
            income = nominal;
        }
};

class All_Pegawai{
    vector<Tetap> T;
    vector<Harian> H;

    public:
        void add_tetap(Tetap pegawai){
            T.push_back(pegawai);
        }
        void add_harian(Harian pegawai){
            H.push_back(pegawai);
        }
        void add_upah_atau_uanglembur(string pid, int nominal){
            for (vector<Tetap>::iterator it = T.begin(); it!=T.end(); it++) {
                if((*it).getID()==pid) (*it).setLembur(nominal);
            }
            for (vector<Harian>::iterator it = H.begin(); it!=H.end(); it++) {
                if((*it).getID()==pid) (*it).setUpah(nominal);
            }
        }
        void print_tetap(){
            for (vector<Tetap>::iterator it = T.begin(); it!=T.end(); it++) {
                (*it).print();
            }
        }
        void print_harian(){
            for (vector<Harian>::iterator it = H.begin(); it!=H.end(); it++) {
                (*it).print();
            }
        }
};

int main(){
    int N;
    string pid;
    int u, t, nominal;
    All_Pegawai daftar_pegawai;

    cin >> N;

    for(int i=0;i<N;i++){
        cin >> pid >> u >> t;
        if(t==1){
            cin >> nominal;
            Tetap pegawai_tetap;
            pegawai_tetap.set(pid,u,t);
            pegawai_tetap.setPokok(nominal);
            daftar_pegawai.add_tetap(pegawai_tetap);
        }
        else if(t==2){
            Harian pegawai_harian;
            pegawai_harian.set(pid,u,t);
            daftar_pegawai.add_harian(pegawai_harian);
        }
    }

    cin >> pid;
    while(pid!="END"){
        cin >> nominal;
        daftar_pegawai.add_upah_atau_uanglembur(pid,nominal);
        cin >> pid;
    }

    daftar_pegawai.print_tetap();
    daftar_pegawai.print_harian();

    return 0;
}