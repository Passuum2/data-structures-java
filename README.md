# Data Structures in Java

This repository contains my completed assignments and implementations from an **Intro to Data Structures** course.  
Each section represents topics and exercises I worked on during the class, all of which I earned an **A** in.  
It serves both as a personal study reference and a portfolio of my work in Java.  

## 📂 Repository Structure & Problem Statements

### 🔹 Basic Data Structures
**Problem Statements:**
- Add method `size` to `LinkedList` class that computes the number of elements in a list.  
- Add an instance variable `currentSize` to track the size of the list.  
- Modify `add()`, `remove()`, etc. to increment or decrement `currentSize`.  
- Update `size()` to return `currentSize`.  

### 🔹 Recursion
**Problem Statements:**
- Write a recursive method for factoring an integer `n`.  
  - First, find a factor `f`, then recursively factor `n / f`.  
- Write a recursive method for computing a string with the binary digits of a number.  
  - If `n` is even, the last digit is `0`. If `n` is odd, the last digit is `1`.  
  - Recursively obtain the remaining digits.  
- Write a recursive method `String reverse(String text)` that reverses a string.  
  - Implement a recursive solution by removing the first character, reversing the remaining text, and combining the two.  

### 🔹 Sorting
**Problem Statements:**
- Modify the **Selection Sort** algorithm to sort an array of integers in **descending order**.  
- Modify the **Merge Sort** algorithm to sort an array of **strings** in **lexicographic order**.  
- Implement the **Bubble Sort** algorithm.  

### 🔹 Tree Structures
**Problem Statements:**
- Write a method that **counts leaves** in a tree.  
- Add method `countNodesWithOneChild` to the `BinaryTree` class.  
- Using the **Visitor pattern**, compute the **average value** of elements in a binary tree.  

### 🔹 Java Collections
**What It Does:**
1. Prompts the user for a **String ArrayList**, reverses it, and outputs the reversed list.  
2. Prompts the user for an **Integer**, finds its prime factors, and outputs the prime numbers.  
3. Prompts the user for an **Integer**, converts its digits into a **Stack ArrayList**, and outputs the resulting stack.  

### 🔹 Stream Processing
**Problem Statements:**
- Write a program that reads all **lines** from a file and, using a `Stream<String>`, prints how many of them contain the word `"the"`.  
- Write a program that reads all **words** from a file and, using a `Stream<String>`, prints how many of them contain the word `"the"`.  
- Write a program that reads all **lines** from a file and, using a `Stream<String>`, prints all lines containing the word `"the"`.  
- Write a program that reads all **lines** from a file and, using a `Stream<String>`, prints all distinct words with at most **four letters**.  

---

## 🚀 Getting Started
1. Clone the repository:
   ```bash
   git clone https://github.com/Passuum2/data-structures-java.git
