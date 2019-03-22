package com.company;
import java.security.SecureRandom;

public class Main {

    public static void main(String[] args) {
        int[] not_array=new int[12];
        SecureRandom randomNumbers = new SecureRandom();
        int[] frekans=new int[11];
        for (int i = 0; i <not_array.length ; i++) {
            not_array[i]=randomNumbers.nextInt(101);
        }
        for (int count=0;count<frekans.length;count++){
            frekans[not_array[count]/10]++;
        }

        int max=frekans[0];
        for (int i = 0; i <frekans.length ; i++) {
            if(max<frekans[i])
                max=frekans[i];
        }
        for(int yildiz=max;yildiz>0;yildiz--){
            for (int i = 0; i <frekans.length ; i++) {
                if (yildiz<=frekans[i])
                    System.out.printf("  %s   ","*");
                else
                    System.out.printf("%6s","");
            }
            System.out.println();
        }

        for (int i = 0; i <frekans.length-1 ; i++) {
            System.out.printf("%02d-%02d ",i*10,(i+1)*10-1);
        }
        System.out.print("100");


    }
}
