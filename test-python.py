import os

# Vulnerability 1: Command Injection
def run_command(command):
    os.system("echo " + command)

# Vulnerability 2: SQL Injection
def search_user(username):
    query = "SELECT * FROM users WHERE username='" + username + "'"
    # Execute the SQL query

# Vulnerability 3: Cross-Site Scripting (XSS)
def display_message(message):
    print("<div>" + message + "</div>")

if __name__ == "__main__":
    # Test command injection vulnerability
    user_input = input("Enter a command: ")
    run_command(user_input)

    # Test SQL injection vulnerability
    user_search = input("Enter username to search: ")
    search_user(user_search)

    # Test XSS vulnerability
    user_message = input("Enter message to display: ")
    display_message(user_message)
