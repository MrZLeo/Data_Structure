#include<stdio.h>

// Node store integer.
typedef struct Node{
    int element;
    Node* next;
}Node;

Node* initNode(int element){
    Node* node;
    node -> element = element;
    node -> next = NULL;
    return node;
}

int getSize(Node* node){
    int size = 0;
    while (node->next != NULL){
        size++;
    }
    return size;
}

Node* add(Node* head, int newElement){
    if (head == NULL){
        return initNode(0);
    }
    
    Node* cur = head;
    Node* newNode;
    while (cur != NULL){
        cur = head -> next;
    }
    newNode = cur -> next;
    
    return head;
}

void order(Node* head) {
    if (head == NULL) {
        return;
    }
    
    Node* cur = head;
    while (cur != NULL){
        printf("%d", cur -> element);
    }
}

void remove(Node* head, int removeElement){
    if (head == NULL){
        return;
    }
    Node* prev = head;
    
    while (prev != NULL){
        if (prev -> element == removeElement){
            Node* cur = prev -> next;
            prev -> next = cur -> next;
            free(cur);
        }
    }
}

int contains(Node* head, int e){
    if (head == NULL) {
        return NULL;
    }
    Node* cur = head;
    while (cur != NULL){
        if (cur->element == e){
            return 1;
        }
    }
    return 0;
}

int isEmpty(Node* head){
    return head == NULL;
}