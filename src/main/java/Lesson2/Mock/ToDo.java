package Lesson2.Mock;

import java.util.ArrayList;
import java.util.List;

public class ToDo {
    ITodoRepository repository;

    public ToDo(ITodoRepository repository) {
        this.repository = repository;
    }

    public List<String> removeTask(String taskToRemove) {
        List<String> lstTasks = this.repository.getListOfTasks();
        if(lstTasks.contains(taskToRemove)) {
            lstTasks.remove(taskToRemove);
            repository.saveData(lstTasks);
            return lstTasks;
        }
        else
        {
            throw new IllegalArgumentException("Task not found");
        }
    }
}
