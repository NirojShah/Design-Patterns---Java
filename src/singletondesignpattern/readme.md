# Singleton Design Pattern in Java

## Overview

The **Singleton Design Pattern** ensures that a class has **only one instance** throughout the lifecycle of an application and provides a **global access point** to that instance.

This pattern is commonly used when exactly one object is needed to coordinate actions across the system, such as:

* Configuration managers
* Database connections
* Logging services
* Caching mechanisms

---

## Problem It Solves

Without a Singleton:

* Multiple objects of the same class may be created
* Shared resources can be corrupted or misused
* Extra memory and processing overhead occurs

The Singleton pattern:

* Restricts instantiation to a single object
* Ensures controlled access to that object
* Supports thread-safe initialization

---

## Implementation Example

```java
package singletondesignpattern;

public class Singleton {
    public static volatile Singleton instance;
    private String data;

    private Singleton(String data) {
        this.data = data;
    }

    public static Singleton getInstance(String data) {
        Singleton result = instance;
        if (result == null) {
            synchronized (Singleton.class) {
                if (result == null) {
                    instance = result = new Singleton(data);
                }
            }
        }
        return result;
    }
}
```

---

## Key Concepts Explained

### 1. Private Constructor

```java
private Singleton(String data) { ... }
```

* Prevents creating objects using the `new` keyword
* Ensures the class controls its own instantiation

---

### 2. Static Instance Variable

```java
public static volatile Singleton instance;
```

* `static` ensures one shared instance across the JVM
* `volatile` guarantees visibility of changes across threads

---

### 3. Lazy Initialization

* The instance is created **only when required**
* Saves memory and resources

```java
if (result == null) { ... }
```

---

### 4. Thread Safety (Double-Checked Locking)

```java
if (result == null) {
    synchronized (Singleton.class) {
        if (result == null) {
            instance = result = new Singleton(data);
        }
    }
}
```

* Avoids unnecessary synchronization after initialization
* Ensures only one thread creates the instance
* Improves performance compared to full synchronization

---

### 5. Global Access Point

```java
public static Singleton getInstance(String data)
```

* Provides controlled access to the single instance
* Always returns the same object after creation

---

## Important Characteristics

1. **Thread-safe** – Safe in multi-threaded environments
2. **Single Instance** – Only one object exists
3. **Lazy Loading** – Created only when needed
4. **Controlled Access** – Centralized object creation

---

## Usage Example

```java
public class Main {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance("First");
        Singleton s2 = Singleton.getInstance("Second");

        System.out.println(s1 == s2); // true
    }
}
```

Even though different data is passed, the same instance is reused.

---

## When to Use Singleton

* When exactly **one instance** is required
* When shared access to a resource is needed
* When object creation is expensive

---

## When NOT to Use Singleton

* When testing requires multiple instances (hard to mock)
* When global state introduces tight coupling
* When scalability and flexibility are priorities

---

## Summary

✔ Ensures a single instance of a class
✔ Supports multi-threaded environments
✔ Provides global access
✔ Prevents uncontrolled object creation

The Singleton pattern is powerful but should be used **judiciously** to avoid design issues caused by global state.

---

**Author:** Java Design Patterns
**Pattern Type:** Creational Design Pattern
