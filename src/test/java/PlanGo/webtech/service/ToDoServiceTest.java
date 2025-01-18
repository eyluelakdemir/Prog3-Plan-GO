package PlanGo.webtech.service;

import PlanGo.webtech.model.ToDo;
import PlanGo.webtech.repository.ToDoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class ToDoServiceTest {

    @Autowired
    private ToDoService service;

    @MockBean
    private ToDoRepository repository;

    @BeforeEach
    void setUpMockRepository() {
        final ToDo task1 = new ToDo(1L, "Buy groceries", "Personal", false);
        final ToDo task2 = new ToDo(2L, "Complete project", "Work", true);
        doReturn(List.of(task1, task2)).when(repository).findAll();
    }

    @Test
    void testGetCompletedToDos() {
        final Iterable<ToDo> resultAsIterable = service.getToDos();
        final List<ToDo> result = StreamSupport.stream(resultAsIterable.spliterator(), false)
                .filter(ToDo::isCompleted)
                .toList();

        assertSame(1, result.size(), "Number of completed tasks should be 1");
        assertEquals("Complete project", result.getFirst().getText(), "Task description should match 'Complete project'");
    }
}