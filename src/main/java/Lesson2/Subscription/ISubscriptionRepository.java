package Lesson2.Subscription;

import java.io.FileNotFoundException;
import java.util.List;

public interface ISubscriptionRepository {
    List<String> getSubscribers();
    void saveSubcribers(List<String> subscribers);

}
