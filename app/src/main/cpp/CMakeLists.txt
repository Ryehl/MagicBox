# 版本
cmake_minimum_required(VERSION 3.18.1)

# project 名字
project("testnamespace")

add_library(
    testnamespace

    SHARED

    native-lib.cpp
)

find_library(
log-lib
log
)


target_link_libraries(
        testnamespace
        ${log-lib})