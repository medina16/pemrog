import java.text.DecimalFormat;
import java.util.Scanner;

interface AritmatikaDasar{
    double tambah(double a, double b);
    double kurang(double a, double b);
    double kali(double a, double b);
    double bagi(double a, double b);
}

interface AritmatikaLanjut{
    double akarKuadrat(double a);
    double pangkat(double a, double b);
}

interface KalkulatorSaintifik extends AritmatikaDasar, AritmatikaLanjut{
    void clear();
}

class Kalkulator implements KalkulatorSaintifik{
    double currentValue;
    Kalkulator(){
        currentValue = 0;
    }
    public double tambah(double a, double b){
        return currentValue = currentValue + b;
    }
    public double kurang(double a, double b){
        return currentValue = currentValue - b;
    }
    public double kali(double a, double b){
        return currentValue = currentValue* b;
    }
    public double bagi(double a, double b){
        return currentValue = currentValue / b;
    }
    public double akarKuadrat(double b){
        return currentValue = Math.sqrt(currentValue);
    }
    public double pangkat(double a, double b){
        double temp = currentValue;
        if(b == 0) currentValue = 1;
        else for(int i=1;i<=b-1;i++) currentValue = currentValue * temp;
        return currentValue;
    }
    public void clear(){
        currentValue = 0;
    }
    public void printValue(){
        DecimalFormat dec = new DecimalFormat("#0.00");
        System.out.println(dec.format(currentValue));
    }
}

public class KalkulatorPraktikum{
    public static void main(String[] args){
        Scanner masukan = new Scanner(System.in);
        Kalkulator objekKalkulator = new Kalkulator();

        String simbol = masukan.next();
        while(!simbol.equals("~")){
            if(simbol.equals("+")){
                double bilangan = masukan.nextDouble();
                objekKalkulator.tambah(0,bilangan);
                objekKalkulator.printValue();
                simbol = masukan.next();
            }
            else if(simbol.equals("-")){
                double bilangan = masukan.nextDouble();
                objekKalkulator.kurang(0,bilangan);
                objekKalkulator.printValue();
                simbol = masukan.next();
            }
            else if(simbol.equals("/")){
                double bilangan = masukan.nextDouble();
                objekKalkulator.bagi(0,bilangan);
                objekKalkulator.printValue();
                simbol = masukan.next();
            }
            else if(simbol.equals("*")){
                double bilangan = masukan.nextDouble();
                objekKalkulator.kali(0,bilangan);
                objekKalkulator.printValue();
                simbol = masukan.next();
            }
            else if(simbol.equals("^")){
                double bilangan = masukan.nextDouble();
                objekKalkulator.pangkat(0,bilangan);
                objekKalkulator.printValue();
                simbol = masukan.next();
            }
            else if(simbol.equals("#")){
                objekKalkulator.akarKuadrat(0);
                objekKalkulator.printValue();
                simbol = masukan.next();
            }
            else if(simbol.equals("C")){
                objekKalkulator.clear();
                objekKalkulator.printValue();
                simbol = masukan.next();
            }
        }
    }
}
