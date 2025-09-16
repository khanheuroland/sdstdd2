package Lesson2.Mock;

import java.util.List;

public interface ITodoRepository {
    List<String> getListOfTasks();
    void saveData(List<String> tasks);
}
