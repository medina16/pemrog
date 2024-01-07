public class Tes {
    public static void main(String[] args){
        int bil1 = 135;
        int bil2 = 240;
        int sisa = 1;
        while(sisa!=0){
            sisa = bil1%bil2;
            bil1 = bil2;
            bil2 = sisa;
        }
        System.out.printf("%d", bil1);
    }
}
