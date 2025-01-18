package PlanGo.webtech.model;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LandTest {

    @Test
    void testLandToString() {

        final Land land = new Land(1L, "Deutschland", true, false);
        final String expectation = "Land(id=1, name=Deutschland, besucht=true, geplant=false)";
        final String result = land.toString();


        assertEquals(expectation, result);
    }

}