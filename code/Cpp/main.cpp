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


using std::vector;
using std::map;
using std::string;
using std::stack;

class Father {
private:
    int f1;
    int f2;
public:
    Father(int f1, int f2) : f1(f1), f2(f2) {}

    virtual void print() = 0;
};

class Son : public Father {
private:
    int s;
public:
    Son(int f1, int f2, int score) : Father(f1, f2), s(score) {}

    void print() override {
        std::cout << "son" << std::endl;
    }
};
using namespace std;

int main() {
    char str[] = "world"; cout << sizeof(str) << ": ";
    char *p  = str;   cout << sizeof(p) << ": ";
    char i  = 10;   cout << sizeof(i) << ": ";
    void *pp  = malloc(10); cout << sizeof(pp) << endl;

    return 0;
}

