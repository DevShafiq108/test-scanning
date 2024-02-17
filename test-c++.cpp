#include <iostream>
#include <cstring>

int main() {
    char buffer[50];
    std::cout << "Enter your name: ";
    std::cin >> buffer;

    // Vulnerability 1: Buffer Overflow
    char greeting[50];
    strcpy(greeting, "Hello, ");
    strcat(greeting, buffer); // Potential buffer overflow if buffer is larger than greeting
    std::cout << greeting << std::endl;

    // Vulnerability 2: Integer Overflow
    unsigned int a = 4000000000; // This assignment causes an integer overflow
    std::cout << "Value of a: " << a << std::endl;

    return 0;
}
