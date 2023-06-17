import java.util.Scanner;
public class Pecahan {
    private int a;
    private int b;
    private int c;
    private int fpb(int m, int n){
        while(n!=0){
            int t = m%n;
            m = n;
            n = t;
        }
        return m;
    }
    private void simplify(){
        a = a + b/c;
        b = b%c;
        int t = fpb(b,c);
        b = b/t;
        c = c/t;
    }
    public Pecahan(){
        a = b = c = 0;
    }
    public void set(int pa, int pb, int pc){
        a = pa; b = pb; c = pc;
        simplify();
    }
    public void add(int pa, int pb, int pc){
        a = a + pa;
        b = b*pc + pb * c;
        c = c * pc;
        simplify();
    }
    public void mul(int pa, int pb, int pc){
        int dikali_pembilang = c*a+b;
        int pengali_pembilang = pc*pa+pb;
        a = 0;
        c = c * pc;
        b = dikali_pembilang * pengali_pembilang;
        simplify();
    }
    public void inc(){
        a++;
    }
    public void dec(){
        a--;
    }
    public void show(){
        System.out.print(a);
        if(b>0) System.out.printf(" %d/%d", b, c);
        System.out.print("\n");
    }
    public static void main(String[] args){
        String operasi;
        Scanner masukan = new Scanner(System.in);

        operasi = masukan.next(); //baca input berupa string
        int pa, pb, pc;
        Pecahan obj = new Pecahan();
        while(!operasi.equals("end")){
            if(operasi.equals("set")){
                pa = masukan.nextInt();
                pb = masukan.nextInt();
                pc = masukan.nextInt();
                obj.set(pa,pb,pc);
            }
            else if(operasi.equals("p")){
                obj.show();
            }
            else if(operasi.equals("add")){
                pa = masukan.nextInt();
                pb = masukan.nextInt();
                pc = masukan.nextInt();
                obj.add(pa,pb,pc);
            }
            else if(operasi.equals("mul")){
                pa = masukan.nextInt();
                pb = masukan.nextInt();
                pc = masukan.nextInt();
                obj.mul(pa,pb,pc);
            }
            else if(operasi.equals("inc")){
                obj.inc();
            }
            else if(operasi.equals("dec")){
                obj.dec();
            }
            operasi = masukan.next();
        }
    }
}
