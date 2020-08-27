#include<stdio.h>


int main(){
    int a[10] = {0};
    int *p;
    p = &a;
    *p++ = 1;
    printf("%d", *p);
}