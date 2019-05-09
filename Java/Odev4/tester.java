package com.company;

public class tester {
    public static void main(String[] args) {

        Gemi[] gemiarray=new Gemi[3];
        gemiarray[0]=new Gemi("sallah","2019");
        gemiarray[1]=new TuristikGemi("messi","2018",9);
        gemiarray[2]=new KargoGemisi("ronaldo","2017",3000);
        System.out.println(gemiarray[0].toString());
        System.out.println(gemiarray[1].toString());
        System.out.println(gemiarray[2].toString());

    }
}
