package PlanGo.webtech.service;

import PlanGo.webtech.model.BudgetPlaner;
import PlanGo.webtech.repository.BudgetPlanerRepository;
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
public class BudgetPlanerServiceTest {

    @Autowired
    private BudgetPlanerService service;

    @MockBean
    private BudgetPlanerRepository repository;

    @BeforeEach
    void setUpMockRepository() {
        final BudgetPlaner budget1 = new BudgetPlaner(1L, 200.0, 1000.0, "Household Expenses");
        final BudgetPlaner budget2 = new BudgetPlaner(2L, 500.0, 2000.0, "Vacation");
        doReturn(List.of(budget1, budget2)).when(repository).findAll();
    }

    @Test
    void testGetBudgetsAboveThreshold() {
        final Iterable<BudgetPlaner> resultAsIterable = service.getAllBudgets();
        final List<BudgetPlaner> result = StreamSupport.stream(resultAsIterable.spliterator(), false)
                .filter(b -> b.getKosten() > 300.0)
                .toList();

        assertSame(1, result.size(), "Number of budgets above the threshold should be 1");
        assertEquals("Vacation", result.getFirst().getBeschreibung(), "Budget description should match Vacation");
    }
}