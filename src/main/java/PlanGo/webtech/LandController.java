package PlanGo.webtech;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/laender") // Basis-URL für alle Routen in diesem Controller
public class LandController {
    private List<Land> laender = new ArrayList<>();

    public LandController() {
        laender.add(new Land("Deutschland", true, false));
        laender.add(new Land("Italien", false, true));
        laender.add(new Land("Japan", false, false));
    }

    // Liste aller Länder zurück
    @GetMapping
    public List<Land> getLaender(@RequestParam(required = false) Boolean besucht,
                                 @RequestParam(required = false) Boolean geplant) {
        // Filtere nach besucht und geplant, falls Parameter übergeben werden
        return laender.stream()
                .filter(land -> (besucht == null || land.isBesucht() == besucht) &&
                        (geplant == null || land.isGeplant() == geplant))
                .toList();
    }
//
//
//    @PostMapping
//    public String addLand(@RequestBody Land neuesLand) {
//        laender.add(neuesLand);
//        return "Neues Land hinzugefügt: " + neuesLand.getName();
//    }
//
//    // Aktualisiert ein Land basierend auf dem Namen
//    @PutMapping("/{name}")
//    public String updateLand(@PathVariable String name, @RequestBody Land updatedLand) {
//        for (Land land : laender) {
//            if (land.getName().equalsIgnoreCase(name)) {
//                land.setBesucht(updatedLand.isBesucht());
//                land.setGeplant(updatedLand.isGeplant());
//                return "Land erfolgreich aktualisiert: " + name;
//            }
//        }
//        return "Land mit dem Namen nicht gefunden!";
//    }

}
