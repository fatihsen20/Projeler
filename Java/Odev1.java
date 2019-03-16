public class Odev1{
    public String encrypt(String originalText,String key)
    {
        String alfabe = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Klavyeden girilen harfler küçük olsa bile Uppercase ile büyük harfe dönüştürüldü.
        originalText=toUpperString(originalText);
        key=toUpperString(key);
        //StringBuilder kullanılarak performans artışı sağlandı.
        StringBuilder sifrelenmis_metin= new StringBuilder();
        int sayac=0;//key girdisinin tekrarlanması için sayaç tanımlandı.
        for (int i = 0; i < originalText.length(); i++) {
            //key girdisi ile orignalText uzunlukları eşitlendi.
            if (key.length()==sayac){
                sayac=0;
            }
            //String içerisinde bulunan tüm harflerin konumları alınarak bir toplam değere atandı.
            int idx=((alfabe.indexOf(originalText.charAt(i))) +  (alfabe.indexOf(key.charAt(sayac))))+1;
            sayac++;
            //Toplam değerimiz alfabeden uzunsa mod alma işlemi yapılıyor.
            if (idx>alfabe.length()){
                idx=idx%alfabe.length();
            }
            //.append String'e eleman eklemeye yarar.
            sifrelenmis_metin.append(alfabe.charAt(idx));
        }
        return sifrelenmis_metin.toString();
    }
    //Bu metod sayesinde Uppercase yapabiliyoruz.
    public String toUpperString(String text)
    {

        return text.toUpperCase();
    }
    public String decrypt(String encryptedText,String key)
    {
        String alfabe = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Klavyeden girilen harfler küçük olsa bile Uppercase ile büyük harfe dönüştürüldü.
        encryptedText=toUpperString(encryptedText);
        key=toUpperString(key);
        StringBuilder cozulmus_metin=new StringBuilder();
        int sayac=0;
        for (int i = 0; i <encryptedText.length() ; i++) {
            //Aynı şekilde uzunluk ayarlaması yapıldı.
            if(key.length()==sayac){
                sayac=0;
            }
            //String içerisinde bulunan tüm harflerin konumları alınarak bir toplam değere atandı.
            int idx=((alfabe.indexOf(encryptedText.charAt(i))) -  (alfabe.indexOf(key.charAt(sayac))))-1;
            sayac++;
            //Toplam değerin eksi olması durumunda alfabeye göre mod alındı.
            if(idx<0){
                idx=idx+alfabe.length();
            }
            cozulmus_metin.append(alfabe.charAt(idx));
        }
        return cozulmus_metin.toString();
    }
}

