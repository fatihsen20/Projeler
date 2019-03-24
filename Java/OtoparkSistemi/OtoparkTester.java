package com.company;

public class OtoparkTester {
    public static void main(String[] args) {
        Otopark otoparkobj1=new Otopark(3.5,30);
        Arac aracobj1=new Arac(2000,"Fatih");
        Arac aracobj2=new Arac(1000,"hi");
        Arac aracobj3=new Arac(1500,"hello");
        Arac aracobj4=new Arac(1200,"Salih");
        otoparkobj1.arac_kabul(aracobj1);
        otoparkobj1.arac_kabul(aracobj2);
        otoparkobj1.arac_kabul(aracobj3);
        otoparkobj1.arac_kabul(aracobj4);
        otoparkobj1.print();
        otoparkobj1.kazanc();
        System.out.println("===============================");
        otoparkobj1.arac_cıkar(0);
        otoparkobj1.print();
        System.out.println("===============================");
        Otopark otoparkobj2=new Otopark(otoparkobj1);
        otoparkobj2.print();
        System.out.println("===============================");
        otoparkobj2.arac_cıkar(1);
        otoparkobj2.print();
        System.out.println("===============================");

    }
}
