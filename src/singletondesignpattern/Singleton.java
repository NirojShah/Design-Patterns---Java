package singletondesignpattern;

public class Singleton {
    public static volatile Singleton instance;
    private String data;
    private Singleton(String data){
        this.data = data;
    }
    public static Singleton getInstance(String data) {
        Singleton result = instance;
        if (result == null) {
            synchronized (Singleton.class) {
                if (result == null) {
                    instance = result = new Singleton((data));
                }

            }
        }
        return result;
    }

}


// INFO -
//Singleton Design Pattern -
//1. its code needs to be adapted to handle multiple threads
//2. should be used when a class must have a single instance available
//3. returns the existing instance if it has already been created
//4. disables all means of creating objects of a class except for the special static creation method