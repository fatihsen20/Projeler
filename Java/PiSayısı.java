public class Main {

    public static void main(String[] args) {
        //birim çember ve integral yardımı ile pi sayısı hesaplama.
        int alt_deger=0,ust_deger=1;
        double h=0.0001;
        double sonuc=0;
        double x;
        for (double i = alt_deger; i <ust_deger ; i=i+h) {
            sonuc+=h*(Math.sqrt(1-Math.pow(i,2)));

        }
        x=4*(sonuc);
        System.out.println(x);


    }
}
