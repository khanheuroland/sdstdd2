package Lesson2.Stub;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ToDoTest {
    @Test
    public void should_return_a_list_of_tasks_after_remove_a_task()
    {
        //Create stub
        ITodoRepository repoStub = new TodoRepositoryStub();
        ToDo todo = new ToDo(repoStub);

        String taskToRemove = "Go to school";
        List<String> tasks = todo.removeTask(taskToRemove);

        assertThat(tasks, allOf(not(hasItem(taskToRemove)), hasItem("Go to cinema")));
    }

    @Test
    public void should_throw_exception_if_remove_unavailable_task()
    {

        ITodoRepository repoStub = new TodoRepositoryStub();
        repoStub.getListOfTasks().clear();

        ToDo todo = new ToDo(repoStub);

        String taskToRemove = "Go to school";
        Exception ex = assertThrows(IllegalArgumentException.class, ()->todo.removeTask(taskToRemove));
    }
}
