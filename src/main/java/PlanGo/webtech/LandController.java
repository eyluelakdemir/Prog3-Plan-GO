package PlanGo.webtech;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LandController {
    private List<Land> laender = new ArrayList<>();

    public LandController() {
        // Beispiel-Daten
        laender.add(new Land("Deutschland", true, false));
        laender.add(new Land("Italien", false, true));
        laender.add(new Land("Japan", false, false));
    }

    // GET-Route: Gibt die Liste aller Länder zurück
    @GetMapping("/laender")
    public List<Land> getLaender(@RequestParam(required = false) Boolean besucht,
                                 @RequestParam(required = false) Boolean geplant) {
        // Filtert nach "besucht" oder "geplant" falls Parameter übergeben werden
        return laender.stream()
                .filter(land -> (besucht == null || land.isBesucht() == besucht) &&
                        (geplant == null || land.isGeplant() == geplant))
                .collect(Collectors.toList());
    }

    // POST-Route: Fügt ein neues Land hinzu
    @PostMapping("/laender")
    public void addLand(@RequestBody Land neuesLand) {
        laender.add(neuesLand);
}
}