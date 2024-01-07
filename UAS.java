import java.io.*;

class Satu{
    int i = 1;
    public int getInt(){return i;}
}

abstract class  A{
    abstract public int f();
    public int g(){return 0;}
}

class B extends A{
    public int f(){return 101;}
}

class C extends A{
    public int f(){return 13;}
}

interface InterfaceA{
    int status = 10;
}

class KelasA{
    int a, b, c;
    public KelasA(int a, int b){
        this.a = a;
        this.b = b;
        this.c = a*b;
    }
}

class KelasB extends KelasA{
    public int d;
    public KelasB(int a, int b){
        super(a,b);
        d = c * a;
        System.out.println(d);
    }
}

class Test{
    static int tinggi = 20;
    static void lala(){System.out.println("WAW");}
}

public class UAS implements InterfaceA {
    public static void main(String args[]){

        System.out.println(status);

        A x = new B();
        System.out.println(x.f());

        x = new C();
        System.out.println(x.f());

        Satu one = new Satu();
        KelasB baru = new KelasB(10,5);

        Test tes = new Test();
        //tes.tinggi = 10;
        System.out.println(tes.tinggi);
        tes.lala();

        
    }
}
