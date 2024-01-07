import java.util.*;

class Person{
    private String nama;
    private int usia;
    private int tinggi;
    private double berat;
    Person(){
        nama = ""; usia = tinggi = 0; berat = 0;
    }
    void setPerson(String setNama, int setUsia, int setTinggi, double setBerat){
        nama = setNama;
        usia = setUsia;
        tinggi = setTinggi;
        berat = setBerat;
    }
    void showNamaUsia(){
        System.out.printf("%s %d\n", nama, usia);
    }
    int getTinggi(){
        return tinggi;
    }
}

class PersonList{
    ArrayListRepeating<Person> daftarPerson;
    private double totalTinggi;
    private int diAtasRata2;
    PersonList(){
        daftarPerson = new ArrayListRepeating<Person>();
        daftarPerson.clear();
        totalTinggi = 0;
        diAtasRata2 = 0;
    }
    void addPerson(String setNama, int setUsia, int setTinggi, double setBerat){
        Person newPerson = new Person();
        newPerson.setPerson(setNama, setUsia, setTinggi, setBerat);
        daftarPerson.add(newPerson);
        totalTinggi += setTinggi;
    }
    double hitungRataTinggi(){
        return totalTinggi/daftarPerson.size();
    }
    void printList(){
        double rataTinggi = hitungRataTinggi();
        Iterator<Person> itr = daftarPerson.iterator();
        while(itr.hasNext()){
            Person orang = itr.next();
            orang.showNamaUsia();
            if(orang.getTinggi()>rataTinggi) diAtasRata2++;
        }
        System.out.printf("%.2f\n", rataTinggi);
        System.out.printf("%d\n", diAtasRata2);
    }
}

public class PersonRepeating {
    public static void main(String[] args){
        PersonList daftarOrang = new PersonList();
        Scanner masukan = new Scanner(System.in);
        int N = masukan.nextInt();
        for(int i=0;i<N;i++){
            String nama = masukan.next();
            int usia = masukan.nextInt();
            int tinggi = masukan.nextInt();
            double berat = masukan.nextDouble();
            daftarOrang.addPerson(nama, usia, tinggi, berat);
        }
        daftarOrang.printList();
    }
}
