#include<stdio.h>
int main()
{
	int vize1, Toplam , i;
	float GenOrt;
	Toplam=0;
	for(i=1 ; i<=8; i++)
	{
		printf("%d. Ogrencinin notunu gir:" , i);
		scanf("%d" , &vize1);
		Toplam= Toplam + vize1;
	 } 
	 GenOrt=(float)Toplam/8;
	 printf("Ortalama: %5.2f\n", GenOrt);
}

