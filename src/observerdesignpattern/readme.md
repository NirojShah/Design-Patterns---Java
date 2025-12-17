Here is a **ready-to-use `README.md`** explaining the **Observer Design Pattern for Notification Service**, based directly on your code.

---

```md
# Observer Design Pattern – Notification Service

## Overview
The **Observer Design Pattern** defines a one-to-many dependency between objects.  
When the **Subject** changes state or sends an event, all its **Observers** are notified automatically.

In this project, a **Notification Service** acts as the **Subject**, and users (email subscribers) act as **Observers** who receive notifications.

---

## Problem Statement
We want to build a notification system where:
- Users can **subscribe** to notifications
- Users can **unsubscribe**
- All subscribers are notified when a new message is published
- The system should be easily extensible (Email, SMS, Push, etc.)

---

## Design Pattern Roles

### 1. Subject (Observable)
- Maintains a list of observers
- Provides methods to subscribe, unsubscribe, and notify observers

### 2. Observer
- Defines a common interface for all observers
- Receives updates from the subject

### 3. ConcreteObserver
- Implements the Observer interface
- Performs the actual notification logic (e.g., sending an email)

---

## Project Structure

```

src  
└── Main.java  
│  
└──observerdesignpattern  
    ├── Observer.java  
    ├── Subject.java  
    ├── EmailSubscriber.java  
    └── NotificationService.java

````

---

## Observer Interface

```java
public interface Observer {
    void update(String message);
}
````

This interface ensures that all observers implement the `update()` method.

---

## Subject Interface

```java
public interface Subject {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers(String message);
}
```

This interface defines how observers interact with the subject.

---

## Concrete Observer – Email Subscriber

```java
public class EmailSubscriber implements Observer {

    private String email;

    public EmailSubscriber(String email) {
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.println("Email sent to " + email + ": " + message);
    }
}
```

Each email subscriber receives notifications when the subject sends updates.

---

## Concrete Subject – Notification Service

```java
public class NotificationService implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
```

This class manages all subscribers and notifies them when needed.

---

## Application Flow

1. Create a `NotificationService`
2. Create observer objects (Email subscribers)
3. Subscribe observers to the notification service
4. Send notifications
5. Unsubscribe observers if needed

---

## Main Class Example

```java
public class Main {
    public static void main(String[] args) {

        NotificationService notificationService = new NotificationService();

        Observer user1 = new EmailSubscriber("user1@gmail.com");
        Observer user2 = new EmailSubscriber("user2@gmail.com");

        notificationService.subscribe(user1);
        notificationService.subscribe(user2);

        notificationService.notifyObservers("New product launched!");

        notificationService.unsubscribe(user1);

        notificationService.notifyObservers("Discount available!");
    }
}
```

---

## Output

```
Email sent to user1@gmail.com: New product launched!
Email sent to user2@gmail.com: New product launched!
Email sent to user2@gmail.com: Discount available!
```

---

## Advantages of Observer Pattern

* ✔ Loose coupling between subject and observers
* ✔ Easy to add new notification types
* ✔ Follows SOLID principles
* ✔ Promotes scalability and flexibility

---

## When to Use Observer Pattern

* Event-driven systems
* Notification services
* Messaging systems
* GUI listeners
* Stock price updates

---

## Conclusion

The Observer Design Pattern provides a clean, flexible, and scalable way to implement a notification system.
By decoupling subscribers from the notification service, the system becomes easier to maintain and extend.

---

### Author

Implementation of **Observer Design Pattern in Java**
