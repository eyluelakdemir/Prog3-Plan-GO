package PlanGo.webtech.model;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BudgetPlanerTest {

    @Test
    void testBudgetPlanerToString() {
        final BudgetPlaner budgetPlaner = new BudgetPlaner(1L, 100.0, 500.0, "Reisebudget");
        final String expectation = "BudgetPlaner(id=1, kosten=100.0, budget=500.0, beschreibung=Reisebudget)";
        final String result = budgetPlaner.toString();
        assertEquals(expectation, result);
    }
}