package Lesson2.Stub;

import java.util.ArrayList;
import java.util.List;

public class TodoRepositoryStub implements ITodoRepository {
    @Override
    public List<String> getListOfTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("Go to cinema");
        tasks.add("Go to school");

        return tasks;
    }
}
