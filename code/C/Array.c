#include<stdio.h>

typedef struct Array{
    int* array;
    int capacity;
    int size;
}ArrayList;


ArrayList* initArray(int n){
    ArrayList* arrayList;
    arrayList -> capacity = n;
    arrayList -> size = 0;
    for (int i = 0; i < arrayList->capacity; i++){
        arrayList->array[i] = (int)malloc(sizeof(int));
    }
    return arrayList;
}

void addLast(ArrayList* arrayList, int e) {
    if (arrayList->capacity != 0) {
        arrayList->array[arrayList->size] = e;
    } else {
        printf("your array is not initialized");
    }
}