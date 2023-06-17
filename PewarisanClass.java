import java.util.*;

class Pegawai{
    protected String id;
    protected int usia;
    protected int tipe;
    protected int income;
    public Pegawai() {
        id=""; usia=income=0; tipe=1; 
    }
    public void set(String pid, int u, int t ) {
        id=pid; usia=u; tipe=t;
    }
    public String getID() {
        return id; 
    }
    public void show() { 
        System.out.printf("%s %d %d\n", id, tipe, income); 
    } 
};
class DaftarPegawai{
    LinkedHashMap<String, Tetap> daftarpegtetap = new LinkedHashMap<String, Tetap>();
    LinkedHashMap<String, Harian> daftarpegharian = new LinkedHashMap<String, Harian>();
    public void addpegawaitetap(String pid, Tetap pegawai){
        daftarpegtetap.put(pid, pegawai);
    }
    public void addpegawaiharian(String pid, Harian pegawai){
        daftarpegharian.put(pid, pegawai);
    }
    public void setgaji(String pid, int nominal){
        boolean tetap = daftarpegtetap.containsKey(pid);
        boolean harian = daftarpegharian.containsKey(pid);
        if(tetap==true) daftarpegtetap.get(pid).adalembur(nominal);
        else if(harian==true) daftarpegharian.get(pid).setIncome(nominal);
    }
    public void printpegtetap(){
        for (String idpegawai : daftarpegtetap.keySet()){
            daftarpegtetap.get(idpegawai).show();
        }
    }
    public void printpegharian(){
        for (String idpegawai : daftarpegharian.keySet()){
            daftarpegharian.get(idpegawai).show();
        }
    }

}
class Tetap extends Pegawai{
    private int gajipokok;
    public Tetap(){
        super();
    }
    public void settetap(String pid, int u, int t, int gp){
        set(pid, u, t);
        income = gp;
    }
    public void adalembur(int ul){
        income = income + ul;
    }
};
class Harian extends Pegawai{
    public Harian(){
        super();
    }
    public void setIncome(int upah){
        income = upah;
    }
};

public class PewarisanClass {
    public static void main(String[] args){
        Scanner masukan = new Scanner(System.in);

        int N = masukan.nextInt();

        String id;
        int usia, tipe;
        int gajipokok;
        DaftarPegawai daftar = new DaftarPegawai();
        for(int i=0;i<N;i++){
            id = masukan.next();
            usia = masukan.nextInt();
            tipe = masukan.nextInt();
            if(tipe==1){
                Tetap pegawaitetap = new Tetap();
                gajipokok = masukan.nextInt();
                pegawaitetap.settetap(id, usia, tipe, gajipokok);
                daftar.addpegawaitetap(id, pegawaitetap);
            }
            if(tipe==2){
                Harian pegawaiharian = new Harian();
                pegawaiharian.set(id, usia, tipe);
                daftar.addpegawaiharian(id, pegawaiharian);
            }
        }

        int gaji;
        id = masukan.next();
        while(!id.equals("END")){
            gaji = masukan.nextInt();
            daftar.setgaji(id, gaji);

            id = masukan.next();
        }

        daftar.printpegtetap();
        daftar.printpegharian();
    }
        
}
