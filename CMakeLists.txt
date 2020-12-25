cmake_minimum_required(VERSION 3.17)
project(Data_Structure C)

set(CMAKE_C_STANDARD 11)

include_directories(code/C)

add_executable(Data_Structure code/C/Heap.c)
