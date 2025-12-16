import singletondesignpattern.Singleton;

public class Main {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance("first class");
        Singleton obj2 = Singleton.getInstance("second class");
        System.out.println(obj1);
        System.out.println(obj2);
        }
    }