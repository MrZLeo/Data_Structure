#include<stdio.h>
#include<stdlib.h>

int main(){
    int* a;
    *a = 0;
    free(a);
    printf("hello world!");
}