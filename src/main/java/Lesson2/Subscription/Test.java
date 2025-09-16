package Lesson2.Subscription;

public class Test {
    public static void main(String[] args) {
        IEmailRepository  emailRepository = new EmailRepository();
        ISubscriptionRepository subscriberRepo = new JsonSubscriptionRepository();
        Subscription subscription = new Subscription(subscriberRepo, emailRepository);

        String email = "txk2601 @live.com";
        boolean result = subscription.subscribe(email);
        if(result)
            System.out.println("Subscribed successfully with email: "+ email);
        else
            System.out.println("Email : "+email +" already subscribed");
    }
}
