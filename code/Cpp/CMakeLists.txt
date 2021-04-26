cmake_minimum_required(VERSION 3.17)
project(Cpp)
project(leetCode)
project(test)

set(CMAKE_CXX_STANDARD 20)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -fsanitize=leak -g")


add_executable(Cpp main.cpp stack.cpp stack.h Complex.cpp Complex.h RB_Tree.h linked_queue.h vector_queue.h helper.h)
add_executable(leetCode Solution.cpp)
add_executable(test test.cpp set.h)
