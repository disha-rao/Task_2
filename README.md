# Task_2

📌 Student Score Logger – Multithreading with File Writing

This project demonstrates how to use multithreading in Java to log student scores into a file in a thread-safe way. It also includes JUnit 5 test cases to validate the file writing logic and thread execution.

✅ Features
Stores student details (Name, Roll No, Marks)
Multiple threads write to the same file safely
synchronized is used to ensure thread-safe file writing

Includes a JUnit Test to verify:
Threads complete execution
Data is successfully written to the file

🚀 How It Works

Each student object is passed to a thread.
All threads write into the same CSV file.
logScore() is synchronized, so only one thread writes at a time.
JUnit test confirms successful writing and thread completion.

🧪 JUnit Test Features

Tests concurrent access by 2 threads
Ensures the file contains both student entries
Cleans up test file after execution
