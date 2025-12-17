package observerdesignpattern;

import java.util.ArrayList;

public class NotificationService implements Subject {
    private ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(String message) {
        for(Observer observer: observers){
            observer.update(message);
        }
    }
}
