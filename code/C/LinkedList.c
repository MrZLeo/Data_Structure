#include<stdio.h>

// Node store integer.
typedef struct Node{
    int element;
    Node* next;
}Node;

typedef struct LinkedList{
    Node* head;
    int size;
}LinkedList;

Node* initNode(int e){
    Node* node;
    node -> element = e;
    node -> next = NULL;
}

Node* getNode(Node* node, int e){
    Node* newNode = (Node*)malloc(sizeof(Node));
    node -> next = newNode;
    newNode -> element = e;
    newNode -> next = NULL;
}

LinkedList* initLinkedList(int e){
    LinkedList* linkedList = (LinkedList*)malloc(sizeof(LinkedList));
    linkedList -> head = initNode(e);
    linkedList -> size = 0;
    return linkedList;
}

void add(LinkedList* list, int newElement){
    Node* cur = list -> head;
    while (cur != NULL){
        cur = cur -> next;
    }
    cur -> next = getNode(cur, newElement);
    list -> size++;
}

void order(LinkedList* list) {
    if (list == NULL) {
        return;
    }
    
    Node* cur = list -> head;
    while (cur != NULL){
        printf("%d", cur -> element);
    }
}

void remove(LinkedList* list, int removeElement){
    if (list == NULL){
        return;
    }
    Node* prev = list -> head;
    
    while (prev != NULL){
        if (prev -> element == removeElement){
            Node* cur = prev -> next;
            prev -> next = cur -> next;
            free(cur);
            list -> size--;
        }
    }
}

int contains(LinkedList* list, int e){
    if (list == NULL) {
        return NULL;
    }
    Node* cur = list->head;
    while (cur != NULL){
        if (cur->element == e){
            return 1;
        }
    }
    return 0;
}

int isEmpty(LinkedList* list){
    return list -> size == NULL;
}