package Lesson2.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Subscription {
    ISubscriptionRepository repository;
    IEmailRepository emailRepository;
    public Subscription(){}
    public Subscription(ISubscriptionRepository subscriptionRepository,
                        IEmailRepository emailRepository) {
        this.repository = subscriptionRepository;
        this.emailRepository = emailRepository;
    }
    public boolean subscribe(String email) {
        if(!validateEmail(email))
        {
            throw new IllegalArgumentException("Email is invalid!");
        }
        else
        {
            List<String> lstEmails =repository.getSubscribers();
            if(!lstEmails.contains(email))
            {
                lstEmails.add(email);
                repository.saveSubcribers(lstEmails);
                emailRepository.sendWelcomeEmail(email);
                return true;
            }
            return false;
        }
    }

    private boolean validateEmail(String email) {
        String emailReg = "^[a-zA-Z0-9._]+@\\w+(\\.\\w{2,}){1,2}$";
        Pattern pattern = Pattern.compile(emailReg);
        return pattern.matcher(email).find();
    }
}
