#include <iostream>
#include "linked_queue.h"
#include "vector_queue.h"
#include <list>

int main() {
    linked::Char_queue charQueue;
    charQueue.enqueue('1');
    charQueue.enqueue('2');
    charQueue.enqueue('3');
    charQueue.enqueue('4');
    charQueue.enqueue('5');
    charQueue.enqueue('6');
    charQueue.enqueue('7');
    charQueue.enqueue('8');
    while (!charQueue.empty()) {
        char temp = charQueue.dequeue();
        std::cout << temp << " ";
    }
//
//    charQueue.dequeue();
//    charQueue.dequeue();
//    charQueue.dequeue();
//    charQueue.dequeue();
//    charQueue.dequeue();
//    charQueue.dequeue();
    std::cout << std::endl;

    vec::Char_queue cq;
    cq.enqueue('1');
    cq.enqueue('2');
    cq.enqueue('3');
    cq.enqueue('4');
    cq.enqueue('5');
    cq.enqueue('6');
    cq.enqueue('7');
    cq.enqueue('8');
    for (int i = 0; i < 39; ++i) {
        cq.enqueue('1');
    }
    while (!cq.empty()) {
        char temp = cq.dequeue();
        std::cout << temp << " ";
    }
    cq.enqueue('a');
    cq.dequeue();
    cq.dequeue();
    cq.dequeue();
    cq.dequeue();
    cq.dequeue();
    cq.dequeue();
    cq.dequeue();
    cq.dequeue();

    std::list<int> l;

    return 0;
}

