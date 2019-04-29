#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<string.h>
#include<locale.h>

#define size 25
using namespace std;

struct film_bilgileri{
	char film_adi[size];
	char yonetmen[size];
	char basrol[size];
	char senarist[size];
	int yil;
}filmler;
//Fonksiyon imzaları.
int Menu();
void filmEkle();
void film_sil();
void FilmListele();
void Film_ara();
void film_guncelle();
void Film_ara();
int main()
{
	//Alt satırda ki kodu printler içine Türkçe dil desteği eklemek için yazdım.
	setlocale(LC_ALL, "Turkish");
	//Alt satırda ki kod cmd ekranının renkli olmasını sağlar.
	system("color fc");
	printf("+++++++++++++++++++++++++++++++FİLM ARŞİVLEME SİSTEMİ++++++++++++++++++++++++++++++\n\n");
	Menu();
    getch();
    return 0;
}
//Menü sistemini fonksiyon olarak yazdım.Görünüş açısından daha hoş.
int Menu()
{
	//Switch-case sistemi ve if yardımıyla menü sistemini yazdım.
     char Tercih = 'r';
     printf("\n");
	printf(" Film Ekle-->1\n Filmleri Listele-->2\n Film Güncelle-->3\n Film Sil-->4\n Film Ara-->5\n");	
     Tercih = getche();
     while(Tercih != 'E' || Tercih != 'e') {
          switch(Tercih)
          {
                        case '1': {filmEkle();break;}
                        case '2': {FilmListele();break;}
                        case '3': {film_guncelle();break;}
                        case '4': {film_sil();break;}
                        case '5': {Film_ara();break;}
						
						
						
          }
          printf("\nBaşka işlem yapmak istiyor musunuz(E/H)?\n");
          Tercih = getche();
          if(Tercih == 'H' || Tercih == 'h') {
                    break;
          }
          if(Tercih == 'E' || Tercih== 'e'){
          	//İşlemlerin tekrar yapılabilmesi için kendini yenileyip menüye giden fonksiyonu yazdım.
          	return Menu();
		  }
     }
}
void filmEkle()
{
	//Dosya tipinde pointer oluşturarak veritabanını oluşturdum.
	FILE *fp;
	fp = fopen("filmveritabanı.dat","a");
	fflush(stdin);//boşlukları karakter olarak almasını engellemek için fflush(stdin) fonksiyonunu yazdım ve gets ile verileri aldım.
	printf("\n");
	printf("Lütfen Filmin Adını giriniz:\n");
	gets(filmler.film_adi);
	fflush(stdin);
	fflush(stdin);
	printf("Lütfen Filmin Başrolünü giriniz:\n");
	gets(filmler.basrol);
	fflush(stdin);
	fflush(stdin);
	printf("Lütfen Filmin Senaristini giriniz:\n");
	gets(filmler.senarist);
	fflush(stdin);
	fflush(stdin);
	printf("Lütfen Filmin Yönetmenini giriniz:\n");
	gets(filmler.yonetmen);
	fflush(stdin);
	printf("Lütfen Filmin Yayınlanma Yılını giriniz:\n");
	scanf("%d",&filmler.yil);
	//fwrite komutu aldığımız verileri dosyaya yazmak için kullanılır.
	fwrite(&filmler,sizeof(film_bilgileri),1,fp);
	//fclose fonksiyonu dosyayı kapatmaya yarar.
	fseek(fp,0,SEEK_SET);
	fclose(fp);
	printf("Film başarıyla eklendi^__^\n");
	return;
}
void film_sil(){
     char filmad_temp[30];
     FILE *FilmDB;
     FILE *TempFilmDB;
     printf("\nSilmek istediğiniz filmin adını giriniz: \n");
     fflush(stdin);
     gets(filmad_temp);
     // Dosyadaki bütün kayıtlar taranır ve silinmesini istediğimiz kayıt atlanarak geçici bir dosyaya, silinecek kayıt dışındakilerin hepsi yazılır. 
     FilmDB = fopen("filmveritabanı.dat","r");
     TempFilmDB = fopen("TempFile.dat","a");
     //Burada temp dosyasına yazdırma işlemi yapılıyor.
	 while(fread(&filmler, sizeof(film_bilgileri),1,FilmDB))
     {
                if(strcmp(filmler.film_adi,filmad_temp)==0)
                {
                	char x;
				printf("Film silinecek emin misiniz?(Silmek için y/vazgeçmek için n)\n");
				fflush(stdin);
				scanf("%c" ,&x);
				if(x=='y'|| x=='Y'){
                    printf("\nFilm başarıyla silindi^__^\n");
					}
					else{
						printf("Silme iptal edildi-__-\n");
						fwrite(&filmler, sizeof(film_bilgileri),1,TempFilmDB);
					}
				}
					else{
						fwrite(&filmler, sizeof(film_bilgileri),1,TempFilmDB);
					}
					if(strcmp(filmler.film_adi,filmad_temp)==0){
					}
                	
                
            
     }
     //İmleç dosya başına gönderiliyor.
     fseek(TempFilmDB,0,SEEK_SET);
     fclose(FilmDB);
     fclose(TempFilmDB);
     // Dosya silinir.
     remove("filmveritabanı.dat");
     // geçici dosyanın ismi asıl dosya ismi değiştirilir.
     rename("TempFile.dat","filmveritabanı.dat");
}
void FilmListele(){
	struct film_bilgileri gecici;
	FILE *fp;
	fp = fopen("filmveritabanı.dat","r");
	//struct dizisi oluşturarak sıralama işini gerçekleştirdim.
	struct film_bilgileri filmler[size] = {"","","","",0};
	int i = 0;
	if(fp == NULL)
	{	printf("\nDosya açılamadı-__-\n");
	return;
	}
	else{
		while(fread(&filmler[i],sizeof(film_bilgileri),1,fp))
		{ i++;
		}
		//Bubble sort algoritması ile sıralama gerçekleştirildi.
	for(i = 0; i < size-1; i++){
		for(int j = 0; j < size-i-1; j++){
			if(filmler[j+1].yil > filmler[j].yil){
				gecici = filmler[j];
				filmler[j] = filmler[j+1];
				filmler[j+1] = gecici;

				}
			}
		}
	printf("\nFilm Adı\tBaşrol\t\tYönetmen\tSenarist\tYayınlanma Yılı\n");
	for (i = 0; i < size; i++){
		if(filmler[i].yil == 0 ){
			}
		else{
			printf("\n");
			printf("%s\t\t%s\t\t%s\t\t%s\t\t%4d\n",filmler[i].film_adi,filmler[i].basrol,filmler[i].yonetmen,filmler[i].senarist,filmler[i].yil);
			}
		}
	}
rewind(fp); //Dosyayı başa yollayarak fonlsiyonun stabil çalışmasını sağladım. 
fclose(fp);
printf("\n");
return;
}
void film_guncelle(){
	//struct dizileri oluşturup verileri buraya kaydettik.
	struct film_bilgileri guncelleme = {"","","","",0};
	struct film_bilgileri sil = {"","","","",0};
	FILE *filep;//File cinsinde bir pointer oluşturuldu.
    char isim[size];	 
    
    printf("Güncellemek istediğiniz filmin adını giriniz: ");
    scanf("%s",&isim);
    //burada film verilerini çekiyoruz.
        if((filep=fopen("filmveritabanı.dat","r+"))==NULL)
        {
            printf("Veritabanı bulunamadı-__-");
        }
        else
        {	rewind(filep);
         while (fread(&guncelleme,sizeof(filmler),1,filep))
            {
		
        //Burada güncelleme işlemleri yapılıyor.
            if(strcmp(guncelleme.film_adi,isim)==0)
            {
                
            	           
                printf("Güncellenecek film "
                        "%s %s %s %s %d",
		        guncelleme.film_adi,guncelleme.yonetmen,guncelleme.basrol,guncelleme.senarist,guncelleme.yil);
				            
                fflush(stdin);
                printf("\nyeni film adı:");
                gets(guncelleme.film_adi);
				printf("\n%s filminin yönetmenini giriniz:",guncelleme.film_adi);
                gets(guncelleme.yonetmen);
				printf("\n%s filminin başrolünü giriniz:",guncelleme.film_adi);
                gets(guncelleme.basrol);
				printf("\n%s filminin senaristini giriniz:",guncelleme.film_adi);
                gets(guncelleme.senarist);
				printf("\n%s filminin yılını giriniz :",guncelleme.film_adi);
                scanf("%d",&guncelleme.yil);
                
                //Silme ve güncelleme işlemleri yapılıyor.
                int imlec=ftell(filep);

                fseek(filep,-imlec,SEEK_CUR );
                  fwrite(&sil,sizeof(filmler),1,filep);
				                  
                 fseek(filep,-imlec,SEEK_CUR);
                fwrite(&guncelleme,sizeof(filmler),1,filep);
                 imlec=ftell(filep);

                break;
            }
        }}
        fclose(filep);
}
 void Film_ara(){
 	//işimize yarayacak değişkinler tanımlandı.
	struct film_bilgileri arama = {"","","","",0};
	FILE *fileptr;
	char filmadi[size];
	char yonetmenadi[size];
	char basroladi[size];
	char senaristadi[size];
	int yil;
	int bulundu=0;
	char secim;
			
	if((fileptr=fopen("filmveritabanı.dat","r"))==NULL)
        {
            printf("Dosya bulunamadı-__-");
        }
        
    else
        {
        	
    printf("\nFilm adına göre arama:1\n");
    printf("Filmin yönetmenine göre arama:2\n");
    printf("Filmin başrol oyuncusuna göre arama:3\n");
    printf("Filmin senaristine göre arama:4\n");
    printf("Filmin yayınlanma yılına göre arama:5\n");
    printf("Çıkış yapmak için:0\n");
    
    printf("\nMenudekilerden Birini Seçiniz.\n");
    scanf("%d",&secim);
	    	
    switch(secim){    	
	case 1:		
		fflush(stdin);
		printf("Aradığınız filmin adını giriniz:");
        gets(filmadi);            
	while(!feof(fileptr))
        {            
            fread(&arama,sizeof(filmler),1,fileptr);
            if((strcmp(arama.film_adi,filmadi))==0)
                {
                	bulundu++;
                    printf("|----------Arama--Sonucu------------|\n\n"
                    "Aradığınız İsimdeki Filmler\n\n"
                    "Filmin adı : %s\nFilmin yönetmeni : %s\nFilmin başrolü : %s\nFilmin senaristi : %s\nYayınlanma yılı : %d\n"
					,arama.film_adi,arama.yonetmen,arama.basrol,arama.senarist,arama.yil);										
                }
        }
        if(bulundu > 0)
		{
            printf("\n%d Tane film bulundu^__^",bulundu);	
		}
		else
		{
		    printf("\nHiçbir film bulunamadı-__-");	
		}        
	break;	
	case 2:		
		fflush(stdin);
		printf("Aradığınız yönetmeninin adını giriniz:");
        gets(yonetmenadi);            
	while(!feof(fileptr))
        {            
            fread(&arama,sizeof(filmler),1,fileptr);
            if((strcmp(arama.yonetmen,yonetmenadi))==0)
                {
                	bulundu++;
                    printf("|----------Arama--Sonucu------------|\n\n"
                    "Aradığınız Yönetmenin Filmleri\n\n"
                    "Filmin adı : %s\nFilmin yönetmeni : %s\nFilmin başrolü : %s\nFilmin senaristi : %s\nYayınlanma yılı : %d\n"
					,arama.film_adi,arama.yonetmen,arama.basrol,arama.senarist,arama.yil);										
                }
        }
        if(bulundu > 0)
		{
            printf("\n%d Tane film bulundu^__^",bulundu);	
		}
		else
		{
		    printf("\nHiçbir film bulunamadı-__-");	
		}	
	break;			
	case 3:		
		fflush(stdin);
		printf("Aradığınız basrolun adını girin:");
        gets(basroladi);           
	while(!feof(fileptr))
        {            
            fread(&arama,sizeof(filmler),1,fileptr);
            if((strcmp(arama.basrol,basroladi))==0)
                {
                	bulundu++;
                    printf("|----------Arama--Sonucu------------|\n\n"
                    "Aradığınız Başrolün Filmleri\n\n"
                    "Filmin adı : %s\nFilmin yönetmeni : %s\nFilmin başrolü : %s\nFilmin senaristi : %s\nYayınlanma yılı : %d\n"
					,arama.film_adi,arama.yonetmen,arama.basrol,arama.senarist,arama.yil);										
                }
        }
        if(bulundu > 0)
		{
            printf("\n%d Tane film bulundu^__^",bulundu);	
		}
		else
		{
		    printf("\nHiçbir film bulunamadı-__-");	
		}		
	break;	
	case 4:	
		fflush(stdin);
		printf("Aradığınız senaristin adını girin:");
        gets(senaristadi);            
	while(!feof(fileptr))
        {            
            fread(&arama,sizeof(filmler),1,fileptr);
            if((strcmp(arama.senarist,senaristadi))==0)
                {
                	bulundu++;
                    printf("|----------Arama--Sonucu------------|\n\n"
                    "Aradığınız Senaristin Filmleri\n\n"
                    "Filmin adı : %s\nFilmin yönetmeni : %s\nFilmin başrolü : %s\nFilmin senaristi : %s\nYayınlanma yılı : %d\n"
					,arama.film_adi,arama.yonetmen,arama.basrol,arama.senarist,arama.yil);										
                }
        }
        if(bulundu > 0)
		{
            printf("\n%d Tane film bulundu^__^",bulundu);	
		}
		else
		{
		    printf("\nHiçbir film bulunamadı-__-");	
		}		
	break;	
	case 5:
	
		fflush(stdin);
		printf("Aradığınız yılı girin:");
        scanf("%d",&yil);            
	while(fread(&arama,sizeof(filmler),1,fileptr))
        {            
            if(yil != 0){
            	if(arama.yil == yil)
                {
                	bulundu++;
                    printf("|----------Arama--Sonucu------------|\n\n"
                    "Aradığınız Yıldaki Filmler\n\n"
                    "Filmin adı : %s\nFilmin yönetmeni : %s\nFilmin başrolü : %s\nFilmin senaristi : %s\nYayınlanma yılı : %d\n"
					,arama.film_adi,arama.yonetmen,arama.basrol,arama.senarist,arama.yil);										
                }
			}            
        }
        if(bulundu > 0)
		{
            printf("\n%d Tane film bulundu^__^",bulundu);	
		}
		else
		{
		    printf("\nHiçbir film bulunamadı-__-");	
		}		
	break;	
	case 0:
		printf("Ana menüye dönüyorsunuz.");
	break;	
	default :	
	printf("Gecersiz bir deger girdiniz-__-\n\n");
	break;			
    }
        }
    fclose(fileptr);		        
}
