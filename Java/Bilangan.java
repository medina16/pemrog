import java.util.ArrayList;
import java.util.Scanner;

public class Bilangan {
    ArrayList<Integer> arr1;
    ArrayList<Integer> arr2;
    
    public Bilangan(){
        arr1 = new ArrayList<Integer>();
        arr2 = new ArrayList<Integer>();
    }
    public void add(int a){
        arr1.add(a);
        arr2.add(a);
    }
    public void delete(int a, int hapuskeberapa){
        int posisihapus = a - 1 - hapuskeberapa;
        arr2.remove(posisihapus);
    }
    public double rata2(ArrayList<Integer> array){
        double total = 0;
        if(array.size()!=0){
            for(int i=0;i<array.size();i++){
                total += (double)array.get(i);
            }
            return total/array.size();
        }
        else return -9.99;
    }
    public void show(){
        System.out.printf("%d %d\n%.2f %.2f\n", arr1.size(), arr2.size(), rata2(arr1), rata2(arr2));
    }
    public static void main(String[] args){
        Scanner masukan = new Scanner(System.in);
        Bilangan bilanganbulat = new Bilangan();

        int bilbul = masukan.nextInt();
        while(bilbul!=-9){
            bilanganbulat.add(bilbul);
            bilbul = masukan.nextInt();
        }

        int bilbulbuang = masukan.nextInt();
        int hapuskeberapa = 0;
        while(bilbulbuang!=-9){
            bilanganbulat.delete(bilbulbuang,hapuskeberapa);
            hapuskeberapa++;
            bilbulbuang = masukan.nextInt();
        }

        bilanganbulat.show();
    }

}
