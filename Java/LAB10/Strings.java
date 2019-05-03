package com.company;

import java.util.Scanner;

public class Strings {

    public static void main(String[] args) {
        String[] stringlist;
        int size;
        Scanner scan = new Scanner(System.in);
        System.out.print ("\nHow many integers do you want to sort? "); size = scan.nextInt();
        stringlist = new String[size+1];
        System.out.println ("\nEnter the String...");
        for (int i = 0; i <= size; i++)
            stringlist[i]=scan.nextLine();
        System.out.println ("\nYour String in sorted order...");
        for (int i = 0; i <= size; i++)
            System.out.print(stringlist[i] + "  ");
        System.out.println ();
        Sorting.insertionSort (stringlist);
        for(String s: stringlist){
            System.out.print(s+ " ");
        }
    }
}
