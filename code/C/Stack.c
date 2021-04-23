#include <stdlib.h>
#include <stdio.h>

#define false 0
#define error -1
typedef struct stack {
    int *arr;
    int top;
    int capacity;
} stack;

stack *initStack(stack *stack, int capacity) {
    stack->top = -1;
    stack->capacity = capacity;
    stack->arr = (int *) malloc(sizeof(int) * capacity);
    return stack;
}

void push(stack *stack, int e) {
    if (!stack || stack->top == stack->capacity - 1) {
        return;
    }
    stack->arr[++stack->top] = e;
}

int pop(stack *stack) {
    if (!stack || stack->top == -1) {
        return error;
    }

    int ret = stack->arr[stack->top--];
    return ret;
}

int isEmpty(stack *stack) {
    return stack->top == -1;
}

int isFull(stack *stack) {
    return stack->top == stack->capacity - 1;
}