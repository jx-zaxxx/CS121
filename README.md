# CS121

Savings Management System

Description

This project is a simple savings management system developed using Java.
It allows users to manage their finances by performing basic banking operations such as depositing and withdrawing money, setting savings goals, and generating reports.

The system uses file handling to store data, ensuring that user information is saved even after the program is closed.

Features
User Registration and Login
Deposit Money
Withdraw Money
View Account Balance
Set Savings Goals
Remove Goals
View Goal Progress
Transaction History Tracking
Generate Monthly Report
Data Persistence using text files

Technologies Used
Java
JOptionPane (for GUI)
File Handling (BufferedReader, FileWriter)
Object-Oriented Programming (OOP)

How the System Works
The user registers or logs into an account.
The system loads the user's data from text files.
The user can perform actions such as:
Depositing or withdrawing money
Setting or removing goals
Viewing balance and progress
All actions update the account data.
The system saves updated data back into text files.
The user can generate a monthly report showing account details and transaction history.

Files Used
accounts.txt → stores usernames, passwords, and balances
goals.txt → stores user goals
MonthlyReport_username.txt → generated reports
(Optional) transaction data stored during runtime

How to Run the Program
Open the project in a Java IDE (e.g., Eclipse, IntelliJ).
Run the Main class.
Choose to register or log in.
Use the menu to perform different actions.

Notes
The system uses text files instead of a database.
Data is saved locally in the project folder.
Transaction history may reset if not saved to file.

Programming Paradigms Used
Object-Oriented Programming: Uses classes like Account, Goal, Transaction
Procedural Programming: Uses step-by-step menu logic
Data-Driven Programming: Uses file handling for persistent data
