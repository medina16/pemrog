import java.util.*;
class Koordinat{ // class tapi bukan yang utama jadi ga public
    int titikx, titiky;
    public Koordinat(int x, int y){
        titikx = x;
        titiky = y;
    }
    public int getX(){return titikx;}
    public int getY(){return titiky;}
}
public class Hotspots { // class utama
    ArrayList<Koordinat> titikapis;
    public int banyaktitik = 0;
    public Hotspots(){
        titikapis = new ArrayList<Koordinat>();
        titikapis.clear();
    }
    public boolean searchtitik(int x, int y){
        Iterator<Koordinat> itr = titikapis.iterator();
        while(itr.hasNext()){
            Koordinat titik = itr.next();
            if(titik.getX()==x && titik.getY()==y) return true; 
        }
        return false;
    }
    public void addtitik(int x, int y){
        Koordinat titik_koordinat = new Koordinat(x,y);
        if(!searchtitik(x,y)){
            banyaktitik++;
            if(y>0) titikapis.add(titik_koordinat);
        }
    }
    public void sorttitik(){
        Collections.sort(titikapis, new Comparator<Koordinat>() {
            public int compare(Koordinat koordinat1, Koordinat koordinat2) {
                if (koordinat1.getX() == koordinat2.getX()) {
                    return koordinat2.getY() - koordinat1.getY(); // y1 > y2
                } else {
                    return koordinat2.getX() - koordinat1.getX(); // x1 > x2
                }
            }
        });
    }
    public void showtitik(){
        sorttitik();
        System.out.printf("%d\n", banyaktitik);
        Iterator<Koordinat> itr = titikapis.iterator();
        while(itr.hasNext()){
            Koordinat titik = itr.next();
            System.out.print("(" + titik.getX() + "," + titik.getY() + ")"); 
        }
        System.out.print("\n");
    }
    public static void main(String[] args){
        Scanner masukan = new Scanner(System.in);
        Hotspots koordinatTitikApi = new Hotspots();

        int banyaktitik = masukan.nextInt();
        for(int i=0;i<banyaktitik;i++){
            int x = masukan.nextInt();
            int y = masukan.nextInt();
            koordinatTitikApi.addtitik(x,y);
        }

        koordinatTitikApi.showtitik();
    }
}
