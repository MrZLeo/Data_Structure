
#ifndef CPP_STACK_H
#define CPP_STACK_H


class stack {
private:
    int size;
    int top;
    int *arr;

public:
    stack(){
        this->size = 30;
        this->top = -1;
        this->arr = new int[size];
    }

    ~stack(){
        delete arr;
    }

    [[nodiscard]] bool isEmpty() const {
       return this->size == 0;
    }


};


#endif //CPP_STACK_H
