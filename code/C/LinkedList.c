#include<stdio.h>
#include<stdlib.h>

#define true 1
#define false 0
#define error -1

// Node store integer.
struct Node;
typedef struct Node Node;
typedef struct Node {
    int element;
    Node *next;
} Node;

// linked list
typedef struct LinkedList {
    Node *head;
    int size;
} LinkedList;

Node *initNode(int e);

Node *getNode(Node *list, int e);

LinkedList *initLinkedList(int e);

void add(LinkedList *list, int newElement);

void order(LinkedList *list);

void removeElement(LinkedList *list, int removeElement);

int contains(LinkedList *list, int e);

int isEmpty(LinkedList *list);

Node *initNode(int e) {
    Node *head = (Node *) malloc(sizeof(Node));
    head->element = e;
    head->next = NULL;
    return head;
}

Node *getNode(Node *list, int e) {
    Node *newNode = (Node *) malloc(sizeof(Node));
    newNode->element = e;
    newNode->next = NULL;
    return newNode;
}

LinkedList *initLinkedList(int e) {
    LinkedList *linkedList = (LinkedList *) malloc(sizeof(LinkedList));
    linkedList->head = initNode(e);
    linkedList->size = 1;
    return linkedList;
}

void add(LinkedList *list, int newElement) {
    if (!list) {
        list = initLinkedList(newElement);
    }

    Node *cur = list->head;
    while (cur->next != NULL) {
        cur = cur->next;
    }
    cur->next = getNode(cur, newElement);
    list->size++;
}

void order(LinkedList *list) {
    if (list == NULL) {
        return;
    }

    Node *cur = list->head;
    printf("LinkedList:\n");
    while (cur != NULL) {
        printf("%d ", cur->element);
        cur = cur->next;
    }
}

void removeElement(LinkedList *list, int removeElement) {
    if (list == NULL) {
        return;
    }
    Node *prev = list->head;

    while (prev->next != NULL) {
        if (prev->next->element == removeElement) {
            Node *cur = prev->next;
            prev->next = cur->next;
            free(cur);
            list->size--;
        }
        prev = prev->next;
    }
}

int contains(LinkedList *list, int e) {
    if (list == NULL) {
        return false;
    }
    Node *cur = list->head;
    while (cur != NULL) {
        if (cur->element == e) {
            return true;
        }
        cur = cur->next;
    }
    return false;
}

int isEmpty(LinkedList *list) {
    return (list->size) == 0;
}
