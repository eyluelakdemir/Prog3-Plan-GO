package PlanGo.webtech.service;

import PlanGo.webtech.model.Land;
import PlanGo.webtech.repository.LandRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doReturn;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LandServiceTest {

    @Autowired
    private LandService service;

    @MockBean
    private LandRepository repository;

    @BeforeEach
    void setUpMockRepository() {
        final Land germany = new Land(1L, "Germany", true, false);
        final Land france = new Land(2L, "France", false, true);
        doReturn(List.of(germany, france)).when(repository).findAll();
    }

    @Test
    void testGetLaenderByGeplant() {
        final Iterable<Land> resultAsIterable = service.getLaender(false, true);
        final List<Land> result = StreamSupport.stream(resultAsIterable.spliterator(), false).toList();
        assertSame(1, result.size(), "Number of lands should be one for geplant=true and besucht=false");
        assertEquals("France", result.getFirst().getName(), "Land name should match France");
    }
}