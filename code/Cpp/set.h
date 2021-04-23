//
// Created by MrZLeo on 2021/4/19.
//

#ifndef TEST_SET_H
#define TEST_SET_H

#include <vector>
#include <initializer_list>
#include <iostream>

using std::vector;

template<class T>
class set {

private:
    T *__begin_;
    T *__end_;
    size_t __size;
    size_t __capacity;

public:
    explicit set(int capacity = 10) : __capacity(capacity), __size(0) {
        __begin_ = new T[capacity];
        __end_ = __begin_ + 1;
    }

    set(const std::initializer_list<T> &list) {
        __size = 0;
        __capacity = 1.5 * list.size();
        __begin_ = new T[__capacity];

        T *temp = __begin_;
        for (auto iter = list.begin(); iter != list.end(); iter++) {
            T *begin_ = __begin_;
            for (; begin_ != temp; ++begin_) {
                if (*begin_ == *iter) {
                    break;
                }
            }
            if (begin_ != temp)
                continue;
            *temp++ = *iter;
            __size++;
        }
        __end_ = temp;
    }

    ~set() {
        delete[] __begin_;
        std::cout << "~" << std::endl;
    }

    friend std::ostream &operator<<(std::ostream &os, const set &s) {
        T *iter = s.__begin_;
        while (iter != s.__end_) {
            os << *iter++ << " ";
        }

        os << std::endl;
        return os;
    }

private:
    void _resize() {
        __capacity *= 1.5;
        T *_newBegin = new T[__capacity];
        T *temp = __begin_;

        for (int i = 0; i < __size; ++i) {
            _newBegin[i] = __begin_[i];
        }

        delete[] temp;
        __begin_ = _newBegin;
        __end_ = __begin_ + __size;
    }


public:
    [[nodiscard]] size_t size() const {
        return __size;
    }

    T *begin() const {
        return __begin_;
    }

    T *end() const {
        return __end_;
    }

    void set_move() {
        __size = 0;
        __end_ = __begin_;
    }

    void add(const T &x) {
        T *iter = __begin_;
        for (; iter != __end_; ++iter) {
            if (*iter == x)
                return;
        }
        *iter = x;
        __size++;
        __end_++;

        if (__size > (__capacity >> 1)) {
            _resize();
        }
    }

    bool contains(const T &x) const {
        for (auto iter = __begin_; iter != __end_; ++iter) {
            if (*iter == x)
                return true;
        }
        return false;
    }

    void remove(const T &x) {
        if (!contains(x))
            return;

        for (auto iter = __begin_; iter != __end_; iter++) {
            if (*iter == x) {
                for (auto temp = iter, next = temp + 1; next != __end_; ++iter) {
                    *temp++ = *next++;
                }
            }
        }
        __end_--;
        __size--;
    }

    set<T> &set_union(const set<T> &other) {
        for (auto iter = other.begin(); iter != other.end(); ++iter) {
            this->add(*iter);
        }
        return *this;
    }

    set<T> &set_union(set<T> &&other) {
        auto &ret = set_union(other);
        other.set_move();
        return ret;
    }

    set<T> &set_intersection(const set<T> &other) {
        for (int i = 0; i < __size; ++i) {
            if (!other.contains(*(__begin_ + i)))
                this->remove(*(__begin_ + i));
        }
        return *this;
    }

    set<T> &set_intersection(set<T> &&other) {
        auto &ret = set_intersection(other);
        other.set_move();
        return ret;
    }

    set<T> &set_symmetric_difference(const set<T> &other) {
        for (auto iter = other.begin(); iter != other.end(); ++iter) {
            if (this->contains(*iter))
                this->remove(*iter);
        }
        return *this;
    }

    set<T> &set_symmetric_difference(set<T> &&other) {
        set<T> &ret = set_symmetric_difference(other);
        other.set_move();
        return ret;
    }
};

using IntSet = set<int>;


#endif //TEST_SET_H
