cmake_minimum_required(VERSION 3.15)
project(c_program)
set(CMAKE_C_STANDARD 11)

add_executable(c_program Basic.h Array.c stack.c LinkedList.c)
