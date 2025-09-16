package Lesson2.Stub;

import java.util.List;

public class ToDo {
    ITodoRepository repository;

    public ToDo(ITodoRepository repository) {
        this.repository = repository;
    }


    public List<String> removeTask(String taskToRemove) {
        List<String> tasks = repository.getListOfTasks();
        if (tasks.contains(taskToRemove)) {
            tasks.remove(taskToRemove);
            return tasks;
        }
        else {
            throw   new IllegalArgumentException("Task does not exist");
        }
    }
}
