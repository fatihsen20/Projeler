import java.util.Scanner;

public class strings {
    public static void main(String[] args) {
        int key=23;
        String orj_alfb="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String temp=new String(orj_alfb.substring(key));
        String ozel_alfb= temp+orj_alfb.substring(0,key);
        //System.out.println(orj_alfb);
        //System.out.println(ozel_alfb);
        String mesaj="BILGISAYARMUHENDISLIGINICOKSEVIYORUM";
        String sifreli_mesaj=mesaj;
        StringBuilder sifre= new StringBuilder(sifreli_mesaj);

        for (int i = 0; i <mesaj.length() ; i++) {
            char orj_char=mesaj.charAt(i);
            int idx=orj_alfb.indexOf(orj_char);
            if(idx!=-1){
                char sifreli_char=ozel_alfb.charAt(idx);
                sifre.setCharAt(i,sifreli_char);
            }
        }
        System.out.println("Gerçek mesaj:"+mesaj+"\n"+"Şifreli mesaj:"+sifre.toString());
    }
}
