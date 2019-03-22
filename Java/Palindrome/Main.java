package com.company;

public class Main {

    public static void main(String[] args) {
	int[] not_array={9,10,20,40,55,67,89,23,100,8,99,87};
	int[] frekans=new int[11];
	int counter;
        for (counter = 0; counter <not_array.length ; counter++) {
            if(not_array[counter] >= 0 && not_array[counter] <=9 ){
                frekans[0]++;
            }
            else if(not_array[counter] >= 10 && not_array[counter] <=19 ){
                frekans[1]++;
            }
            else if(not_array[counter] >= 20 && not_array[counter] <=29 ){
                frekans[2]++;
            }
            else if(not_array[counter] >= 30 && not_array[counter] <=39 ){
                frekans[3]++;
            }
            else if(not_array[counter] >= 40 && not_array[counter] <=49 ){
                frekans[4]++;
            }
            else  if(not_array[counter] >= 50 && not_array[counter] <=59 ){
                frekans[5]++;
            }
            else  if(not_array[counter] >= 60 && not_array[counter] <=69 ){
                frekans[6]++;
            }
            else if(not_array[counter] >= 70 && not_array[counter] <=79 ){
                frekans[7]++;
            }
            else  if(not_array[counter] >= 80 && not_array[counter] <=89 ){
                frekans[8]++;
            }
            else  if(not_array[counter] >= 90 && not_array[counter] <=99 ){
                frekans[9]++;
            }
            else  if(not_array[counter]==100){
                frekans[10]++;
            }
        }
        int max=frekans[0];
        for (int i = 0; i <frekans.length ; i++) {
            if(max<frekans[i]){
                max= frekans[i];
        }
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

        for (int aralik = 0; aralik <frekans.length-1; aralik++) {
            System.out.printf("%02d-%02d ",aralik*10,(aralik+1)*10-1);
        }

        System.out.print("100");

        }
    }

