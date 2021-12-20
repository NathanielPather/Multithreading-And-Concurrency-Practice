# Multithreading and Concurrency Practice

This is a project where I practice concurrency and multithreading in java.

## Introduction
### Explanation
A basic program with two threads.
Each thread is passed a string, "a" or "b", along with a sleep duration.
Before printing the string in each thread, the thread sleeps.
The main thread then regains control.

The reason for the sleep is to see how threads play out.
The sleep parameter can be removed to show how threads can be random and dependent on the scheduler.
The join() method is also used to wait for completion of a thread before proceeding.

### Learning outcomes

Knowledge on syntax and implementation of simple threads.
Theoretical understanding of threads and their random relationship to the scheduler.
Discovered the main thread and that it will always regain control after child thread(s) complete.