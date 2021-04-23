//
// Created by MrZLeo on 2021/4/23.
//

#ifndef TEST_LINKED_QUEUE_H
#define TEST_LINKED_QUEUE_H

#include <iostream>

template<class T>
class linked_queue {
public:
    linked_queue() : head(Node()), tail(&head) {}

    ~linked_queue() {
        Node *cur = head.next; // 第一个节点
        while (cur) {
            Node *prev = cur;
            cur = cur->next;
            delete prev;
        }
    }

    [[nodiscard]] bool empty() const { return head.next == nullptr; }

    T dequeue() {
        T ret = head.next->data;
        head.next = head.next->next;
        return ret;
    }

    void enqueue(const T &x) {
        tail->next = new Node(x);
        tail = tail->next;
    }

    [[nodiscard]] bool full() const { return false; }

private:
    struct Node {
        Node *next;
        T data;

        explicit Node(const T &data = NULL) : next(nullptr), data(data) {}
    };

    Node head;   //头结点，队头，单链表
    Node *tail;        //尾指针，队尾
};

namespace linked {
    using Char_queue = linked_queue<char>;
}

#endif //TEST_LINKED_QUEUE_H