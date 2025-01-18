package PlanGo.webtech.web;

import PlanGo.webtech.controller.LandController;
import PlanGo.webtech.model.Land;
import PlanGo.webtech.service.LandService;
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

@WebMvcTest(LandController.class)
public class LandControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LandService service;

    @BeforeEach
    void setUpMockService() {
        final Land land = new Land(1L, "Deutschland", true, false);
        when(service.getLand(1L)).thenReturn(Optional.of(land));
    }

    @Test
    void testGetLandById() throws Exception {
        final String expectation = "{\"id\":1,\"name\":\"Deutschland\",\"besucht\":true,\"geplant\":false}";
        this.mockMvc.perform(get("/api/laender/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectation));
    }
}
