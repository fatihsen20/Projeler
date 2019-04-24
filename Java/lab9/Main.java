package com.company;
import java.util.ArrayList;
import java.util.Random;
public class Main extends ArrayList {
    Random x=new Random();
    public ArrayList randomint(){
        int a=x.nextInt(this.size());
        System.out.println(this);
        this.remove(a);
        return this;
    }





}
