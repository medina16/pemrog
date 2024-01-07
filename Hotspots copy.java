import java.util.*;
class Koordinat{
    int titikx, titiky;
    public Koordinat(){
        titikx = titiky = 0;
    }
}
public class Hotspots {
    TreeMap<Integer,Integer> titikapis;
    public Hotspots(){
        titikapis = new TreeMap<Integer,Integer>();
    }
    public void addtitik(int x, int y){
        if(y>=0)titikapis.put(x,y);
        //showtitik();
    }
    public void showtitik(){
        List<Map.Entry<Integer, Integer>> listtitik = new ArrayListRepeating<>(titikapis.entrySet());
        Collections.sort(listtitik, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> koordinat1, Map.Entry<Integer, Integer> koordinat2) {
                if (koordinat1.getKey() == koordinat2.getKey()) {
                    return koordinat2.getValue() - koordinat1.getValue(); // y1 > y2
                } else {
                    return koordinat2.getKey() - koordinat1.getKey(); // x1 > x2
                }
            }
        });

        for(Map.Entry<Integer, Integer> entry : listtitik) { 
            System.out.print("(" + entry.getKey() + "," + entry.getValue() + ")"); 
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
