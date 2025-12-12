# Payroll Management System - Refactoring Project

This repository contains the **refactored version** of a legacy Payroll Management System application. This project is part of the **COMP6106001 - Code Reengineering** course assignment.

# Our Group :
1. 2702369516 - MUHAMMAD ASLAM SIDDIQ
2. 2702376635 - PUTU JEYAN WAHYUDA
3. 2702379012 - MIKHAEL VICTOR SIAGIAN

## 📂 Original Source (Legacy Code)
The original code was retrieved from an open-source repository containing several "Code Smells" used as a case study for this refactoring project. The primary issues identified were **Long Parameter List** and **Data Clumps**.

*   **Original Repository:** [Employee_Payroll_Management_System by KandukuriAchala05](https://github.com/KandukuriAchala05/Employee_Payroll_Management_System)
*   **Target File (Smelly Code):** [PayrollSystem.java (Permalink)](https://github.com/KandukuriAchala05/Employee_Payroll_Management_System/blob/1b0cbac5c223fde88b9aa808bdbe78573182bf0f/PayrollSystem.java)

## 🛠️ Refactoring Changes
The original code suffered from poor data organization, with long constructors and related data fields scattered as primitive types.

**Key Improvements:**
1.  **Extract Class:** Solved the *Long Parameter List* and *Data Clumps* issues by extracting related banking information (`bankName`, `accountNumber`, `ifscCode`) into a new `BankAccount` class. This reduced the constructor parameters and increased data cohesion.
2.  **Replace Magic Number with Constant:** Replaced hardcoded numerical values (e.g., `0.2`, `2500`) in the salary calculation with named constants (e.g., `HRA_PERCENTAGE`) to improve readability and maintainability.
3.  **Modularization (Move Class):** Split the single monolithic file into separate, well-defined classes (`Employee.java`, `NewEmployee.java`, `BankAccount.java`, `PayrollSystem.java`) to adhere to Java's standard project structure.
