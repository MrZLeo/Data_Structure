cmake_minimum_required(VERSION 3.15)
project(Array)
project(Stack)
project(LinkedList)
set(CMAKE_C_STANDARD 11)

add_executable(Array Basic.h Array.c)
add_executable(Stack Basic.h stack.c)
add_executable(LinkedList Basic.h LinkedList.c)