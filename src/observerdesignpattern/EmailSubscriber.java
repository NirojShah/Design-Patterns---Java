package observerdesignpattern;

public class EmailSubscriber implements Observer {
    private String email;
    public EmailSubscriber(String email){
        this.email = email;
    }
    @Override
    public void update(String message) {
        System.out.println("Email send to " + email + " : " + message);
    }

    public String getEmail(){
        return email;
    }
}
