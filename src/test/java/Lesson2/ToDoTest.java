package Lesson2;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ToDoTest {
    ToDo todo;
    @BeforeEach
    public void setupTest()
    {
        todo = ToDo.getInstance();
        todo.removeTasks();
    }

    @Test
    public void should_return_all_of_tasks() {
        List<String> lstTasks = todo.getTasks();
        assertThat(lstTasks, is(empty()));
    }

    @Nested
    @Tag("addTask")
    class addTask {
        @Test
        public void should_return_true_after_add_task_successfully() {
            //Arrage
            String task = "Go To School";
            Boolean expected = true;

            //Act
            Boolean actual = todo.addTask(task);

            //Assert
            assertThat(actual, is(expected));
            assertThat(todo.getTasks(), hasItem(task));
        }

        @Test
        public void should_return_false_after_add_duplicated_task() {
            String task = "Go To School";
            Boolean expected = false;

            //Act
            todo.addTask(task);
            Boolean actual = todo.addTask(task);

            assertThat(actual, is(expected));
            assertThat(todo.getTasks(), hasSize(1));
        }

        @Test
        public void should_return_exception_for_invalid_task_name() {
            String task = "Go To $# School";

            Exception ex = assertThrows(IllegalArgumentException.class, () -> todo.addTask(task));

            assertThat(ex.getMessage(), is("Invalid task name"));
            assertThat(todo.getTasks(), not(hasItem(task)));
        }

        @Test
        public void should_return_exception_for_empty_task_name() {
            String task = "";

            Exception ex = assertThrows(IllegalArgumentException.class, () -> todo.addTask(task));

            assertThat(ex.getMessage(), is("Invalid task name"));
            assertThat(todo.getTasks(), not(hasItem(task)));
        }
    }

    @Nested
    @Tag("removeTask")
    class removeTask
    {
        @Test
        public void should_remove_existed_task_from_task_list()
        {
            //Arrange
            String task = "Go To School";

            todo.addTask("Go to cinema");
            todo.addTask(task);

            boolean status = todo.removeTask(task);
            assertThat(status, is(true));
            assertThat(todo.getTasks(), not(hasItem(task)));
        }

        @Test
        public void should_return_false_after_remove_task_unavailable()
        {
            String task = "Go To School";

            todo.addTask("Go to cinema");

            boolean status = todo.removeTask(task);
            assertThat(status, is(false));
        }

        @Test
        public void should_return_empty_list_after_remove_all_tasks()
        {
            //Arrange
            todo.addTask("Go to cinema");
            todo.addTask("Go To School");

            //Act
            todo.removeTasks();

            //Assert
            assertThat(todo.getTasks(), is(empty()));
        }
    }

    @Nested
    @Tag("completeTask")
    class completeTask
    {
        @Test
        public void should_remove_task_from_task_list_after_make_task_completed()
        {
            //Arrange
            String task = "Go To School";

            todo.addTask("Go to cinema");
            todo.addTask(task);

            //Act
            todo.completeTask(task);

            //Assert
            assertThat(todo.getTasks(), not(hasItem(task)));
            assertThat(todo.getTasks(), hasSize(1));
        }

        @Test
        public void should_throw_exception_after_make_unavailable_task_to_complete()
        {
            String task = "Go To School";

            todo.addTask(task);

            Exception ex = assertThrows(IllegalArgumentException.class, ()->todo.completeTask("Go to Cinema"));
            assertThat(ex.getMessage(), is("Unable to complete unavailable task"));
        }
    }
}
