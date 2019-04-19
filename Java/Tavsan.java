package com.company;

public class Tavsan {
    static int position=1;
    public int pozisyon_dondur(){
        return position;
    }
    public void hareket_et(){
        int zar=(int)(Math.random()*100)+1;
        if(zar<=20){

        }
        else if(zar<=40)
            pozisyon_ekle(9);
        else if(zar<=50)
            pozisyon_ekle(-12);
        else if(zar<=80)
            pozisyon_ekle(1);
        else if(zar<=100)
            pozisyon_ekle(-2);
    }
    public void pozisyon_ekle(int toplam){
        if (toplam+position<=1)
            position=1;
        else if((toplam+position)>=70)
            position=70;
        else
            position+=toplam;
    }
}
