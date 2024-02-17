#include <iostream>
#include <cstdlib>

int main() {
    char *ptr = (char *)malloc(10);
    strcpy(ptr, "Hello, world!");
    std::cout << ptr << std::endl;
    free(ptr); // Memory is freed, but ptr is not set to NULL
    return 0;
}
