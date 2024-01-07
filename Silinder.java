import java.util.*;

interface iLingkaran{
    void setDiameter(int diameter_set);
    double luasLingkaran();
}

interface iSegiEmpat{
    void setSisi(int lebar_set, int tinggi_set);
    double luasSegiEmpat();
}

interface iSilinder extends iLingkaran, iSegiEmpat{
    double volumeSilinder();
}

public class Silinder implements iSilinder{
    private int diameter, lebar, tinggi;
    public void setDiameter(int diameter_set){
        diameter = diameter_set;
    }
    public void setSisi(int lebar_set, int tinggi_set){
        lebar = lebar_set; tinggi = tinggi_set;
    }
    public double luasLingkaran(){
        return Math.PI * diameter * diameter * 0.25;
    }
    public double luasSegiEmpat(){
        return lebar * tinggi;
    }
    public double volumeSilinder(){
        return luasLingkaran() * tinggi;
    }
    public static void main(String[] args){
        
        ArrayList<Silinder> list_silinder = new ArrayList<Silinder>();
        Scanner masukan = new Scanner(System.in);

        int diameter, lebar, tinggi;
        double totalVolume = 0;
        
        int N = masukan.nextInt();
        for(int i=0;i<N;i++){
            diameter = masukan.nextInt();
            lebar = masukan.nextInt();
            tinggi = masukan.nextInt();

            Silinder silinder_baru = new Silinder();
            silinder_baru.setDiameter(diameter);
            silinder_baru.setSisi(lebar, tinggi);
            list_silinder.add(silinder_baru);

            totalVolume += silinder_baru.volumeSilinder();
        }

        double rataVolume = totalVolume/N;
        int diatasrata2 = 0;
        Iterator<Silinder> itr = list_silinder.iterator();
        while(itr.hasNext()){
            Silinder silinder_cek = itr.next();
            if(silinder_cek.volumeSilinder()>rataVolume) diatasrata2++;
        }

        System.out.printf("%.2f %d\n", rataVolume, diatasrata2);

    }
}
