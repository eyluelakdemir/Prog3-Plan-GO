package PlanGo.webtech.web;

import PlanGo.webtech.controller.BudgetPlanerController;
import PlanGo.webtech.model.BudgetPlaner;
import PlanGo.webtech.service.BudgetPlanerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

@WebMvcTest(BudgetPlanerController.class)
public class BudgetPlanerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BudgetPlanerService service;

    @BeforeEach
    void setUpMockService() {
        final BudgetPlaner budget = new BudgetPlaner(1L, 500.0, 1000.0, "Reise");
        when(service.getBudgetById(1L)).thenReturn(Optional.of(budget));
    }

    @Test
    void testGetBudgetById() throws Exception {
        final String expectation = "{\"id\":1,\"kosten\":500.0,\"budget\":1000.0,\"beschreibung\":\"Reise\"}";
        this.mockMvc.perform(get("/api/budget/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectation));
    }
}