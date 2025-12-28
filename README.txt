Deadlock Detection in Wait-For Graph - DSA Project
Project Title
Deadlock Detection in Process Scheduling using Wait-For Graph
Project Overview
This project implements a Java program to detect deadlocks in operating systems using the Wait-For Graph concept. A deadlock occurs when a set of processes form a circular wait for resources, represented as a cycle in a directed graph.
The program:

Models processes as nodes in a directed graph.
Uses adjacency list representation for the Wait-For Graph.
Allows users to input the number of processes and wait-for dependencies (directed edges).
Detects whether a deadlock exists by checking for cycles in the graph using Depth-First Search (DFS).
If a cycle is found, it displays one example cycle involving the deadlocked processes.
Includes pre-defined test cases for automatic demonstration.

This project demonstrates core Data Structures and Algorithms concepts:

Graphs (Directed Graph, Adjacency List)
Depth-First Search (DFS) for cycle detection

All implementations strictly adhere to the DSA syllabus (Unit VI: Graphs and Graph Algorithms).
Features

Interactive menu-driven input for custom Wait-For Graphs.
Supports large number of processes (tested up to 150+).
Accurate cycle detection with path printing.
Clear console output showing the graph and results.
Built-in test cases:
One with deadlock (circular dependency)
One without deadlock (safe linear chain)


Project Structure
textDSA_Project_Deadlock_Detection/
├── Process.java                  // Class representing a Process (ID and Name)
├── WaitForGraph.java             // Core graph implementation with cycle detection
├── DeadlockDetector.java         // Main class with user input and test cases
├── README.txt (or README.md)     // This file - Project documentation
└── Screenshots/                  // Folder containing execution screenshots
    ├── screenshot_custom_safe.png
    ├── screenshot_deadlock_custom.png
    ├── screenshot_test_case_1.png
    ├── screenshot_test_case_2.png
    └── ...

Key Algorithm: Cycle Detection using DFS

Uses recursion stack tracking (recStack array).
Detects back edges to nodes in the current recursion stack.
Extracts and prints one complete cycle path when found.

Syllabus Relevance

Unit VI: Graphs and Graph Algorithms
Adjacency List representation
Depth-First Search (DFS)
Real-life application of graphs (resource allocation in OS)


No topics outside the syllabus are used.
All execution screenshots are included in the Screenshots/ folder for demonstration in the project report (Section IX).
Developer: Yagya Sharma
Date: December 20, 2025
Course: Data Structures and Algorithms (Java)