import java.util.Scanner;
public class Person {
    private String nama;
    private int usia;
    private int tinggi;
    private double berat;
    public Person(){
        nama = "";
        usia = tinggi = 0;
        berat = 0;
    }
    public void setPerson(String name, int age, int height, double weight){
        nama = name;
        usia = age;
        tinggi = height;
        berat = weight;
    }
    public String getNama() {return nama;}
    public int getUsia() {return usia;}
    public int getTinggi() {return tinggi;}
    public double getBerat() {return berat;}

    public static void main(String[] args){
        Scanner masukan = new Scanner(System.in);
        int n = masukan.nextInt();

        String name;
        int age, height;
        double weight;
        Person orang[] = new Person[n];
        for(int i=0;i<n;i++){
            //System.out.printf("i = %d\n", i);
            name = masukan.next();
            //System.out.printf("nama = %s", name);
            age = masukan.nextInt();
            //System.out.printf("usia = %d", age);
            height = masukan.nextInt();
            //System.out.printf("tinggi = %d", height);
            weight = masukan.nextDouble();
            //System.out.println(weight);
            orang[i] = new Person();
            orang[i].setPerson(name,age,height,weight);
        }

        double totaltinggi = 0;
        for(int i=0;i<n;i++){
            System.out.printf("%s %d\n", orang[i].getNama(), orang[i].getUsia());
            totaltinggi += orang[i].getTinggi();
        }
        double rata2tinggi = totaltinggi/(double)n;
        int tinggidiatasrata2 = 0;
        for(int i=0;i<n;i++){
            if(orang[i].getTinggi()>rata2tinggi) tinggidiatasrata2++;
        }
        System.out.printf("%.2f\n", rata2tinggi);
        System.out.println(tinggidiatasrata2);

    }
}
