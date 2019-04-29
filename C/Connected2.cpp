#include <stdio.h>
int birfazla(int sayi);
int uckat(int sayi);
float yarisi(int sayi);
int main(){
	int girdi;
	girdi=1;
	while(girdi!=0){
		printf("===========Cikmak Icin 0'a Basiniz==========\n");
		printf("Lutfen bir sayi giriniz:");
		scanf("%d",&girdi);
		if(girdi!=0){
		birfazla(girdi);
		uckat(birfazla(girdi));
		printf("%0.2f\n",yarisi(uckat(birfazla(girdi))));
		}
}
}
int birfazla(int sayi){
	return sayi=sayi+1;
}
int uckat(int sayi){
	return sayi*=3;
}
float yarisi(int sayi){
	float x=float(sayi)/2;
	return x;
}
