//// Created by MrZLeo on 2020/12/25.//#include <stdlib.h>#include <stdio.h>typedef struct heap {    int size;    int capacity;    int *tree;} *Heap;int parent(int child) {    return child >> 1;}int leftChild(int parent) {    return parent << 1;}void swap(int *a, int *b) {    int temp = *a;    *a = *b;    *b = temp;}void shiftDown(Heap heap, int p) {    for (int child = leftChild(p); child < heap->size; child = leftChild(child)) {        if (child != heap->size && heap->tree[child] > heap->tree[child + 1]) {            ++child;        }        if (heap->tree[child] > heap->tree[p])            break;        swap(&heap->tree[child], &heap->tree[p]);        p = child;    }}Heap heapify(const int *arr, int size) {    Heap p = calloc(1, sizeof(struct heap));    p->size = size;    p->tree = calloc(size + 1, sizeof(int));    p->capacity = size + 1;    for (int i = 0; i < size; ++i) {        p->tree[i + 1] = arr[i];    }    p->tree[0] = INT32_MIN; // 哨兵    for (int i = size; i > 0; --i) {        shiftDown(p, i);    }    return p;}void insert(Heap heap, int val) {    if (heap->capacity == heap->size + 1)        return;    int i = ++heap->size;    for (; heap->tree[parent(i)] > val; i = parent(i)) {        heap->tree[i] = heap->tree[parent(i)];    }    heap->tree[i] = val;}int deque(Heap heap) {    int ret = heap->tree[1];    heap->tree[1] = heap->tree[heap->size--];    shiftDown(heap, 1);    return ret;}int main() {    int arr[10] = {9, 8, 7, 6, 5, 4, 3, 2, 1};    Heap p = heapify(arr, 9);    for (int i = 1; i <= p->size; ++i) {        printf("%d ", p->tree[i]);    }    printf("\n");    printf("%d\n", deque(p));    for (int i = 1; i <= p->size; ++i) {        printf("%d ", p->tree[i]);    }    printf("\n");    printf("%d\n", deque(p));    printf("%d\n", deque(p));    printf("%d\n", deque(p));    for (int i = 1; i <= p->size; ++i) {        printf("%d ", p->tree[i]);    }    insert(p, -1);    printf("\n");    for (int i = 1; i <= p->size; ++i) {        printf("%d ", p->tree[i]);    }    return 0;}