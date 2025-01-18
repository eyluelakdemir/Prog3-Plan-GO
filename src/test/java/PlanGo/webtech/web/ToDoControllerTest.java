package PlanGo.webtech.web;

import PlanGo.webtech.controller.ToDoController;
import PlanGo.webtech.model.ToDo;
import PlanGo.webtech.service.ToDoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ToDoController.class)
public class ToDoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToDoService service;

    @BeforeEach
    void setUpMockService() {
        final ToDo todoPreparation = new ToDo(1L, "Packen für Reise", "Vorbereitung", false);

        when(service.getToDoById(1L)).thenReturn(Optional.of(todoPreparation));
    }

    @Test
    void testGetToDoByIdPreparationCategory() throws Exception {
        final String expectation = "{\"id\":1,\"text\":\"Packen für Reise\",\"category\":\"Vorbereitung\",\"completed\":false}";
        this.mockMvc.perform(get("/api/todos/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectation));
    }

    @Test
    void testGetToDoByIdNotFound() throws Exception {
        this.mockMvc.perform(get("/api/todos/99"))
                .andExpect(status().isNotFound());
    }
}