package Lesson2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ToDo {
    private List<String> tasks;
    private List<String> completedTasks;
    private static ToDo instance;
    private ToDo() {
        tasks = new ArrayList<>();
        completedTasks = new ArrayList<>();
    }

    public static ToDo getInstance()
    {
        if(instance == null)
            instance = new ToDo();
        return instance;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public Boolean addTask(String task) {
        if(validateTaskName(task)) {
            if (tasks.contains(task))
                return false;

            tasks.add(task);
            return true;
        }
        else
        {
            throw new IllegalArgumentException("Invalid task name");
        }
    }

    private boolean validateTaskName(String task)
    {
        if(task.isEmpty()) return false;

        Pattern pattern = Pattern.compile("[!@#\\$%\\^\\&\\*]");
        return !pattern.matcher(task).find();
    }

    public boolean removeTask(String task) {
        if(tasks.contains(task))
        {
            tasks.remove(task);
            return true;
        }
        return false;
    }

    public void removeTasks() {
        tasks.clear();
    }

    public void completeTask(String task) {
        if(tasks.contains(task)) {
            tasks.remove(task);
            completedTasks.add(task);
        }
        else {
            throw new IllegalArgumentException("Unable to complete unavailable task");
        }
    }
}
