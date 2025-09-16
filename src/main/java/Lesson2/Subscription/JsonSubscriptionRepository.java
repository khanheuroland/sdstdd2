package Lesson2.Subscription;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonSubscriptionRepository implements ISubscriptionRepository{
    @Override
    public List<String> getSubscribers() {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<String>>() {}.getType();

        FileReader reader = null;
        try {
            reader = new FileReader("C:\\TDD\\subscriber.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<String> subscribers = gson.fromJson(reader, listType);

        return subscribers;
    }

    @Override
    public void saveSubcribers(List<String> subscribers) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter("C:\\TDD\\subscriber.json")) {
            gson.toJson(subscribers, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
