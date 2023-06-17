import java.util.*;
import java.text.DecimalFormat;

interface Shape2D{
    void set();
    void print();
    double keliling();
}

public class Poligon implements Shape2D{
    int n;
    double[] koordinat_x;
    double[] koordinat_y;
    Scanner masukan = new Scanner(System.in);
    public void set(){
        n = masukan.nextInt();
        koordinat_x = new double[n];
        koordinat_y = new double[n];
        for(int i=0;i<n;i++){
            koordinat_x[i] = masukan.nextDouble();
            koordinat_y[i] = masukan.nextDouble();
        }
    }
    double jarakEuclidean(double a1, double a2, double b1, double b2){
        double selisih_a = a1 - a2;
        double selisih_b = b1 - b2;
        return Math.sqrt(selisih_a*selisih_a + selisih_b*selisih_b);
    }
    public double keliling(){
        double sisi = 0;
        for(int i=0;i<n;i++){
            double a1 = koordinat_x[i];
            double b1 = koordinat_y[i];

            int j;
            if(i==n-1) j = 0;
            else j = i + 1;

            double a2 = koordinat_x[j];
            double b2 = koordinat_y[j];

            sisi = sisi + jarakEuclidean(a1,a2,b1,b2);
        }
        return sisi;
    }
    public void print(){
        DecimalFormat dec = new DecimalFormat("#0.00");
        System.out.print("[");
        System.out.print(dec.format(koordinat_x[0]));
        System.out.print(",");
        System.out.print(dec.format(koordinat_y[0]));
        System.out.print("]-[");
        System.out.print(dec.format(koordinat_x[n-1]));
        System.out.print(",");

        System.out.print(dec.format(koordinat_y[n-1]));
        System.out.print("]");
        
    }
    public static void main(String[] args){
        DecimalFormat dec = new DecimalFormat("#0.00");
        Poligon objPoligon = new Poligon();
        objPoligon.set();
        objPoligon.print();
        System.out.println(dec.format(objPoligon.keliling()));
    }
}

