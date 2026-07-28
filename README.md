PROJECT: COS 226 Practical 1
DESCRIPTION: Practical 1 exposes us to thread based multi threaded java programming by tasking us with the implementation
             of lockOne, lockTwo, and the petersonLocking algorithm.

## Table of Content
- About
- Features
- Usage
- Authors


## About

- Task:
- We were implementing an algorithm that supposedly provided mutual excluding for a 2 threaded system.
- However, only one provided proper mutual exclusion

## Features

# LockOne
- It is split into two components:
1. One that does not have deadlock
    - The shared variable is accessed at  different timeframes, thus the operating system is able to execute without an error
2. One that incurs deadlock
    - Access to shared memory is done within a loop, this create a deadlock as there will be a call from both threads trying
    - to access shared memory


# LockTwo
- It is split into two components:
1. One that is implemented sequentially 
    - This will cause a "deadlock"/wait.
    - One thread will be in the waiting stage indefinitley, as it requires another thread to be interested in the resources. This being sequential makes it impossible as one thread is supposed to execute after the other.
2. One that implements concurrently 
    - The algorithm is deadlock free, however, the last thread that sets its id to the victim variable will be in the waiting stage
    until another thread is interested in entering the critical section.

# PetersonLock
- It is split into two components:
1. One that correctly implements the petersonlock
    - This algorithm is ensures mutual exclusion and is deadlock free as it combines the strengths of the algorithms discussed above. That is: lockOne and lockTwo.
2. One that incorrectly implements the petersonlock
    - The algorithm does not guarantee mutual exclusion.
    - The following case will exist/be possible:
    a. Thread 1 assigns its variable to the victim variable. "victim = thead1.threadId()" 
    b. Before it raises it's flag, thead 2 comes in and assigns its variable to the victim variable. "victim = thead2.threadId()".
    c. Then thread 2 raises it's flag, thus the condition (flag[j] && victim==i) will result in a false. This means that it will enter the critical section.
    d. Then thread 1 continues and raises its flag, meaning that the condition (flag[j] && victim==i) will result in a false. This means that it will enter the critical section.
    e. Both thread 1 and thread 2 will be in the criitical section. 

## Installation

Clone the repository

```bash
git clone https://github.com/Mat6577/COS226_Practical1
```

Navigate to the project
```bash
cd ../COS226_Practical1
```
- Note: Ensure that you have a java compiler installed in your system
**Note:** The `Test` argument must be followed by a number from **1** to **6**. Each number corresponds to one of the following test cases:

| No. | Description |
|:---:|-------------|
| 1 | Deadlock-prone `LockOne` |
| 2 | No-deadlock `LockOne` |
| 3 | Run `LockTwo` concurrently |
| 4 | Run `LockTwo` sequentially |
| 5 | `PetersonLock` with correct initialization |
| 6 | `PetersonLock` with incorrect initialization |

Run the project
```bash
javac *.java
java test X
```