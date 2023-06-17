import java.util.*;
import java.text.DecimalFormat;

interface Pecahan{
    abstract public void jumlah();
    abstract public void print();
}

class Desimal implements Pecahan{
    double a, b, hasiljumlah;
    public Desimal(double set_a, double set_b){
        a = set_a;
        b = set_b;
    }
    public void jumlah(){
        hasiljumlah = a+b;
    }
    public void print(){
        DecimalFormat dec = new DecimalFormat("#0.00");
        System.out.println(dec.format(hasiljumlah));
    }
}

class Rasional implements Pecahan{
    int p, q, r, s, hasiljumlah_pembilang, hasiljumlah_penyebut;
    private int fpb(int m, int n){
        while(n!=0){
            int t = m%n;
            m = n;
            n = t;
        }
        return m;
    }
    public Rasional(int set_p, int set_q, int set_r, int set_s){
        p = set_p;
        q = set_q;
        r = set_r;
        s = set_s;
    }
    public void jumlah(){
        hasiljumlah_pembilang = p*s + q*r;
        hasiljumlah_penyebut = q*s;

        int hasilfpb = fpb(hasiljumlah_pembilang,hasiljumlah_penyebut);
        hasiljumlah_pembilang = hasiljumlah_pembilang/hasilfpb;
        hasiljumlah_penyebut = hasiljumlah_penyebut/hasilfpb;
    }
    public void print(){
        System.out.printf("%d %d\n", hasiljumlah_pembilang, hasiljumlah_penyebut);
    }
}

public class PolymorphismI {
    public static void main(String[] args){
        Scanner masukan = new Scanner(System.in);
        int jumlah_baris = masukan.nextInt();
        ArrayList<Pecahan> daftarBilanganPecahan = new ArrayList<Pecahan>();

        int jenis = 0;
        for(int i=0;i<jumlah_baris;i++){
            jenis = masukan.nextInt();
            if(jenis==1){
                double a = masukan.nextDouble();
                double b = masukan.nextDouble();
                Pecahan objPecahan = new Desimal(a,b);
                objPecahan.jumlah();
                daftarBilanganPecahan.add(objPecahan);
            }
            else if(jenis==2){
                int p = masukan.nextInt();
                int q = masukan.nextInt();
                int r = masukan.nextInt();
                int s = masukan.nextInt();
                Pecahan objPecahan = new Rasional(p,q,r,s);
                objPecahan.jumlah();
                daftarBilanganPecahan.add(objPecahan);
            }
        }

        int i = masukan.nextInt()-1;
        int j = masukan.nextInt()-1;
        for(int x=i;x<=j;x++){
            daftarBilanganPecahan.get(x).print();
        }
        masukan.close();
    }
}
