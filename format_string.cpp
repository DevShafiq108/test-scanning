//Format String Vulnerabilities: Incorrect usage of format strings in functions 
//like printf and sprintf can lead to format string vulnerabilities, 
//allowing attackers to read or write arbitrary memory locations.

#include <iostream>

int main() {
    char user_input[100];
    std::cout << "Enter input: ";
    std::cin >> user_input;
    printf(user_input); // Potential format string vulnerability
    return 0;
}
