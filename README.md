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

* Knowledge on syntax and implementation of simple threads.
* Theoretical understanding of threads and their random relationship to the scheduler.
* Discovered the main thread and that it will always regain control after child thread(s) complete.

## Shared Data
### Explanation

A basic program with two threads sharing a single variable.
A volatile variable counter is initialized at 0.
Two threads, A and B, are created.
Each thread adds 1 to the counter 10 million times.
The main thread then regains control and prints the counter value.

The reason for the program is to understand the randomness and unpredictability of poor thread implementation.
Each run of the program yields a different result, and the correct counter value of 20 million is rarely achieved.

### Learning outcomes

* Discovered volatile keyword can be used to store a variable in main memory as opposed to the cpu cache.
* Practical and theoretical understanding of the concequences of poor thread scheduling.
* One potential reason the counter may be off is because during one threads execution, its timer execution went off mid exeuction. If the variable was 50 to begin with, 1 was added, but wasn't saved, the variable is still 50. The other thread will grab 50 instead of 51.
Thread 2 adds 1 and saves 51. When thread 1 resumes, it will overwrite 51 with 51.
* This problem is known as a race condition or data race. The result depends on the timing execution of the code.
* This is an indeterminate result, unknown and likely to be different each run. As opposed to deterministic
* This code is known as a critical section as it accesses a shared resource, and must not be concurrently executed by more than one thread.
* The solution is mutual exclusion. If one thread is executing with a critical section, other threads are preventing from doing so.
* Edsger Dijkstra completed work on this in 1968 in his paper, Cooperating Sequential Processes.

## Locks
### Explanation

A basic program with two threads sharing a single variable.
A volatile variable counter is initialized at 0.
Two threads, A and B, are created.
Each thread adds 1 to the counter 10 million times. This is the critical section.
The critical section is surrounded by a lock and is unlocked after the counter is incremented.
The main thread then regains control and prints the counter value.
The final result is 20 million as expected.

The reason for the program is to understand the purpose of locks and appreciate their value.
Each run of the program yields the same result. The correct counter value of 20 million is always achieved.

### Learning outcomes

* Discovered a single lock object needs to be used for one piece of data. The lock should be passed in through the threads constructor.
* Locks are in one of two states. Available/Unlocked/Free or Acquired/Locked/Held.
* Locks provide the programmer some control over scheduling as opposed to relying on the operating system.
* The try block allows allows the critical section to only be accessed if the lock is free.
* The finally block allows the lock to be released after the critical section has been processed.