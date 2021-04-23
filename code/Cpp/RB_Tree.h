//
// Created by MrZLeo on 2021/3/29.
//

#ifndef LEETCODE_RB_TREE_H
#define LEETCODE_RB_TREE_H

#include <string>

using std::string;

template<typename K, typename V>
class RB_Tree {
private:
    enum class Color {
        RED, BLACK
    };

    struct Node {
        K key;
        V value;
        Node *left;
        Node *right;

        Color color;

        Node(K key, V value) : key(key), value(value), left(nullptr), right(nullptr), color(Color::RED) {}

        explicit Node(Node *node) {
            this->key = node->key;
            this->value = node->value;
            this->left = node->left;
            this->right = node->right;
            this->color = node->color;
        }
    };

    Node *root;
    int size;

public:
    explicit RB_Tree() : root(nullptr), size(0) {}

    ~RB_Tree() {
        destroy(root);
    };

    int size() {
        return size;
    }

    bool empty() {
        return size == 0;
    }

    bool isRed(Node *node) {
        return (node != nullptr) && (node->color == Color::RED);
    }

    void add(K key, V value) {
        root = add(root, key, value);
        root->color = Color::BLACK;
    }

    bool contains(K key) {
        return getNode(root, key) != nullptr;
    }

    V &get(K key) {
        Node *target = getNode(root, key);
        return target == nullptr ? nullptr : &(target->value);
    }

    void set(K key, V newValue) {
        Node *node = getNode(root, key);
        node && (node->value = newValue);
    }

private:
    void destroy(Node *node) {
        if (!node)
            return;

        destroy(node->left);
        destroy(node->right);
        delete node;
    }

    Node *add(Node *node, K key, V value) {
        if (!node) {
            size++;
            return new Node(key, value);
        }

        if (key > node->key) {
            node->right = add(node->right, key, value);
        } else if (key < node->key) {
            node->left = add(node->left, key, value);
        }
    }

    Node *getNode(Node *node, K key) {
        if (!node)
            return nullptr;

        if (key < node->key)
            return getNode(node->left, key);
        else if (key > node->key)
            return getNode(node->right, key);
        else
            return node;
    }


};


#endif //LEETCODE_RB_TREE_H
