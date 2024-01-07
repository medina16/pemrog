#include <iostream>
#include <set>
#include <utility>
using namespace std;

struct cmp{
    bool operator()(pair<int,int> A, pair<int,int> B)const {
        return (A.first > B.first || (A.first==B.first && A.second > B.second));
    }
};

class HotSpot{
    set<pair<int,int>, cmp> titik;
    public:
        HotSpot(){
            titik.clear();
        }
        void tambahtitik(int x, int y){
            pair<int,int> titikbaru;
            titikbaru.first = x;
            titikbaru.second = y;
            titik.insert(titikbaru);
        }
        void printtitik(){
            cout << titik.size() << endl;
            for(set<pair<int,int>>::iterator it=titik.begin();it!=titik.end();it++){
                cout << "(" << it->first << "," << it->second << ")";
            }
            cout << endl;
        }
};

int main(){
    HotSpot titikapi;
    int banyakinput;
    int x, y;

    cin >> banyakinput;
    for(int i=0;i<banyakinput;i++){
        cin >> x >> y;
        titikapi.tambahtitik(x,y);
    }

    titikapi.printtitik();

    return 0;
}