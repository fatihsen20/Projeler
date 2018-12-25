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

int Menu();
void filmEkle();
void film_sil();
void FilmListele();
void Film_ara();
int main()
{
	setlocale(LC_ALL, "Turkish");
	system("color fc");
	printf("+++++++++++++++++++++++++++++++FÝLM ARÞÝVLEME SÝSTEMÝ++++++++++++++++++++++++++++++\n\n");
	Menu();
    getch();
    return 0;
}
int Menu()
{
     char Tercih = 'r';
     printf("\n");
	printf(" Film Ekle-->1\n Filmleri Listele-->2\n Film Güncelle-->3\n Film Sil-->4\n Film Ara-->5\n Programdan Çýk-->E\n");	
     Tercih = getche();
     while(Tercih != 'E' || Tercih != 'e') {
          switch(Tercih)
          {
                        case '1': {filmEkle();break;}
                        case '2': {FilmListele();break;}
                        case '3': {;break;}
                        case '4': {film_sil();break;}
                        case '5': {Film_ara();break;}
						
						
						
          }
          printf("\nBaþka iþlem yapmak istiyor musunuz(E/H)?\n");
          Tercih = getche();
          if(Tercih == 'H' || Tercih == 'h') {
                    break;
          }
          if(Tercih == 'E' || Tercih== 'e'){
          	return Menu();
		  }
     }
}
void filmEkle()
{
	FILE *fp;
	fp = fopen("filmveritabaný.dat","a");
	printf("\nfilm adýný,baþrolü,senaristi,yönetmeni ve yayýnlanma yýlýný giriniz:\n");
	fflush(stdin);
	gets(filmler.film_adi);
	gets(filmler.basrol);
	gets(filmler.senarist);
	gets(filmler.yonetmen);
	fflush(stdin);
	scanf("%d",&filmler.yil);
	
	fwrite(&filmler,sizeof(film_bilgileri),1,fp);
	fclose(fp);
	return;
}
void film_sil(){
     char filmad_temp[30];
     FILE *FilmDB;
     FILE *TempFilmDB;
     printf("\nSilmek istediðiniz filmin adýný giriniz: \n");
     scanf("%s", &filmad_temp);
     // Dosyadaki bütün kayýtlar taranýr ve silinmesini istediðimiz kayýt atlanarak geçici bir dosyaya, silinecek kayýt dýþýndakilerin hepsi yazýlýr. 
     FilmDB = fopen("filmveritabaný.dat","r");
     TempFilmDB = fopen("TempFile.dat","a");
    
     while(!feof(FilmDB))
     {
            fread(&filmler, sizeof(film_bilgileri),1,FilmDB);
            if(&filmler != NULL)
            {
                if(strcmp(filmler.film_adi,filmad_temp))
                {
                    fwrite(&filmler, sizeof(film_bilgileri),1,TempFilmDB);    
                }
                else if(strcmp(filmler.film_adi,filmad_temp))
                {
                    
                }
            }
     }printf("\nFilm baþarýyla silindi!\n");
     fclose(FilmDB);
     fclose(TempFilmDB);
     // Dosya silinir.
     remove("filmveritabaný.dat");
     // geçici dosyanýn ismi asýl dosya ismi deðiþtirilir.
     rename("TempFile.dat","filmveritabaný.dat");
}
void FilmListele(){
	//	struct filmBilgi filmsira[25],gecici;
	FILE *fp;
	fp = fopen("filmveritabaný.dat","r+");
	int k = 0;
	while(fread(&filmler,sizeof(film_bilgileri),1,fp)){
	 printf("\n%s\t%s\t%s\t%s\t%d\n",filmler.film_adi,filmler.basrol,filmler.senarist,filmler.yonetmen,filmler.yil);

		}
	
	fclose(fp);
	return;
}
 
 void Film_ara()
{
	printf("\nFilm adýna göre arama:1\n");
	printf("Filmin yayýnlanma yýlýna göre arama:2\n");
	printf("Filmin yönetmenine göre arama:3\n");
	printf("Filmin senaristine göre arama:4\n");
    printf("Filmin baþrol oyuncusuna göre arama:5\n");
    int a;
    scanf("%d" , &a);
    if(a==1)
    {
    	film_bilgileri *KullaniciObj;
		    FILE *FilmDB;
		    char isim[30];
		     
		    printf("Aramak istediginiz filmin ismini giriniz: \n");
		    scanf("%s", &isim);
		     
		    if ((FilmDB = fopen("filmveritabaný.dat","r"))==NULL){
		    	printf("Böyle Bir Dosya Bulunamadý!!");
			}
		     else{
			 
		    while(!feof(FilmDB))
		     {
		            KullaniciObj = (film_bilgileri*) malloc(sizeof(film_bilgileri));
		            fread(KullaniciObj, sizeof(film_bilgileri) - 2*sizeof(KullaniciObj), 1, FilmDB);
		            
		            printf(KullaniciObj->film_adi);
		            if(KullaniciObj != NULL)
		            {
		                if(!strcmp(KullaniciObj->film_adi, isim))
		                {
			                 printf("\nFilmin Adý:%s\n", KullaniciObj->film_adi);
			                 printf("Filmin Yönetmeni:%s\n", KullaniciObj->yonetmen);
			                 printf("Filmin Senaristi:%s\n", KullaniciObj->senarist);
			                 printf("Filmin Baþrolü:%s\n", KullaniciObj->basrol);
			                 printf("Filmin Yayýnlanma Yýlý:%d\n", KullaniciObj->yil);
			                 printf("---------------------------\n");
		                
						}
		            }
		     }
		
fclose(FilmDB);	
}
}		     
}
