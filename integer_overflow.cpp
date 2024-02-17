#include <iostream>

int main() {
    int total = 1000;
    int amount;
    std::cout << "Enter amount: ";
    std::cin >> amount;
    total -= amount; // Underflow vulnerability if amount > total
    std::cout << "Remaining total: " << total << std::endl;
    return 0;
}
