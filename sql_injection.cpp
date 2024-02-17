#include <iostream>
#include <cstring>

int main() {
    char username[50];
    std::cout << "Enter username: ";
    std::cin >> username;
    char query[100];
    sprintf(query, "SELECT * FROM users WHERE username='%s'", username);
    std::cout << "Query: " << query << std::endl;
    return 0;
}
