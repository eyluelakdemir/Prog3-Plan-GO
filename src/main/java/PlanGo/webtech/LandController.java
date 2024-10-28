package PlanGo.webtech;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/laender")
public class LandController {
    private List<Land> laender = new ArrayList<>();

    // Beispiel-Daten
    public LandController() {
        laender.add(new Land("Deutschland", true, false));
        laender.add(new Land("Italien", false, true));
    }
}