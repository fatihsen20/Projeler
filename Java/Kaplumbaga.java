package com.company;

public class Kaplumbaga {
    static int position=1;
    public int pozisyon_dondur(){
        return position;
    }
    public void hareket_et(){
        int zar=(int)(Math.random()*100)+1;
        if(zar<=50){
            pozisyonekle(3);
        }
        else if(zar<=70){
            pozisyonekle(-6);
        }
        else if(zar<=100){
            pozisyonekle(1);
        }
    }
    public void pozisyonekle(int toplam){
        if (toplam+position<=1)
            position=1;
        else if((toplam+position)>=70)
            position=70;
        else
            position+=toplam;
    }
}
