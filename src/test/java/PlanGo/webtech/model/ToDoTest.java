package PlanGo.webtech.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class ToDoTest {

    @Test
    void testToDoToString() {

        final ToDo toDo = new ToDo(1L, "Reise planen", "Vorbereitung", false);
        final String expectation = "ToDo(id=1, text=Reise planen, category=Vorbereitung, completed=false)";
        final String result = toDo.toString();

        assertEquals(expectation, result);
    }

}