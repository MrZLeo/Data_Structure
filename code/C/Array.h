#ifndef _ARRAY_H_
#define _ARRAY_H_
typedef struct Array ArrayList;

ArrayList* initArray(int n);
void addLast(ArrayList* arrayList, int e);
#endif
