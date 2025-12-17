import observerdesignpattern.EmailSubscriber;
import observerdesignpattern.NotificationService;
import observerdesignpattern.Observer;
import singletondesignpattern.Singleton;

public class Main {
    public static void main(String[] args) {
//        SINGLETON DESIGN PATTERN
//        Singleton obj1 = Singleton.getInstance("first class");
//        Singleton obj2 = Singleton.getInstance("second class");
//        System.out.println(obj1);
//        System.out.println(obj2);

//        OBSERVER DESIGN PATTERN
        NotificationService notification = new NotificationService();
        Observer user1 = new EmailSubscriber("nirojshah@gmail.com");
        Observer user2 = new EmailSubscriber("suraj@gmail.com");

        notification.subscribe(user1);
        notification.subscribe(user2);

        notification.notifyObserver("new product came");

        notification.unsubscribe(user1);

        notification.notifyObserver("ehh boi fooled.");

        }
    }