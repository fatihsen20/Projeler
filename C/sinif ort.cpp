#include<stdio.h>
#define OGRSAY 10
int main()
{
	int vize1 , toplam, i ;
	float genort;
	toplam=0;
	for(i=1 ; i <= OGRSAY ; i++)
	{
		printf("%d. Ogrencinin notunu gir:" , i);
		scanf("%d" , &vize1);
		toplam= toplam + vize1 ;
	}
	genort= (float)toplam/ OGRSAY;
	printf("Ortalama: %5.2f\n", genort);
}
