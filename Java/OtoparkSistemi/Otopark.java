package com.company;

public class Otopark {
        public final int KAPASITE;
        public Arac[] arac_array;
        public double park_ucreti;
        public double kazanc;

    public Otopark(double park_ucreti,int KAPASITE) {
        this.KAPASITE=KAPASITE;
        this.park_ucreti = park_ucreti;
        kazanc=0;
        arac_array=new Arac[KAPASITE];
    }
    public Otopark(Otopark otoparkobj){
        kazanc=otoparkobj.kazanc;
        KAPASITE=otoparkobj.KAPASITE;
        park_ucreti=otoparkobj.park_ucreti;
        arac_array=otoparkobj.arac_array;

    }
    public void print(){
        for (int i = 0; i <arac_array.length ; i++) {
            if (arac_array[i]!=null){
                System.out.println(arac_array[i].arac_sahibi+" "+arac_array[i].plaka);
            }
        }
    }
    public void kazanc (){
        System.out.println(kazanc+" TL kazanıldı.");
    }
    public void arac_kabul(Arac arac){
        for (int i = 0; i <arac_array.length ; i++) {
            if(arac_array[i]==null){
                arac_array[i]=arac;
                kazanc+=park_ucreti;
                break;
            }
        }
    }
    public void arac_cıkar(int arac_number){
        if (arac_array[arac_number]!=null){
            System.out.println(arac_array[arac_number].arac_sahibi+" sahipli arac cikarildi!");
            arac_array[arac_number]=null;

        }
    }
}
