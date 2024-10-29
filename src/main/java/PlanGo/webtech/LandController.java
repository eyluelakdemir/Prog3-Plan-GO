package PlanGo.webtech;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/laender")
public class LandController {
    private List<Land> laender = new ArrayList<>();

    public LandController() {
        // Beispiel-Daten hinzufügen
        laender.add(new Land("Deutschland", true, false));
        laender.add(new Land("Italien", false, false));
        laender.add(new Land("Japan", false, false));
    }

    //Gibt die Liste aller Länder zurück
    @GetMapping("/laender")
    public List<Land> getLaender(@RequestParam(required = false) Boolean besucht,
                                 @RequestParam(required = false) Boolean geplant) {
        // Filtere nach besucht und geplant, falls Parameter übergeben werden
        return laender.stream()
                .filter(land -> (besucht == null || land.isBesucht() == besucht) &&
                        (geplant == null || land.isGeplant() == geplant))
                .collect(Collectors.toList());
    }
//Fügt ein neues Land hinzu
    @PostMapping("/laender")
    public void addLand(@RequestBody Land neuesLand) {
        laender.add(neuesLand);
    }
}