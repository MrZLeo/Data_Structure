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
    if ((arrayList->capacity != 0) || (arrayList->size != arrayList->capacity)) {
        arrayList->array[arrayList->size] = e;
    } else if (arrayList->size == arrayList->capacity) {
        resize(arrayList, 2);
        arrayList->array[arrayList->size] = e;
    }
    arrayList->size++;
}

int remove(ArrayList* arrayList, int index){
    int ret = 0;
    if (arrayList->size == 0) {
        ret = -1;
    } else if (arrayList->size < index) {
        ret = -1;
    } else {
        ret = arrayList->array[index];

        for (int i = index; i < arrayList->size; i++) {
            arrayList->array[i] = arrayList->array[i+1];
        }
        arrayList->size--;
    }

    if ((arrayList->size)*2 <= arrayList->capacity){
        resize(arrayList, 0.5);
    }
    
    return ret;     
}

void resize(ArrayList* arrayList, int Times){
    int arr[(arrayList -> capacity)*Times];
    for (int i = 0; i < arrayList->size; i++){
        arr[i] = arrayList->array[i];
    }
    arrayList->array = &arr;
}