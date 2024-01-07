import java.util.*;

public class PecahanRepeating {
    private int a, b, c;
    public PecahanRepeating(){
        a = 0; b = 0; c = 0;
    }
    public void sederhanabil(){
        a = a + b/c;
        b = b%c;
        int fpb = carifpb(b,c);
        b = b/fpb;
        c = c/fpb;
    }
    public int carifpb(int bil1, int bil2){
        int sisa = 1;
        while(sisa!=0){
            sisa = bil1%bil2;
            bil1 = bil2;
            bil2 = sisa;
        }
        return bil1;
    }
    public void setbil(int set_a, int set_b, int set_c){
        a = set_a; b = set_b; c = set_c;
        sederhanabil();
    }
    public void printbil(){
        System.out.printf("%d", a);
        if(b>0) System.out.printf(" %d/%d", b, c);
        System.out.printf("\n");
    }
    public void addbil(int add_a, int add_b, int add_c){
        b = b * add_c + add_b * c; 
        c = c * add_c;
        a = a + add_a;
        sederhanabil();
    }
    public void mulbil(int mul_a, int mul_b, int mul_c){
        b = (c*a+b) * (mul_c*mul_a+mul_b);
        c = c * mul_c;
        a = 0;
        sederhanabil();
    }
    public void incbil(){
        a++;
    }
    public void decbil(){
        a--;
    }
    public static void main(String[] args){
        Scanner masukan = new Scanner(System.in);
        int a = 0, b = 0, c = 0;
        PecahanRepeating bilanganpecahan = new PecahanRepeating();

        String ops = masukan.next();
        while(!ops.equals("end")){
            if(ops.equals("set")){
                a = masukan.nextInt();
                b = masukan.nextInt();
                c = masukan.nextInt();
                bilanganpecahan.setbil(a,b,c);
            }
            else if(ops.equals("p")){
                bilanganpecahan.printbil();
            }
            else if(ops.equals("add")){
                a = masukan.nextInt();
                b = masukan.nextInt();
                c = masukan.nextInt();
                bilanganpecahan.addbil(a,b,c);            }
            else if(ops.equals("mul")){
                a = masukan.nextInt();
                b = masukan.nextInt();
                c = masukan.nextInt();
                bilanganpecahan.mulbil(a,b,c);
            }
            else if(ops.equals("inc")){
                bilanganpecahan.incbil();
            }
            else if(ops.equals("dec")){
                bilanganpecahan.decbil();
            }
            ops = masukan.next();
        }
    }
}
