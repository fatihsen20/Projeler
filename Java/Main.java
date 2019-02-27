import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
public class Main {

    public static void main(String[] args) {
/*
        int alt_deger=0,ust_deger=1;
        double h=0.0001;
        double sonuc=0;
        double x;
        for (double i = alt_deger; i <ust_deger ; i=i+h) {
            sonuc+=h*(Math.sqrt(1-Math.pow(i,2)));

        }
        x=4*(sonuc);
        System.out.println(x);
*/
        /*
        Scanner input = new Scanner(System.in); //Kullanıcıdan int değer alabilmek için Scanner sınıfını kullandık
        System.out.print("Lütfen ilk sayiyi giriniz: ");
        int sayi1 = input.nextInt(); //int değer alıyoruz
        */
        String alfabe="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Scanner sifre=new Scanner(System.in);
        System.out.print("Şifrelenecek metni giriniz:");
        String sifrelenecek_metin =sifre.nextLine();
        Scanner anahtar=new Scanner(System.in);
        System.out.print("Anahtar metni giriniz:");
        String anahtar_metin =sifre.nextLine();
        for (int i = 0; i <sifrelenecek_metin.length() ; i++) {
            char orj_char = sifrelenecek_metin.charAt(i);
            int idx = alfabe.indexOf(orj_char);
            char shift_char = anahtar_metin.charAt(i);
            int idx2 = alfabe.indexOf(shift_char);


        }
    }
}
