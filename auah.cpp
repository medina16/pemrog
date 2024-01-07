#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Spot{ // objek berupa titik yang punya koordinat sumbu x & koordinat sumbu y
    int x, y;
    public:
    Spot(int x=0, int y=0){
        this->x = x; this->y = y;
    }
    bool isValid(){ // ngecek apakah titik yg dimasukin letaknya di atas sumbu y atau ngga
        if(y>0) 
            return true;
        return false;
    }
    bool operator>(Spot const &spot2){ // ngedefinisiin ">" kalo ngebandingin antara satu objek Spot sama objek Spot lainnya
        if((this->x > spot2.x) || (this->x == spot2.x) && (this->y >spot2.y))
            return true;
        return false;
    }
    bool operator==(Spot const &spot2){ // kayak yang atas tapi khusus "="
        if((this->x==spot2.x) && (this->y==spot2.y))
            return true;
        return false;
    }
    void print(){
        cout << "(" << x << "," << y << ")";
    }
};

bool comp(Spot a, Spot b){ // komparator buat ngebandingin objek Spot a sama b sesuai ">" yg udh didefinisiin
    return (a>b);
}

class Spots{ // bikin satu vektor yang isinya sejumlah titik kebakaran
    int total; // total titik dalem vektor
    vector<Spot> titikkebakaran; // vektor yg isinya titik2 kebakaran
    void sortTitik(){ // ngurutin Spot2 dalm vektor dari yang paling kanan atas
        sort(titikkebakaran.begin(),titikkebakaran.end(),comp);
    }
    public:
    Spots(){
        titikkebakaran.clear();
        total = 0;
    }
    void addSpots(int x, int y){
        Spot newtitik(x,y);
        if(find(titikkebakaran.begin(),titikkebakaran.end(),newtitik) == titikkebakaran.end()){ // bikin titik baru cuma kalo titiknya belom ada di vektor
            total++;
            if(newtitik.isValid()){ // cuma bisa masukin titik baru kalo koordinat y titiknya positif
                titikkebakaran.push_back(newtitik);
                sortTitik();
            }
        }
    }
    void print(){
        vector<Spot>::iterator it;
        cout << total << endl;
        for(it=titikkebakaran.begin();it!=titikkebakaran.end();it++){
            (*it).print(); //ngejalanin function print dari objek Spot yang ada di index vektornya
        }
        cout << endl;
    }
};

int main(){
    int n;
    Spots titik;
    cin >> n;
    for(int i=0;i<n;i++){
        int x, y;
        cin >> x >> y;
        titik.addSpots(x,y);
    }
    titik.print();
    return 0;
}