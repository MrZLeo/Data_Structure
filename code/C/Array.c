#include <stdio.h>
#include <stdlib.h>

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

void resize_array(ArrayList *arrayList, double Times) {
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
        resize_array(arrayList, 2);
        arrayList->array[arrayList->size] = e;
    }
    arrayList->size++;
}

int remove_array(ArrayList *arrayList, int index) {
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
        resize_array(arrayList, 0.5);
    }

    return ret;
}

int main() {
    ArrayList *array = initArray(10);
    for (int i = 0; i < 10; ++i) {
        addLast(array, i);
    }
    for (int i = 0; i < 10; ++i) {
        printf("%d ", array->array[i]);
    }
    return 0;
}