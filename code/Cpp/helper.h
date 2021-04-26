//
// Created by MrZLeo on 2021/4/26.
//

#ifndef TEST_HELPER_H
#define TEST_HELPER_H

#include <string>
#include <iostream>

namespace helper {

    inline void assert_handler(bool check, const std::string &output) {
        if (check)
            return;
        std::cerr << output << std::endl;
        std::abort();
    }

}


#endif //TEST_HELPER_H
