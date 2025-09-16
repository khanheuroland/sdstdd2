package Lesson2.Mock;

import Lesson2.Mock.ToDo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ToDoTest {
    @Test
    public void should_return_remaining_list_after_remove_a_task()
    {
        List<String> lstData = new ArrayList<>();
        lstData.add("go to school");
        lstData.add("go to cinema");

        ITodoRepository repository = mock();
        //Setup mock data
        when(repository.getListOfTasks()).thenReturn(lstData);
        ToDo todo = new ToDo(repository);
        List<String> lstRemaining = todo.removeTask("go to school");
        //Assertion
        assertThat(lstRemaining, allOf(hasItem("go to cinema"), not(hasItem("go to school"))));
        verify(repository, times(1)).saveData(anyList());
    }

    @Test
    public void should_return_exception_after_remove_not_existed_task()
    {
        List<String> lstData = new ArrayList<>();
        ITodoRepository repository = mock();
        //Setup mock
        when(repository.getListOfTasks()).thenReturn(lstData);

        ToDo todo = new ToDo(repository);
        Exception ex = assertThrows(IllegalArgumentException.class, ()->todo.removeTask("go to shool"));
        assertThat(ex.getMessage(), is("Task not found"));

    }
}
