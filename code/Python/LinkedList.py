class LinkedList:
    class Node:
        def __init__(self, data):
            self.data = data
            self.next = None

    def __init__(self, size):
        self.root = None
        self.size = 0

    def get_size(self):
        return self.size

    def is_empty(self):
        return self.size == 0
