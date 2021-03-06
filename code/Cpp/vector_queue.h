//
// Created by MrZLeo on 2021/4/23.
//

#ifndef TEST_VECTOR_QUEUE_H
#define TEST_VECTOR_QUEUE_H

#include "linked_queue.h"
#include "helper.h"

template<class T>
class vector_queue {
public:
    explicit vector_queue(size_t capacity = default_capacity)
            : capacity(capacity), queue(new T[capacity]), head(0), tail(0) {}

    ~vector_queue() { delete[] queue; }

    [[nodiscard]] bool empty() const { return head == tail; }

    T dequeue() {
        helper::assert_handler(!empty(), "Dequeue called with empty vector queue");

        T ret = queue[head];
        head = (head + 1) % capacity;
        return ret;
    }

    void enqueue(const T &x) {
        if (full()) {
            std::cout << "full!" << std::endl;
            return;
        }
        queue[tail] = x;
        tail = (tail + 1) % capacity;
    }

    [[nodiscard]] bool full() const { return head == (tail + 1) % capacity; }


private:
    static const size_t default_capacity;
    T *queue;                   //循环队列
    size_t head, tail;
    const size_t capacity;
};


namespace vec {
    using Char_queue = vector_queue<char>;
}

template<typename T>
const size_t vector_queue<T>::default_capacity = 32;


#endif //TEST_VECTOR_QUEUE_H
