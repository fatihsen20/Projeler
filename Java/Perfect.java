import java.util.Scanner;
public class Perfect
{
    public static void main(){
        Scanner sc=new Scanner(System.in);
        int toplam=0;
        System.out.println("Bir sayı giriniz:");
        int sayi=sc.nextInt();
        for(int i=1;i<=sayi/2;i++){
            if(sayi%i==0){
            toplam+=i;
            }
        }
        if(toplam==sayi)
        System.out.println("bu mükemmel sayi!");
        else
        System.out.println("bu mükemmel sayi değil!");
    }
}
