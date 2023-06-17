import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

interface Answerable{
    boolean cekJawaban(String jawaban);
}

class Soal {
    String soal;
    Soal(String isipertanyaan){
        soal = isipertanyaan;
    }
}

class SoalIsian implements Answerable{
    Soal pertanyaan;
    String kuncijawaban;
    SoalIsian(String isipertanyaansoal, String kuncijawabansoal){
        pertanyaan = new Soal(isipertanyaansoal);
        kuncijawaban = kuncijawabansoal;
    }
    public boolean cekJawaban(String jawaban){
        if(jawaban.equals(kuncijawaban)) return true;
        else return false;
    }
}

class Ujian{
    ArrayList<SoalIsian> daftarsoalujian;
    ArrayList<Integer> sudahdikerjakan;
    int jawabanbenar;
    double nilaiujian;
    Ujian(){
        daftarsoalujian = new ArrayList<SoalIsian>();
        sudahdikerjakan = new ArrayList<Integer>();
        nilaiujian = 0;
        jawabanbenar = 0;
    }
    public void buatSoal(String pertanyaan, String kuncijawaban){
        SoalIsian soalbaru = new SoalIsian(pertanyaan, kuncijawaban);
        daftarsoalujian.add(soalbaru);
    }
    public void kerjakan(int nomorsoal, String jawaban){
        if(daftarsoalujian.get(nomorsoal).cekJawaban(jawaban) && !sudahdikerjakan.contains(nomorsoal)) {jawabanbenar++;}
        sudahdikerjakan.add(nomorsoal);
    }
    public double getNilai(){
        nilaiujian = (double)jawabanbenar / (double)daftarsoalujian.size() * 100;
        return nilaiujian;
    }
}

public class SimulasiUjian {
    public static void main(String[] args){
        Scanner masukan = new Scanner(System.in);
        Ujian ujian = new Ujian();
        String pertanyaan;
        String kuncijawaban;

        int N = masukan.nextInt();
        masukan.nextLine(); // buang newline
        for(int i=0;i<N;i++){
            pertanyaan = masukan.nextLine();
            kuncijawaban = masukan.nextLine();
            ujian.buatSoal(pertanyaan,kuncijawaban);
        }
        
        int jumlahdijawab = masukan.nextInt();
        for(int i=0;i<jumlahdijawab;i++){
            int nomorsoal = masukan.nextInt();
            nomorsoal--;
            masukan.nextLine(); // buang newline
            String jawaban = masukan.nextLine();
            ujian.kerjakan(nomorsoal,jawaban);
        }
        
        DecimalFormat dec = new DecimalFormat("#0.00");
        System.out.println(dec.format(ujian.getNilai()));
    }
}