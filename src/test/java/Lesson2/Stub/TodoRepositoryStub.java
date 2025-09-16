package Lesson2.Stub;

import java.util.ArrayList;
import java.util.List;

public class TodoRepositoryStub implements ITodoRepository {
    List<String> listOfTasks;
    @Override
    public List<String> getListOfTasks() {
        if(listOfTasks!=null) return listOfTasks;
        else {
            listOfTasks = new ArrayList<>();
            List<String> tasks = new ArrayList<>();
            tasks.add("Go to cinema");
            tasks.add("Go to school");

            return tasks;
        }
    }

    public void updateTasks(List<String> tasks)
    {
        this.listOfTasks = tasks;
    }
}
