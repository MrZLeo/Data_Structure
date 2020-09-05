#ifndef _ARRAY_H_
#define _ARRAY_H_

struct Array;
typedef struct Array ArrayList;

ArrayList* initArray(int n);
void addLast(ArrayList* arrayList, int e);
int isEmpty(ArrayList* list);
int contains(ArrayList *list, int e);
int removeArray(ArrayList *arrayList, int index);
void resizeArray(ArrayList *arrayList, double Times);

#endif
