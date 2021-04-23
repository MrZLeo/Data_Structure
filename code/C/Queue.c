#include <stdlib.h>
#include <stdio.h>

#define error -1

struct Queue;
typedef struct Queue Queue;
struct Queue {
    int *arr;
    int head;
    int tail;
    int capacity;
};

Queue *initQueue(int capacity) {
    Queue *q = (Queue *) malloc(sizeof(struct Queue));
    q->arr = (int *) malloc(sizeof(int) * capacity);
    q->capacity = capacity;
    q->head = -1;
    q->tail = -1;
    return q;
}

void enqueue(Queue *queue, int e) {
    if (!queue || queue->tail == queue->capacity) {
        return;
    }
    queue->arr[++queue->tail] = e;
}

int deque(Queue *queue) {
    if (!queue || queue->head == queue->tail) {
        return error;
    }

    int ret = queue->arr[queue->head++];
    return ret;
}

int isEmpty(Queue *q) {
    return q->head == q->tail;
}

int getSize(Queue *queue) {
    return queue->tail - queue->head;
}

void order(Queue *q) {
    printf("Queue:\n");
    printf("head: ");
    for (int i = q->head + 1; i <= q->tail; ++i) {
        printf("%d ", q->arr[i]);
    }
    printf("\n");
    printf("tail.\n");
}
