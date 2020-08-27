#include "Array.h"
#include <stdio.h>


typedef struct stack{
    //ArrayList arr;
    int size;
}stack;

stack* initStack(stack* stack){
    stack->size = 0;
    return &stack;
}
