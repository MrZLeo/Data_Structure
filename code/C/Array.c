#include "Basic.h"

typedef struct Array {
    int *array;
    int capacity;
    int size;
} ArrayList;


ArrayList *initArray(int n) {
    ArrayList *arrayList = (ArrayList *) malloc(sizeof(ArrayList));
    arrayList->capacity = n;
    arrayList->size = 0;
    arrayList->array = (int *) malloc(sizeof(int) * arrayList->capacity);
    return arrayList;
}

void resizeArray(ArrayList *arrayList, double Times) {
    int arr[(int) ((arrayList->capacity) * Times)];
    for (int i = 0; i < arrayList->size; i++) {
        arr[i] = arrayList->array[i];
    }
    arrayList->array = arr;
}

void addLast(ArrayList *arrayList, int e) {
    if ((arrayList->capacity != 0) || (arrayList->size != arrayList->capacity)) {
        arrayList->array[arrayList->size] = e;
    } else if (arrayList->size == arrayList->capacity) {
        resizeArray(arrayList, 2);
        arrayList->array[arrayList->size] = e;
    }
    arrayList->size++;
}

int removeArray(ArrayList *arrayList, int index) {
    int ret = 0;
    if (arrayList->size == 0) {
        ret = -1;
    } else if (arrayList->size < index) {
        ret = -1;
    } else {
        ret = arrayList->array[index];

        for (int i = index; i < arrayList->size; i++) {
            arrayList->array[i] = arrayList->array[i + 1];
        }
        arrayList->size--;
    }

    if ((arrayList->size) * 2 < arrayList->capacity) {
        resizeArray(arrayList, 0.5);
    }

    return ret;
}

int contains(ArrayList *list, int e) {
    for (int i = 0; i <= list->size; ++i) {
        if (list->array[i] == e) {
            return true;
        }
    }
    return false;
}

int isEmpty(ArrayList* list){
    return list->size == 0;
}

int main() {
    ArrayList *array = initArray(10);
    for (int i = 0; i < 10; ++i) {
        addLast(array, i);
    }
    for (int i = 0; i < 10; ++i) {
        contains(array, i+1);
    }

    return 0;
}