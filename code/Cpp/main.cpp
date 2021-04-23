#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <string>
#include <cstdlib>
#include <memory>
#include <cstring>
#include <map>
#include <algorithm>
#include <mutex>
#include <thread>
#include "Complex.h"
#include "linked_queue.h"
#include "vector_queue.h"



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
    while (!cq.empty()) {
        char temp = cq.dequeue();
        std::cout << temp << " ";
    }


    return 0;
}

