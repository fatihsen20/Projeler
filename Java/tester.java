package com.company;
import java.util.Scanner;

public class tester {
    static Kaplumbaga[] kaplumbagalar;
    static Tavsan[] tavsanlar;
    static int karesayisi=70;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Kaplumbaga sayısını giriniz:");
        int kaplmbsayi= sc.nextInt();
        System.out.println("Tavşan sayisini giriniz:");
        int tavsansayi=sc.nextInt();
        kaplumbagalar=new Kaplumbaga[kaplmbsayi];
        tavsanlar=new Tavsan[tavsansayi];
        doldur();
        System.out.println("Basla:");
        yazdir();
        boolean finish=false;
        int kazanan_kaplmbg=-2;
        int kazanan_tavsan=-2;
        int tur=1;
        while (!finish){
            for (int i = 0; i <kaplumbagalar.length ; i++) {
                kaplumbagalar[i].hareket_et();
                if (kaplumbagalar[i].pozisyon_dondur()==karesayisi){
                    kazanan_kaplmbg=i;
                    finish=true;
                    break;
                }
            }
            for (int i = 0; i <tavsanlar.length ; i++) {
                tavsanlar[i].hareket_et();
                if (tavsanlar[i].pozisyon_dondur()==karesayisi){
                    kazanan_tavsan=i;
                    finish=true;
                    break;
                }

            }
            System.out.println("Tur:"+tur);
            yazdir();
            tur++;


        }
        if (kazanan_kaplmbg>-2&&kazanan_tavsan>-2){
            System.out.println("Beraberlik durumu:kaplumbaga-"+kazanan_kaplmbg+"tavsan-"+kazanan_tavsan);
        }
        else if(kazanan_kaplmbg>-2)
            System.out.println("Kaplumbaga-"+kazanan_kaplmbg +"kazandı!");
        else if(kazanan_tavsan>-2)
            System.out.println("Tavsan-"+kazanan_tavsan+"kazandi!");


    }
    static void doldur(){
        for (int i = 0; i <kaplumbagalar.length ; i++)
            kaplumbagalar[i]=new Kaplumbaga();
        for (int i = 0; i <tavsanlar.length ; i++)
            tavsanlar[i]=new Tavsan();
    }
        static void yazdir() {
            int kaplumbagasabit;
            int tavsansabit;
            StringBuilder kaplmbgstr = new StringBuilder(100);
            StringBuilder tavsanstr = new StringBuilder(100);
            for (int i = 0; i < karesayisi; i++) {
                kaplumbagasabit = 0;
                tavsansabit = 0;
                boolean kaplmbgvar = false;
                for (int j = 0; j < kaplumbagalar.length; j++) {
                    if (kaplumbagalar[j].pozisyon_dondur() == i) {
                        kaplmbgvar = true;
                        kaplumbagasabit++;
                    }

                }
                if (kaplmbgvar)
                    kaplmbgstr.append("K ");
                else
                    kaplmbgstr.append("- ");
                boolean tavsanvar = false;
                for (int j = 0; j < tavsanlar.length; j++) {
                    if (tavsanlar[j].pozisyon_dondur() == i) {
                        tavsanvar = true;
                        tavsansabit++;
                    }

                }
                /*
                if (tavsanvar)
                    tavsanstr.append("T ");
                else
                    tavsanstr.append("- ");
                    */
                if (kaplumbagasabit != 0)
                    System.out.print(kaplumbagasabit + "K");
                else
                    System.out.print("--");
                if (tavsansabit != 0)
                    System.out.print(tavsansabit + "T");
                else
                    System.out.print("--");
            }
            System.out.println("=======================================");
        }

        }

